package com.caixa.caixaverso_desafio.controllers;

import com.caixa.caixaverso_desafio.dtos.PerfilRiscoDTO;
import com.caixa.caixaverso_desafio.services.PerfilRiscoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("perfil-risco")
public class PerfilRiscoController {

    @Autowired
    private PerfilRiscoService perfilRiscoService;

    @GetMapping(value = "/{clienteId}")
    public ResponseEntity<PerfilRiscoDTO> getPerfilRisco(@PathVariable Long clienteId) {

        PerfilRiscoDTO perfilRisco = perfilRiscoService.calcularPerfilRisco(clienteId);

        return ResponseEntity.ok(perfilRisco);
    }
}
