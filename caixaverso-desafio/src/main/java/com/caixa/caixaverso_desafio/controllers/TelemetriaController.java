package com.caixa.caixaverso_desafio.controllers;

import com.caixa.caixaverso_desafio.dtos.TelemetriaDTO;
import com.caixa.caixaverso_desafio.services.TelemetriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/telemetria")
@Tag(name = "Telemetria", description = "Dados do uso da API")
public class TelemetriaController {

    @Autowired
    private TelemetriaService telemetriaService;

    @Operation(summary = "Exibir os dados de uso da API", description = "Retorna número de chamadas e tempo de resposta dos endpoints")
    @ApiResponses(@ApiResponse(responseCode = "200"))
    @GetMapping
    public ResponseEntity<TelemetriaDTO> getTelemetria() {

        return ResponseEntity.ok(telemetriaService.criarRelatorio());
    }
}
