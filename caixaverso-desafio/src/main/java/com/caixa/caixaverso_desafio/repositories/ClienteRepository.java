package com.caixa.caixaverso_desafio.repositories;

import com.caixa.caixaverso_desafio.entities.Cliente;
import com.caixa.caixaverso_desafio.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
