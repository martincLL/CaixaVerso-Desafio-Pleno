package com.caixa.caixaverso_desafio.repositories;

import com.caixa.caixaverso_desafio.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Optional<Produto> findFirstByTipo(String tipo);

    List<Produto> findByRiscoIn(List<String> riscos);
}
