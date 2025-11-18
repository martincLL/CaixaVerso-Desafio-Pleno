package com.caixa.caixaverso_desafio.controllers;

import com.caixa.caixaverso_desafio.dtos.HistoricoSimulacaoDTO;
import com.caixa.caixaverso_desafio.dtos.SimulacaoRequestDTO;
import com.caixa.caixaverso_desafio.dtos.SimulacaoResponseDTO;
import com.caixa.caixaverso_desafio.services.SimulacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SimulacaoController {

    @Autowired
    private SimulacaoService simulacaoService;

    @GetMapping("/simulacoes")
    public ResponseEntity<List<HistoricoSimulacaoDTO>> getHistorico() {

        List<HistoricoSimulacaoDTO> historico = simulacaoService.getHistoricoSimulacoes();
        return ResponseEntity.ok(historico);
    }

    @PostMapping("/simular-investimento")
    public ResponseEntity<SimulacaoResponseDTO> simularInvestimento(@RequestBody SimulacaoRequestDTO request) {

        SimulacaoResponseDTO response = simulacaoService.simularInvestimento(request);
        return ResponseEntity.ok(response);
    }
}
