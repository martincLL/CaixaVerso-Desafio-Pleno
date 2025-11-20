package com.caixa.caixaverso_desafio.services;

import com.caixa.caixaverso_desafio.dtos.SimulacaoRequestDTO;
import com.caixa.caixaverso_desafio.dtos.SimulacaoResponseDTO;
import com.caixa.caixaverso_desafio.entities.Produto;
import com.caixa.caixaverso_desafio.entities.Simulacao;
import com.caixa.caixaverso_desafio.repositories.ProdutoRepository;
import com.caixa.caixaverso_desafio.repositories.SimulacaoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class SimulacaoServiceTest {

    @InjectMocks
    private SimulacaoService simulacaoService;

    @Mock
    private ProdutoRepository produtoRepository;

    @Mock
    private SimulacaoRepository simulacaoRepository;

    @Test
    @DisplayName("Deve realizar a simulação de um produto tipo CDB com sucesso")
    void simularProdutoCDBSucesso() {

        Produto produtoTeste = new Produto();
        produtoTeste.setId(1L);
        produtoTeste.setNome("CDB Teste");
        produtoTeste.setTipo("CDB");
        produtoTeste.setRentabilidade(new BigDecimal("0.12"));
        produtoTeste.setValorMinimo(new BigDecimal("3000.00"));
        produtoTeste.setPrazoMinimoMeses(12);
        produtoTeste.setRisco("Baixo");

        SimulacaoRequestDTO request = new SimulacaoRequestDTO();
        request.setClienteId(1L);
        request.setTipoProduto("CDB");
        request.setValor(new BigDecimal("15000.00"));
        request.setPrazoMeses(12);

        when(produtoRepository.findFirstByTipo("CDB")).thenReturn(Optional.of(produtoTeste));
        when(simulacaoRepository.save(any(Simulacao.class))).thenAnswer(x -> x.getArguments()[0]);

        SimulacaoResponseDTO response = simulacaoService.simularInvestimento(request);
        assertNotNull(response);
        assertEquals("CDB Teste", response.getProdutoValidado().getNome());
        assertTrue(response.getResultadoSimulacao().getValorFinal().compareTo(new BigDecimal("15000")) > 0);
        assertEquals(12, response.getResultadoSimulacao().getPrazoMeses());
        verify(simulacaoRepository, times(1)).save(any(Simulacao.class));
    }

    @Test
    @DisplayName("Deve realizar a simulação de um produto tipo LCI/LCA com sucesso")
    void simularProdutoLCISucesso() {

        Produto produtoTeste = new Produto();
        produtoTeste.setValorMinimo(new BigDecimal("2500.00"));
        produtoTeste.setPrazoMinimoMeses(9);
        produtoTeste.setRentabilidade(new BigDecimal("0.09"));
        produtoTeste.setTipo("LCI");

        SimulacaoRequestDTO request = new SimulacaoRequestDTO();
        request.setTipoProduto("LCI");
        request.setValor(new BigDecimal("5000.00"));
        request.setPrazoMeses(11);

        when(produtoRepository.findFirstByTipo("LCI")).thenReturn(Optional.of(produtoTeste));
        when(simulacaoRepository.save(any(Simulacao.class))).thenAnswer(x -> x.getArguments()[0]);

        SimulacaoResponseDTO response = simulacaoService.simularInvestimento(request);
        assertNotNull(response);
        assertEquals("LCI", response.getProdutoValidado().getTipo());
        assertEquals(11, response.getResultadoSimulacao().getPrazoMeses());
    }

    @Test
    @DisplayName("Deve falhar na simulação em que o prazo for menor que o mínimo exigido pelo produto")
    void simularPrazoAbaixoError() {

        Produto produtoTeste = new Produto();
        produtoTeste.setValorMinimo(new BigDecimal("550.00"));
        produtoTeste.setPrazoMinimoMeses(6);

        SimulacaoRequestDTO request = new SimulacaoRequestDTO();
        request.setTipoProduto("CDB");
        request.setValor(new BigDecimal("1500.00"));
        request.setPrazoMeses(5);

        when(produtoRepository.findFirstByTipo("CDB")).thenReturn(Optional.of(produtoTeste));

        RuntimeException e = assertThrows(RuntimeException.class, () -> simulacaoService.simularInvestimento(request));

        assertEquals("O prazo da simulação está abaixo do mínimo permitido", e.getMessage());
        verify(simulacaoRepository, never()).save(any());
    }

    @Test
    @DisplayName("Deve falhar na simulação em que o valor for menor que o mínimo exigido pelo produto")
    void simularValorAbaixoError() {

        Produto produtoTeste = new Produto();
        produtoTeste.setValorMinimo(new BigDecimal("8000.00"));

        SimulacaoRequestDTO request = new SimulacaoRequestDTO();
        request.setTipoProduto("CDB");
        request.setValor(new BigDecimal("4500.00"));

        when(produtoRepository.findFirstByTipo("CDB")).thenReturn(Optional.of(produtoTeste));

        RuntimeException e = assertThrows(RuntimeException.class, () -> simulacaoService.simularInvestimento(request));
        assertEquals("O valor da simulação está abaixo do mínimo permitido", e.getMessage());
        verify(simulacaoRepository, never()).save(any());
    }
}
