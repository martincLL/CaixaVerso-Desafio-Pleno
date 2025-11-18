package com.caixa.caixaverso_desafio.dtos;

public class PerfilRiscoDTO {

    private Long clienteId;
    private String perfil;
    private Integer pontuacao;
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
