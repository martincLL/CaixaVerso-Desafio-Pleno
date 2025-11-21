package com.caixa.caixaverso_desafio.repositories;

import com.caixa.caixaverso_desafio.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    UserDetails findByLogin(String login);
}
