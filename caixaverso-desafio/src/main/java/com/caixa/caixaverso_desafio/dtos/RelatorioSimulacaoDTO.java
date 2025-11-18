package com.caixa.caixaverso_desafio.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(description = "Relatório dos dados das simulações por dia e produto")
public class RelatorioSimulacaoDTO {

    @Schema(description = "Nome do produto")
    private String produto;

    @Schema(description = "Data da simulação")
    private LocalDate data;

    @Schema(description = "Quantidade de Simulações realizadas")
    private Long quantidadeSimulacoes;

    @Schema(description = "Média dos valores simulados")
    private BigDecimal mediaValorFinal;

    public RelatorioSimulacaoDTO() {
    }

    public RelatorioSimulacaoDTO(String produto, LocalDate data, Long quantidadeSimulacoes, Double mediaValorFinal) {
        this.produto = produto;
        this.data = data;
        this.quantidadeSimulacoes = quantidadeSimulacoes;
        this.mediaValorFinal = BigDecimal.valueOf(mediaValorFinal);
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Long getQuantidadeSimulacoes() {
        return quantidadeSimulacoes;
    }

    public void setQuantidadeSimulacoes(Long quantidadeSimulacoes) {
        this.quantidadeSimulacoes = quantidadeSimulacoes;
    }

    public BigDecimal getMediaValorFinal() {
        return mediaValorFinal;
    }

    public void setMediaValorFinal(BigDecimal mediaValorFinal) {
        this.mediaValorFinal = mediaValorFinal;
    }
}
