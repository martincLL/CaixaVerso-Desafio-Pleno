package com.caixa.caixaverso_desafio.services;

import com.caixa.caixaverso_desafio.dtos.ProdutoRecomendadoDTO;
import com.caixa.caixaverso_desafio.entities.Produto;
import com.caixa.caixaverso_desafio.repositories.ProdutoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RecomendacaoServiceTest {

    @InjectMocks
    private RecomendacaoService recomendacaoService;

    @Mock
    private ProdutoRepository produtoRepository;

    @Test
    @DisplayName("Recomendar produtos de risco baixo para cliente conservador")
    void recomendarProdutoClienteConservador() {

        Produto produtoTeste = new Produto();
        produtoTeste.setId(1l);
        produtoTeste.setNome("Tesouro Selic");
        produtoTeste.setRisco("Baixo");
        produtoTeste.setRentabilidade(new BigDecimal("0.10"));

        when(produtoRepository.findByRiscoIn(anyList())).thenReturn(List.of(produtoTeste));

        List<ProdutoRecomendadoDTO> recomendados = recomendacaoService.recomendarProdutos("Conservador");

        assertFalse(recomendados.isEmpty());
        assertEquals("Tesouro Selic", recomendados.get(0).getNome());

        verify(produtoRepository).findByRiscoIn(argThat(riscos -> riscos.contains("Baixo") && riscos.size() == 1));
    }

    @Test
    @DisplayName("Recomendar produtos de risco baixo e médio para cliente moderado")
    void recomendarProdutoClienteModerado() {

        Produto produtoTeste = new Produto();
        produtoTeste.setId(1l);
        produtoTeste.setNome("Tesouro Direto 2035");
        produtoTeste.setRisco("Médio");
        produtoTeste.setRentabilidade(new BigDecimal("0.13"));

        when(produtoRepository.findByRiscoIn(anyList())).thenReturn(List.of(produtoTeste));

        List<ProdutoRecomendadoDTO> recomendados = recomendacaoService.recomendarProdutos("Moderado");

        assertFalse(recomendados.isEmpty());
        assertEquals("Tesouro Direto 2035", recomendados.get(0).getNome());

        verify(produtoRepository).findByRiscoIn(argThat(riscos -> riscos.contains("Médio") && riscos.size() == 2));
    }

    @Test
    @DisplayName("Recomendar produtos de risco baixo, médio e alto para cliente agressivo")
    void recomendarProdutoClienteAgressivo() {

        Produto produtoTeste = new Produto();
        produtoTeste.setId(1l);
        produtoTeste.setNome("Fundo CAIXA Agressivo");
        produtoTeste.setRisco("Alto");
        produtoTeste.setRentabilidade(new BigDecimal("0.18"));

        when(produtoRepository.findByRiscoIn(anyList())).thenReturn(List.of(produtoTeste));

        List<ProdutoRecomendadoDTO> recomendados = recomendacaoService.recomendarProdutos("Agressivo");

        assertFalse(recomendados.isEmpty());
        assertEquals("Fundo CAIXA Agressivo", recomendados.get(0).getNome());

        verify(produtoRepository).findByRiscoIn(argThat(riscos -> riscos.contains("Alto") && riscos.size() == 3));
    }
}
