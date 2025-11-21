package com.caixa.caixaverso_desafio.controllers;

import com.caixa.caixaverso_desafio.dtos.AuthenticationDTO;
import com.caixa.caixaverso_desafio.dtos.LoginResponseDTO;
import com.caixa.caixaverso_desafio.dtos.RegisterDTO;
import com.caixa.caixaverso_desafio.entities.Usuario;
import com.caixa.caixaverso_desafio.repositories.UsuarioRepository;
import com.caixa.caixaverso_desafio.security.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@Tag(name = "Autenticação", description = "Endppoints de registro de usuários e de login para poder obter o token de acesso")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    @Operation(summary = "Realizar Login", description = "Autentica o usuário e retorna um token JWT para acessar os recursos protegidos da API")
    @ApiResponse(responseCode = "200", description = "Login feito com sucesso")
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO dto) {

        var usernamePassword = new UsernamePasswordAuthenticationToken(dto.getLogin(), dto.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @Operation(summary = "Registrar um novo usuário", description = "Cria e registra um novo usuário para poder habilitar o login")
    @ApiResponse(responseCode = "200", description = "Usuário cadastrado com sucesso")
    @ApiResponse(responseCode = "400", description = "Usuário já existe")
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDTO dto) {
        if(this.usuarioRepository.findByLogin(dto.getLogin()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.getPassword());

        Usuario newUser = new Usuario(dto.getLogin(), encryptedPassword, dto.getRole());

        this.usuarioRepository.save(newUser);
        return ResponseEntity.ok().build();
    }
}
