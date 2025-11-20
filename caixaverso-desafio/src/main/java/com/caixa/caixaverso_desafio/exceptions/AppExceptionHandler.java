package com.caixa.caixaverso_desafio.exceptions;

import com.caixa.caixaverso_desafio.dtos.RespostaErroExcecaoDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(AppException.class)
    public ResponseEntity<RespostaErroExcecaoDTO> handleAppException(AppException e, HttpServletRequest request) {

        RespostaErroExcecaoDTO erro = new RespostaErroExcecaoDTO(LocalDateTime.now(), e.getStatus().value(), e.getStatus().getReasonPhrase(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(e.getStatus()).body(erro);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RespostaErroExcecaoDTO> genericException(Exception e, HttpServletRequest request) {

        RespostaErroExcecaoDTO erro = new RespostaErroExcecaoDTO(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }
}
