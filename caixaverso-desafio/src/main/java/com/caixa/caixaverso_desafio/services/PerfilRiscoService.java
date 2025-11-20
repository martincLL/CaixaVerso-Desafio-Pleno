package com.caixa.caixaverso_desafio.services;

import com.caixa.caixaverso_desafio.dtos.PerfilRiscoDTO;
import com.caixa.caixaverso_desafio.entities.Cliente;
import com.caixa.caixaverso_desafio.exceptions.AppException;
import com.caixa.caixaverso_desafio.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class PerfilRiscoService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public PerfilRiscoDTO calcularPerfilRisco(Long clienteId) {

        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new AppException("Cliente não encontrado", HttpStatus.NOT_FOUND));

        int pontuacao = calcularPontuacao(cliente);

        String perfil;
        String descricao;

        if(pontuacao <= 35) {
            perfil = "Conservador";
            descricao = "Perfil conservador visando segurança e liquidez.";
        } else if(pontuacao <= 70) {
            perfil = "Moderado";
            descricao = "Perfil equilibrado entre segurança e rentabilidade.";
        } else {
            perfil = "Agressivo";
            descricao = "Perfil agressivo buscando alta rentabilidade a longo prazo.";
        }

        cliente.setPontuacao(pontuacao);
        cliente.setPerfil(perfil);
        clienteRepository.save(cliente);

        return new PerfilRiscoDTO(cliente.getId(), perfil, pontuacao, descricao);
    }

    private int calcularPontuacao(Cliente cliente) {

        int pontos = 0;

        BigDecimal quantidade = cliente.getVolumeInvestimentos();
        if(quantidade.compareTo(new BigDecimal("40000")) > 0) {
            pontos += 45;
        } else if(quantidade.compareTo(new BigDecimal("10000")) > 0) {
            pontos += 25;
        } else {
            pontos += 15;
        }

        Integer frequenciaMovimentacao = cliente.getFrequenciaMovimentacoes();
        if(frequenciaMovimentacao > 10) {
            pontos += 25;
        } else if(frequenciaMovimentacao > 3) {
            pontos += 10;
        } else {
            pontos += 5;
        }

        String preferencia = cliente.getPreferencia();
        if(preferencia != null && preferencia.equalsIgnoreCase("Liquidez")) {
            pontos += 0;
        } else if(preferencia != null && preferencia.equalsIgnoreCase("Rentabilidade")) {
            pontos += 30;
        } else {
            pontos += 15;
        }

        return pontos;
    }
}
