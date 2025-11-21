package com.caixa.caixaverso_desafio.dtos;

import com.caixa.caixaverso_desafio.entities.UserRole;
import io.swagger.v3.oas.annotations.media.Schema;

public class RegisterDTO {

    @Schema(example = "novo-usuario")
    private String login;

    @Schema(example = "password")
    private String password;

    @Schema(description = "Permissão do usuário", example = "ADMIN")
    private UserRole role;

    public RegisterDTO() {
    }

    public RegisterDTO(String login, String password, UserRole role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
