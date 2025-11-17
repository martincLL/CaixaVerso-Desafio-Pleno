package com.caixa.caixaverso_desafio.repositories;

import com.caixa.caixaverso_desafio.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
