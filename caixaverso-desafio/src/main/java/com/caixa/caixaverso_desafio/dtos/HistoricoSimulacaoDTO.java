package com.caixa.caixaverso_desafio.dtos;

import com.caixa.caixaverso_desafio.entities.Simulacao;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Histórico da simulação realizada")
public class HistoricoSimulacaoDTO {

    @Schema(description = "ID do histórico")
    private Long id;

    @Schema(description = "ID do cliente")
    private Long clinteId;

    @Schema(description = "Produto do histórico")
    private String produto;

    @Schema(description = "Valor investido no produto")
    private BigDecimal valorInvestido;

    @Schema(description = "Valor final da aplicação")
    private BigDecimal valorFinal;

    @Schema(description = "Prazo em meses do investimento")
    private Integer prazoMeses;

    @Schema(description = "Data da simulação")
    private LocalDateTime dataSimulacao;

    public HistoricoSimulacaoDTO() {
    }

    public HistoricoSimulacaoDTO(Long id, Long clinteId, String produto, BigDecimal valorInvestido, BigDecimal valorFinal, Integer prazoMeses, LocalDateTime dataSimulacao) {
        this.id = id;
        this.clinteId = clinteId;
        this.produto = produto;
        this.valorInvestido = valorInvestido;
        this.valorFinal = valorFinal;
        this.prazoMeses = prazoMeses;
        this.dataSimulacao = dataSimulacao;
    }

    public HistoricoSimulacaoDTO(Simulacao simulacao) {
        this.id = simulacao.getId();
        this.clinteId = simulacao.getClienteId();
        this.produto = simulacao.getProduto();
        this.valorInvestido = simulacao.getValorInvestido();
        this.valorFinal = simulacao.getValorFinal();
        this.prazoMeses = simulacao.getPrazoMeses();
        this.dataSimulacao = simulacao.getDataSimulacao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClinteId() {
        return clinteId;
    }

    public void setClinteId(Long clinteId) {
        this.clinteId = clinteId;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public BigDecimal getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(BigDecimal valorInvestido) {
        this.valorInvestido = valorInvestido;
    }

    public BigDecimal getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(BigDecimal valorFinal) {
        this.valorFinal = valorFinal;
    }

    public Integer getPrazoMeses() {
        return prazoMeses;
    }

    public void setPrazoMeses(Integer prazoMeses) {
        this.prazoMeses = prazoMeses;
    }

    public LocalDateTime getDataSimulacao() {
        return dataSimulacao;
    }

    public void setDataSimulacao(LocalDateTime dataSimulacao) {
        this.dataSimulacao = dataSimulacao;
    }
}
