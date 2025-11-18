package com.caixa.caixaverso_desafio.dtos;

import java.math.BigDecimal;

public class SimulacaoRequestDTO {

    private Long clienteId;
    private BigDecimal valor;
    private Integer prazoMeses;
    private String tipoProduto;

    public SimulacaoRequestDTO() {
    }

    public SimulacaoRequestDTO(Long clienteId, BigDecimal valor, Integer prazoMeses, String tipoProduto) {
        this.clienteId = clienteId;
        this.valor = valor;
        this.prazoMeses = prazoMeses;
        this.tipoProduto = tipoProduto;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getPrazoMeses() {
        return prazoMeses;
    }

    public void setPrazoMeses(Integer prazoMeses) {
        this.prazoMeses = prazoMeses;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
}
