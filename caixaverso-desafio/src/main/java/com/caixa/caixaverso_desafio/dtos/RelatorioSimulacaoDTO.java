package com.caixa.caixaverso_desafio.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RelatorioSimulacaoDTO {

    private String produto;
    private LocalDate data;
    private Long quantidadeSimulacoes;
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
