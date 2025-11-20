package com.caixa.caixaverso_desafio.controllers;

import com.caixa.caixaverso_desafio.dtos.PerfilRiscoDTO;
import com.caixa.caixaverso_desafio.services.PerfilRiscoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PerfilRiscoControllerTest {

    @InjectMocks
    private PerfilRiscoController perfilRiscoController;

    @Mock
    PerfilRiscoService perfilRiscoService;

    @Test
    @DisplayName("Deve retornar o perfil de risco do cliente")
    void calcularPerfilRisco() {

        PerfilRiscoDTO perfilRisco = new PerfilRiscoDTO();
        perfilRisco.setClienteId(1L);
        perfilRisco.setPerfil("Moderado");
        perfilRisco.setPontuacao(55);
        perfilRisco.setDescricao("Perfil Equilibrado");

        when(perfilRiscoService.calcularPerfilRisco(1L)).thenReturn(perfilRisco);

        ResponseEntity<PerfilRiscoDTO> resultado = perfilRiscoController.getPerfilRisco(1L);
        assertNotNull(resultado);
        assertEquals(HttpStatus.OK, resultado.getStatusCode());
        assertEquals("Moderado", resultado.getBody().getPerfil());
        assertEquals(55, resultado.getBody().getPontuacao());

    }
}
