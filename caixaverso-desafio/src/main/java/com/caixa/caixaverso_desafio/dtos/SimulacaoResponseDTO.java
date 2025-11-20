package com.caixa.caixaverso_desafio.dtos;

import com.caixa.caixaverso_desafio.entities.Produto;
import com.caixa.caixaverso_desafio.entities.Simulacao;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Resposta da simulação")
public class SimulacaoResponseDTO {

    @Schema(description = "Dados do produto que foi selecionado e validado")
    private ProdutoValidadoDTO produtoValidado;

    @Schema(description = "Resultado dos cálculos da simulação")
    private ResultadoSimulacaoDTO resultadoSimulacao;

    @Schema(description = "Data e hora da simulação")
    private LocalDateTime dataSimilacao;

    public SimulacaoResponseDTO() {
    }

    public SimulacaoResponseDTO(ProdutoValidadoDTO produtoValidado, ResultadoSimulacaoDTO resultadoSimulacao, LocalDateTime dataSimilacao) {
        this.produtoValidado = produtoValidado;
        this.resultadoSimulacao = resultadoSimulacao;
        this.dataSimilacao = dataSimilacao;
    }

    public SimulacaoResponseDTO(Produto produto, Simulacao simulacao) {
        this.produtoValidado = new ProdutoValidadoDTO(produto);
        this.resultadoSimulacao = new ResultadoSimulacaoDTO(simulacao);
        this.dataSimilacao = simulacao.getDataSimulacao();
    }

    public ProdutoValidadoDTO getProdutoValidado() {
        return produtoValidado;
    }

    public void setProdutoValidado(ProdutoValidadoDTO produtoValidado) {
        this.produtoValidado = produtoValidado;
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
