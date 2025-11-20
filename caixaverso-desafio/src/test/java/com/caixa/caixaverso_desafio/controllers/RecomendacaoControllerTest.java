package com.caixa.caixaverso_desafio.controllers;

import com.caixa.caixaverso_desafio.dtos.ProdutoRecomendadoDTO;
import com.caixa.caixaverso_desafio.services.RecomendacaoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RecomendacaoControllerTest {

    @InjectMocks
    private RecomendacaoController recomendacaoController;

    @Mock
    private RecomendacaoService recomendacaoService;

    @Test
    @DisplayName("Deve retornar os produtos recomendados de acordo com o perfil do cliente")
    void retornarRecomendacaoProduto() {

        ProdutoRecomendadoDTO produtoRecomendado = new ProdutoRecomendadoDTO();
        produtoRecomendado.setNome("Fundo Caixa");
        produtoRecomendado.setRisco("Médio");
        produtoRecomendado.setRentabilidade(new BigDecimal("0.14"));

        List<ProdutoRecomendadoDTO> listaRecomendacoes = List.of(produtoRecomendado);
        when(recomendacaoService.recomendarProdutos("Moderado")).thenReturn(listaRecomendacoes);

        ResponseEntity<List<ProdutoRecomendadoDTO>> resultado = recomendacaoController.getProdutosRecomendadosPorPerfil("Moderado");
        assertNotNull(resultado);
        assertEquals(HttpStatus.OK, resultado.getStatusCode());
        assertEquals(1, resultado.getBody().size());
        assertEquals("Fundo Caixa", resultado.getBody().get(0).getNome());
        assertEquals(new BigDecimal("0.14"), resultado.getBody().get(0).getRentabilidade());
    }
}
