package com.caixa.caixaverso_desafio.dtos;

import java.time.LocalDateTime;

public class SimulacaoResponseDTO {

    private ProdutoValidadoDTO produtValidado;
    private ResultadoSimulacaoDTO resultadoSimulacao;
    private LocalDateTime dataSimilacao;

    public SimulacaoResponseDTO() {
    }

    public SimulacaoResponseDTO(ProdutoValidadoDTO produtValidado, ResultadoSimulacaoDTO resultadoSimulacao, LocalDateTime dataSimilacao) {
        this.produtValidado = produtValidado;
        this.resultadoSimulacao = resultadoSimulacao;
        this.dataSimilacao = dataSimilacao;
    }

    public ProdutoValidadoDTO getProdutValidado() {
        return produtValidado;
    }

    public void setProdutValidado(ProdutoValidadoDTO produtValidado) {
        this.produtValidado = produtValidado;
    }

    public ResultadoSimulacaoDTO getResultadoSimulacao() {
        return resultadoSimulacao;
    }

    public void setResultadoSimulacao(ResultadoSimulacaoDTO resultadoSimulacao) {
        this.resultadoSimulacao = resultadoSimulacao;
    }

    public LocalDateTime getDataSimilacao() {
        return dataSimilacao;
    }

    public void setDataSimilacao(LocalDateTime dataSimilacao) {
        this.dataSimilacao = dataSimilacao;
    }
}
