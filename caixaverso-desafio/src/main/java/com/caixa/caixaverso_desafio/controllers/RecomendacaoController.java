package com.caixa.caixaverso_desafio.controllers;

import com.caixa.caixaverso_desafio.dtos.ProdutoRecomendadoDTO;
import com.caixa.caixaverso_desafio.services.RecomendacaoService;
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
@RequestMapping("produtos-recomendados")
@Tag(name = "Recomendação de Produtos", description = "Recomenda produtos de investimento para cada perfil")
public class RecomendacaoController {

    @Autowired
    private RecomendacaoService recomendacaoService;

    @Operation(summary = "Buscar produtos específico para cada perfil", description = "Retorna uma lista de produtos adequados para o perfil do cliente")
    @ApiResponses(@ApiResponse(responseCode = "200"))
    @GetMapping(value = "/{perfil}")
    public ResponseEntity<List<ProdutoRecomendadoDTO>> getProdutosRecomendadosPorPerfil(@PathVariable String perfil) {

        List<ProdutoRecomendadoDTO> produtos = recomendacaoService.recomendarProdutos(perfil);

        return ResponseEntity.ok(produtos);
    }
}
