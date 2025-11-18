package com.caixa.caixaverso_desafio.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private BigDecimal rentabilidade;

    @Column(nullable = false)
    private String risco;

    @Column(name = "prazo_minimo_meses", nullable = false)
    private Integer prazoMinimoMeses;

    @Column(name = "valor_minimo", nullable = false)
    private BigDecimal valorMinimo;

    public Produto() {
    }

    public Produto(Long id, String nome, String tipo, BigDecimal rentabilidade, String risco, Integer prazoMinimoMeses, BigDecimal valorMinimo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.rentabilidade = rentabilidade;
        this.risco = risco;
        this.prazoMinimoMeses = prazoMinimoMeses;
        this.valorMinimo = valorMinimo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String name) {
        this.nome = name;
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
