package com.caixa.caixaverso_desafio.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dados das chamadas da API")
public class TelemetriaServicoDTO {

    @Schema(description = "Nome do endpoint")
    private String nome;

    @Schema(description = "Chamadas recebidas")
    private Long quantidadeChamadas;

    @Schema(description = "Tempo médio de processamento")
    private Long mediaTempoRespostaMs;

    public TelemetriaServicoDTO() {
    }

    public TelemetriaServicoDTO(String nome, Long quantidadeChamadas, Long mediaTempoRespostaMs) {
        this.nome = nome;
        this.quantidadeChamadas = quantidadeChamadas;
        this.mediaTempoRespostaMs = mediaTempoRespostaMs;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getQuantidadeChamadas() {
        return quantidadeChamadas;
    }

    public void setQuantidadeChamadas(Long quantidadeChamadas) {
        this.quantidadeChamadas = quantidadeChamadas;
    }

    public Long getMediaTempoRespostaMs() {
        return mediaTempoRespostaMs;
    }

    public void setMediaTempoRespostaMs(Long mediaTempoRespostaMs) {
        this.mediaTempoRespostaMs = mediaTempoRespostaMs;
    }
}
