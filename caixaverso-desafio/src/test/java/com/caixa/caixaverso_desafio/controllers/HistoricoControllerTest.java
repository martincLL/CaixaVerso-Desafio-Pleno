package com.caixa.caixaverso_desafio.controllers;

import com.caixa.caixaverso_desafio.dtos.HistoricoInvestimentoDTO;
import com.caixa.caixaverso_desafio.dtos.HistoricoSimulacaoDTO;
import com.caixa.caixaverso_desafio.services.HistoricoService;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HistoricoControllerTest {

    @InjectMocks
    private HistoricoController historicoController;

    @Mock
    private HistoricoService historicoService;

    @Test
    @DisplayName("Deve retornar uma lista com os investimentos do clienete")
    void retornarListaInvestimentosCliente() {

        HistoricoInvestimentoDTO historicoInvestimento = new HistoricoInvestimentoDTO();
        historicoInvestimento.setTipo("CDB");
        historicoInvestimento.setValor(new BigDecimal("4000.00"));
        historicoInvestimento.setRentabilidade(new BigDecimal("0.11"));
        historicoInvestimento.setData(LocalDate.now());

        List<HistoricoInvestimentoDTO> listaHistoricoInvestimento = List.of(historicoInvestimento);
        when(historicoService.getInvestimentosPorClienteId(1L)).thenReturn(listaHistoricoInvestimento);

        ResponseEntity<List<HistoricoInvestimentoDTO>> resultado = historicoController.getInvestimentos(1L);
        assertNotNull(resultado);
        assertEquals(HttpStatus.OK, resultado.getStatusCode());
        assertEquals(1, resultado.getBody().size());
        assertEquals(new BigDecimal("4000.00"), resultado.getBody().get(0).getValor());
        assertEquals("CDB", resultado.getBody().get(0).getTipo());
    }
}
