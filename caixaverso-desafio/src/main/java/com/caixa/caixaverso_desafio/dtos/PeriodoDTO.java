package com.caixa.caixaverso_desafio.dtos;

import java.time.LocalDate;

public class PeriodoDTO {

    private LocalDate inicio;
    private LocalDate fim;

    public PeriodoDTO() {
    }

    public PeriodoDTO(LocalDate inicio, LocalDate fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getFim() {
        return fim;
    }

    public void setFim(LocalDate fim) {
        this.fim = fim;
    }
}
