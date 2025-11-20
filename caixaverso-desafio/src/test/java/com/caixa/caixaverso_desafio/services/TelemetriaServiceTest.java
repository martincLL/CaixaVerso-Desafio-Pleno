package com.caixa.caixaverso_desafio.services;

import com.caixa.caixaverso_desafio.dtos.TelemetriaDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class TelemetriaServiceTest {

    @InjectMocks
    private TelemetriaService telemetriaService;

    @Test
    @DisplayName("Deve registrar chamadas e calcular o tempo")
    void registrarDadosChamada() {

        String uri = "api/teste";
        telemetriaService.registrarChamada(uri, 10L);
        telemetriaService.registrarChamada(uri, 40L);

        TelemetriaDTO telemetria = telemetriaService.criarRelatorio();

        assertNotNull(telemetria);
        assertEquals(1, telemetria.getServicos().size());
        assertEquals("api/teste", telemetria.getServicos().get(0).getNome());
        assertEquals(2L, telemetria.getServicos().get(0).getQuantidadeChamadas());
        assertEquals(25L, telemetria.getServicos().get(0).getMediaTempoRespostaMs());
    }
}
