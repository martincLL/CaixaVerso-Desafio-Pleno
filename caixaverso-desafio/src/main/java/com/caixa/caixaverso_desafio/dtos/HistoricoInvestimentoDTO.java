package com.caixa.caixaverso_desafio.dtos;

import com.caixa.caixaverso_desafio.entities.Historico;

import java.math.BigDecimal;
import java.time.LocalDate;

public class HistoricoInvestimentoDTO {

    private Long id;
    private String tipo;
    private BigDecimal valor;
    private BigDecimal rentabilidade;
    private LocalDate data;

    public HistoricoInvestimentoDTO() {
    }

    public HistoricoInvestimentoDTO(Long id, String tipo, BigDecimal valor, BigDecimal rentabilidade, LocalDate data) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
        this.rentabilidade = rentabilidade;
        this.data = data;
    }

    public HistoricoInvestimentoDTO(Historico historico) {
        this.id = historico.getId();
        this.tipo = historico.getTipo();
        this.valor = historico.getValor();
        this.rentabilidade = historico.getRentabilidade();
        this.data = historico.getDataInvestimento();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getRentabilidade() {
        return rentabilidade;
    }

    public void setRentabilidade(BigDecimal rentabilidade) {
        this.rentabilidade = rentabilidade;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
