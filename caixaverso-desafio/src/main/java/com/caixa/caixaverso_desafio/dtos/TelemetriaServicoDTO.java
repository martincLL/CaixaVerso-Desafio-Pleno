package com.caixa.caixaverso_desafio.dtos;

public class TelemetriaServicoDTO {

    private String nome;
    private Long quantidadeChamados;
    private Long mediaTempoRespostaMs;

    public TelemetriaServicoDTO() {
    }

    public TelemetriaServicoDTO(String nome, Long quantidadeChamados, Long mediaTempoRespostaMs) {
        this.nome = nome;
        this.quantidadeChamados = quantidadeChamados;
        this.mediaTempoRespostaMs = mediaTempoRespostaMs;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getQuantidadeChamados() {
        return quantidadeChamados;
    }

    public void setQuantidadeChamados(Long quantidadeChamados) {
        this.quantidadeChamados = quantidadeChamados;
    }

    public Long getMediaTempoRespostaMs() {
        return mediaTempoRespostaMs;
    }

    public void setMediaTempoRespostaMs(Long mediaTempoRespostaMs) {
        this.mediaTempoRespostaMs = mediaTempoRespostaMs;
    }
}
