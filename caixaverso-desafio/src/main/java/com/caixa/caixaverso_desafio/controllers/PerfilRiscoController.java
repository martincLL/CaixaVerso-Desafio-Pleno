package com.caixa.caixaverso_desafio.controllers;

import com.caixa.caixaverso_desafio.dtos.PerfilRiscoDTO;
import com.caixa.caixaverso_desafio.services.PerfilRiscoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("perfil-risco")
@Tag(name = "Perfil de Risco", description = "Definição do perfil do cliente")
public class PerfilRiscoController {

    @Autowired
    private PerfilRiscoService perfilRiscoService;

    @Operation(summary = "Calcular Perfil de Risco", description = "Analisa histórico e define o perfil de investidor do cliente")
    @ApiResponses(@ApiResponse(responseCode = "200"))
    @GetMapping(value = "/{clienteId}")
    public ResponseEntity<PerfilRiscoDTO> getPerfilRisco(@PathVariable Long clienteId) {

        PerfilRiscoDTO perfilRisco = perfilRiscoService.calcularPerfilRisco(clienteId);

        return ResponseEntity.ok(perfilRisco);
    }
}
