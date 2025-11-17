package com.caixa.caixaverso_desafio.entities;

import jakarta.persistence.*;
import lombok.extern.apachecommons.CommonsLog;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long produtoId;
    private String name;
    private String tipo;
    private BigDecimal rentabilidade;
    private String risco;

    @Column(name = "prazo_minimo_meses")
    private Integer prazoMinimoMeses;

    @Column(name = "valor_minimo")
    private BigDecimal valorMinimo;

    public Produto() {
    }

    public Produto(Long produtoId, String name, String tipo, BigDecimal rentabilidade, String risco, Integer prazoMinimoMeses, BigDecimal valorMinimo) {
        this.produtoId = produtoId;
        this.name = name;
        this.tipo = tipo;
        this.rentabilidade = rentabilidade;
        this.risco = risco;
        this.prazoMinimoMeses = prazoMinimoMeses;
        this.valorMinimo = valorMinimo;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getRentabilidade() {
        return rentabilidade;
    }

    public void setRentabilidade(BigDecimal rentabilidade) {
        this.rentabilidade = rentabilidade;
    }

    public String getRisco() {
        return risco;
    }

    public void setRisco(String risco) {
        this.risco = risco;
    }

    public Integer getPrazoMinimoMeses() {
        return prazoMinimoMeses;
    }

    public void setPrazoMinimoMeses(Integer prazoMinimoMeses) {
        this.prazoMinimoMeses = prazoMinimoMeses;
    }

    public BigDecimal getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(BigDecimal valorMinimo) {
        this.valorMinimo = valorMinimo;
    }
}
