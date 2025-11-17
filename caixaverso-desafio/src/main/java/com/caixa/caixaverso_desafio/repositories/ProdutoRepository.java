package com.caixa.caixaverso_desafio.repositories;

import com.caixa.caixaverso_desafio.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
