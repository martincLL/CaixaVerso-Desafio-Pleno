package com.caixa.caixaverso_desafio.dtos;

import java.math.BigDecimal;

public class ResultadoSimulacaoDTO {

    private BigDecimal valorFinal;
    private BigDecimal rentabilidadeEfetiva;
    private Integer prazoMeses;

    public ResultadoSimulacaoDTO() {
    }

    public ResultadoSimulacaoDTO(BigDecimal valorFinal, BigDecimal rentabilidadeEfetiva, Integer prazoMeses) {
        this.valorFinal = valorFinal;
        this.rentabilidadeEfetiva = rentabilidadeEfetiva;
        this.prazoMeses = prazoMeses;
    }

    public BigDecimal getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(BigDecimal valorFinal) {
        this.valorFinal = valorFinal;
    }

    public BigDecimal getRentabilidadeEfetiva() {
        return rentabilidadeEfetiva;
    }

    public void setRentabilidadeEfetiva(BigDecimal rentabilidadeEfetiva) {
        this.rentabilidadeEfetiva = rentabilidadeEfetiva;
    }

    public Integer getPrazoMeses() {
        return prazoMeses;
    }

    public void setPrazoMeses(Integer prazoMeses) {
        this.prazoMeses = prazoMeses;
    }
}
