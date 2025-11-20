package com.caixa.caixaverso_desafio.controllers;

import com.caixa.caixaverso_desafio.dtos.HistoricoSimulacaoDTO;
import com.caixa.caixaverso_desafio.dtos.RelatorioSimulacaoDTO;
import com.caixa.caixaverso_desafio.dtos.SimulacaoRequestDTO;
import com.caixa.caixaverso_desafio.dtos.SimulacaoResponseDTO;
import com.caixa.caixaverso_desafio.services.SimulacaoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SimulacaoControllerTest {

    @InjectMocks
    private SimulacaoController simulacaoController;

    @Mock
    private SimulacaoService simulacaoService;

    @Test
    @DisplayName("Deve realizar a simulação do investimento de forma correta")
    void simularInvestimentoSucesso() {
        SimulacaoRequestDTO request = new SimulacaoRequestDTO();
        request.setClienteId(1L);
        request.setTipoProduto("CDB");
        request.setValor(new BigDecimal("15000.00"));
        request.setPrazoMeses(12);

        SimulacaoResponseDTO response = new SimulacaoResponseDTO();
        when(simulacaoService.simularInvestimento(request)).thenReturn(response);

        ResponseEntity<SimulacaoResponseDTO> resultado = simulacaoController.simularInvestimento(request);
        assertNotNull(resultado);
        assertEquals(HttpStatus.CREATED, resultado.getStatusCode());
        assertEquals(response, resultado.getBody());

        verify(simulacaoService).simularInvestimento(request);
    }

    @Test
    @DisplayName("Deve retornar o histórico das simulações realizadas")
    void retornarHistoricoSimulacoes() {

        HistoricoSimulacaoDTO historicoSimulacao1 = new HistoricoSimulacaoDTO();
        historicoSimulacao1.setProduto("CDB Caixa");
        historicoSimulacao1.setValorInvestido(new BigDecimal("8000.00"));

        HistoricoSimulacaoDTO historicoSimulacao2 = new HistoricoSimulacaoDTO();
        historicoSimulacao2.setProduto("LCI Caixa");
        historicoSimulacao2.setValorInvestido(new BigDecimal("4000.00"));

        List<HistoricoSimulacaoDTO> listaHistorico = List.of(historicoSimulacao1, historicoSimulacao2);
        when(simulacaoService.getHistoricoSimulacoes()).thenReturn(listaHistorico);

        ResponseEntity<List<HistoricoSimulacaoDTO>> resultado = simulacaoController.getHistorico();
        assertEquals(HttpStatus.OK, resultado.getStatusCode());
        assertEquals(2, resultado.getBody().size());
        assertEquals("CDB Caixa", resultado.getBody().get(0).getProduto());
        assertEquals(new BigDecimal("8000.00"), resultado.getBody().get(0).getValorInvestido());
    }

    @Test
    @DisplayName("Deve retornar o relatório das simulações realizadas")
    void retornarRelatorioSimulacoes() {

        RelatorioSimulacaoDTO relatorioSimulacao = new RelatorioSimulacaoDTO("Fundo Caixa", LocalDate.now(), 15L, 2000.00);

        List<RelatorioSimulacaoDTO> listaRelatorio = List.of(relatorioSimulacao);
        when(simulacaoService.relatorioProdutoDia()).thenReturn(listaRelatorio);

        ResponseEntity<List<RelatorioSimulacaoDTO>> resultado = simulacaoController.getRelatorioAgregado();
        assertEquals(HttpStatus.OK, resultado.getStatusCode());
        assertNotNull(resultado.getBody());
        assertEquals("Fundo Caixa", resultado.getBody().get(0).getProduto());
        assertEquals(15L, resultado.getBody().get(0).getQuantidadeSimulacoes());
    }
}
