package com.caixa.caixaverso_desafio.services;

import com.caixa.caixaverso_desafio.dtos.HistoricoSimulacaoDTO;
import com.caixa.caixaverso_desafio.dtos.SimulacaoRequestDTO;
import com.caixa.caixaverso_desafio.dtos.SimulacaoResponseDTO;
import com.caixa.caixaverso_desafio.entities.Produto;
import com.caixa.caixaverso_desafio.entities.Simulacao;
import com.caixa.caixaverso_desafio.repositories.ProdutoRepository;
import com.caixa.caixaverso_desafio.repositories.SimulacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SimulacaoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private SimulacaoRepository simulacaoRepository;

    @Transactional
    public SimulacaoResponseDTO simularInvestimento(SimulacaoRequestDTO requestDTO) {

        Produto produtoSimulacao = produtoRepository.findByTipo(requestDTO.getTipoProduto())
                .orElseThrow(() -> new RuntimeException("Esse tipo de produto não foi encontrado"));

        if(requestDTO.getValor().compareTo(produtoSimulacao.getValorMinimo()) < 0) {
            throw new RuntimeException("O valor da simulação está abaixo do mínimo permitido");
        }
        if(requestDTO.getPrazoMeses() < produtoSimulacao.getPrazoMinimoMeses()) {
            throw new RuntimeException("O prazo da simulação está abaixo do mínimo permitido");
        }

        BigDecimal valorFinal = calcularValorLiquido(requestDTO.getValor(), produtoSimulacao.getRentabilidade(), requestDTO.getPrazoMeses(), produtoSimulacao.getTipo());

        Simulacao simulacao = new Simulacao();
        simulacao.setClienteId(requestDTO.getClienteId());
        simulacao.setProduto(produtoSimulacao.getNome());
        simulacao.setValorInvestido(requestDTO.getValor());
        simulacao.setValorFinal(valorFinal.setScale(2, RoundingMode.HALF_UP));
        simulacao.setRentabilidadeEfetiva(produtoSimulacao.getRentabilidade());
        simulacao.setPrazoMeses(requestDTO.getPrazoMeses());
        simulacao.setDataSimulacao(LocalDateTime.now());
        Simulacao simulacaoSalva = simulacaoRepository.save(simulacao);

        return new SimulacaoResponseDTO(produtoSimulacao, simulacaoSalva);
    }

    private BigDecimal calcularValorLiquido(BigDecimal capital, BigDecimal taxaAnual, Integer prazoMeses, String tipoProduto) {

        BigDecimal valorBruto = calcularValorBruto(capital, taxaAnual, prazoMeses);

        if(tipoProduto.equalsIgnoreCase("LCI") || tipoProduto.equalsIgnoreCase("LCA")) {
            return valorBruto;
        }

        BigDecimal rendimento = valorBruto.subtract(capital);

        if(rendimento.compareTo(BigDecimal.ZERO) <= 0) {
            return valorBruto;
        }

        BigDecimal impostoInvestimento = aliquotaIR(prazoMeses);
        BigDecimal impostoAPagar = rendimento.multiply(impostoInvestimento);

        return valorBruto.subtract(impostoAPagar);
    }

    private BigDecimal calcularValorBruto(BigDecimal capital, BigDecimal taxaAnual, Integer prazoMeses) {

        BigDecimal taxaMensal = BigDecimal.valueOf(Math.pow(1 + taxaAnual.doubleValue(), 1.0 / 12.0) - 1);

        BigDecimal fatorDeAcumulacao = taxaMensal.add(BigDecimal.ONE).pow(prazoMeses);

        return capital.multiply(fatorDeAcumulacao);
    }

    private BigDecimal aliquotaIR(Integer prazoMeses) {

        int prazoDias = prazoMeses * 30;

        if(prazoDias <= 180) {
            return new BigDecimal("0.225");
        } else if(prazoDias <= 360) {
            return new BigDecimal("0.20");
        } else if(prazoDias <= 720) {
            return new BigDecimal("0.175");
        } else {
            return new BigDecimal("0.15");
        }
    }

    @Transactional(readOnly = true)
    public List<HistoricoSimulacaoDTO> getHistoricoSimulacoes() {

        List<Simulacao> simulacoes = simulacaoRepository.findAll();

        return simulacoes.stream().map(HistoricoSimulacaoDTO::new)
                .collect(Collectors.toList());
    }
}
