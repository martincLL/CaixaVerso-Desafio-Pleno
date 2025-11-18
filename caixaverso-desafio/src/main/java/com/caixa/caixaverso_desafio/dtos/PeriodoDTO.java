package com.caixa.caixaverso_desafio.dtos;

import java.time.LocalDateTime;

public class PeriodoDTO {

    private LocalDateTime inicio;
    private LocalDateTime fim;

    public PeriodoDTO() {
    }

    public PeriodoDTO(LocalDateTime inicio, LocalDateTime fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }
}
