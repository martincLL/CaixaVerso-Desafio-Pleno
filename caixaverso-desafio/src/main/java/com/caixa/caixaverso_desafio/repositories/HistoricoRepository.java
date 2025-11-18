package com.caixa.caixaverso_desafio.repositories;

import com.caixa.caixaverso_desafio.entities.Historico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Long> {

    List<Historico> findByClienteId(Long clienteId);
}
