package com.caixa.caixaverso_desafio.controllers;

import com.caixa.caixaverso_desafio.dtos.HistoricoInvestimentoDTO;
import com.caixa.caixaverso_desafio.services.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("investimentos")
public class HistoricoController {

    @Autowired
    private HistoricoService historicoService;

    @GetMapping(value = "/{clienteId}")
    public ResponseEntity<List<HistoricoInvestimentoDTO>> getInvestimentos(@PathVariable Long clienteId) {

        List<HistoricoInvestimentoDTO> investimentos = historicoService.getInvestimentosPorClienteId(clienteId);

        return ResponseEntity.ok(investimentos);
    }
}
