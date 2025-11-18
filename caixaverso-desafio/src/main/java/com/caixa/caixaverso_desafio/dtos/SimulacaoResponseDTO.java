package com.caixa.caixaverso_desafio.dtos;

import com.caixa.caixaverso_desafio.entities.Produto;
import com.caixa.caixaverso_desafio.entities.Simulacao;

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

    public SimulacaoResponseDTO(Produto produto, Simulacao simulacao) {
        this.produtValidado = new ProdutoValidadoDTO(produto);
        this.resultadoSimulacao = new ResultadoSimulacaoDTO(simulacao);
        this.dataSimilacao = simulacao.getDataSimulacao();
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
