package com.caixa.caixaverso_desafio.controllers;

import com.caixa.caixaverso_desafio.dtos.ProdutoRecomendadoDTO;
import com.caixa.caixaverso_desafio.services.RecomendacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("produtos-recomendados")
public class RecomendacaoController {

    @Autowired
    private RecomendacaoService recomendacaoService;

    @GetMapping(value = "/{perfil}")
    public ResponseEntity<List<ProdutoRecomendadoDTO>> getProdutosRecomendadosPorPerfil(@PathVariable String perfil) {

        List<ProdutoRecomendadoDTO> produtos = recomendacaoService.recomendarProdutos(perfil);

        return ResponseEntity.ok(produtos);
    }
}
