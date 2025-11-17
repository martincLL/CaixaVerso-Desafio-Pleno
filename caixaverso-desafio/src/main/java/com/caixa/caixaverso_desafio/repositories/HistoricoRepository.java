package com.caixa.caixaverso_desafio.repositories;

import com.caixa.caixaverso_desafio.entities.Historico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Long> {
}
