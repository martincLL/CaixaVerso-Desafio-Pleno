package com.caixa.caixaverso_desafio.controllers;

import com.caixa.caixaverso_desafio.dtos.HistoricoInvestimentoDTO;
import com.caixa.caixaverso_desafio.services.HistoricoService;
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

import java.util.List;

@RestController
@RequestMapping("investimentos")
@Tag(name = "Histórico de Investimentos", description = "Apresenta o histórico de investimento de cada cliente")
public class HistoricoController {

    @Autowired
    private HistoricoService historicoService;

    @Operation(summary = "Retornar Histórico de Investimento", description = "Retorna todo o histórico de investimento do cliente")
    @ApiResponses(@ApiResponse(responseCode = "200"))
    @GetMapping(value = "/{clienteId}")
    public ResponseEntity<List<HistoricoInvestimentoDTO>> getInvestimentos(@PathVariable Long clienteId) {

        List<HistoricoInvestimentoDTO> investimentos = historicoService.getInvestimentosPorClienteId(clienteId);

        return ResponseEntity.ok(investimentos);
    }
}
