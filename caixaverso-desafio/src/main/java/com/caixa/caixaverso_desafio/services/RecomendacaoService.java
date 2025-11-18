package com.caixa.caixaverso_desafio.services;

import com.caixa.caixaverso_desafio.dtos.ProdutoRecomendadoDTO;
import com.caixa.caixaverso_desafio.entities.Produto;
import com.caixa.caixaverso_desafio.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecomendacaoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional(readOnly = true)
    public List<ProdutoRecomendadoDTO> recomendarProdutos(String perfilCliente) {

        List<String> riscos;

        if(perfilCliente.equalsIgnoreCase("Conservador")) {
            riscos = List.of("Baixo");
        } else if(perfilCliente.equalsIgnoreCase("Moderado")) {
            riscos = List.of("Baixo", "Médio");
        } else if(perfilCliente.equalsIgnoreCase("Agressivo")) {
            riscos = List.of("Baixo", "Médio", "Alto");
        } else {
            riscos = List.of("Baixo");
        }

        List<Produto> produtos = produtoRepository.findByRiscoIn(riscos);

        return produtos.stream().map(ProdutoRecomendadoDTO::new)
                .collect(Collectors.toList());
    }
}
