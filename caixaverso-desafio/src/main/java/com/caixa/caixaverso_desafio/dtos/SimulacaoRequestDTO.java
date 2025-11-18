package com.caixa.caixaverso_desafio.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Dados para solicitar uma simulação de investimento")
public class SimulacaoRequestDTO {

    @Schema(description = "ID do cliente")
    private Long clienteId;

    @Schema(description = "Valor que será investido")
    private BigDecimal valor;

    @Schema(description = "Prazo do investimento em meses")
    private Integer prazoMeses;

    @Schema(description = "Tipo do produto de investimento", example = "CDB")
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
