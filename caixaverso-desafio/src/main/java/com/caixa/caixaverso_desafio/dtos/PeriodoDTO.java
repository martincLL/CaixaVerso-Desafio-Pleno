package com.caixa.caixaverso_desafio.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Período da demonstração dos dados")
public class PeriodoDTO {

    @Schema(description = "Data de início do monitoramento")
    private LocalDateTime inicio;

    @Schema(description = "Fim do monitoramento")
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
