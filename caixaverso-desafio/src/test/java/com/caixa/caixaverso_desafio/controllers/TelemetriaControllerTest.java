package com.caixa.caixaverso_desafio.controllers;

import com.caixa.caixaverso_desafio.dtos.PeriodoDTO;
import com.caixa.caixaverso_desafio.dtos.TelemetriaDTO;
import com.caixa.caixaverso_desafio.dtos.TelemetriaServicoDTO;
import com.caixa.caixaverso_desafio.services.TelemetriaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TelemetriaControllerTest {

    @InjectMocks
    private TelemetriaController telemetriaController;

    @Mock
    private TelemetriaService telemetriaService;

    @Test
    @DisplayName("Deve retornar o relatório de telemetria")
    void retornaTelemetria() {

        TelemetriaServicoDTO telemetriaServico = new TelemetriaServicoDTO("simular-investimento", 20L, 70L);
        PeriodoDTO periodo = new PeriodoDTO(LocalDateTime.now().minusHours(1), LocalDateTime.now());

        TelemetriaDTO telemetria = new TelemetriaDTO(List.of(telemetriaServico), periodo);
        when(telemetriaService.criarRelatorio()).thenReturn(telemetria);

        ResponseEntity<TelemetriaDTO> resultado = telemetriaController.getTelemetria();
        assertNotNull(resultado);
        assertEquals(HttpStatus.OK, resultado.getStatusCode());
        assertEquals(1, resultado.getBody().getServicos().size());
        assertEquals("simular-investimento", resultado.getBody().getServicos().get(0).getNome());
        assertEquals(20L, resultado.getBody().getServicos().get(0).getQuantidadeChamadas());
        assertEquals(70L, resultado.getBody().getServicos().get(0).getMediaTempoRespostaMs());
    }
}
