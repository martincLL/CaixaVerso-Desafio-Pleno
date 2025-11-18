package com.caixa.caixaverso_desafio.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Análise do perfil de risco do cliente")
public class PerfilRiscoDTO {

    @Schema(description = "ID do cliente")
    private Long clienteId;

    @Schema(description = "Perfil de risco do ciente")
    private String perfil;

    @Schema(description = "Pontuação do cliente")
    private Integer pontuacao;

    @Schema(description = "Descrição do perfil do cliente")
    private String descricao;

    public PerfilRiscoDTO() {
    }

    public PerfilRiscoDTO(Long clienteId, String perfil, Integer pontuacao, String descricao) {
        this.clienteId = clienteId;
        this.perfil = perfil;
        this.pontuacao = pontuacao;
        this.descricao = descricao;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public Integer getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
