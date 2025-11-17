package com.caixa.caixaverso_desafio.repositories;

import com.caixa.caixaverso_desafio.entities.Simulacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimulacaoRepository extends JpaRepository<Simulacao, Long> {
}
