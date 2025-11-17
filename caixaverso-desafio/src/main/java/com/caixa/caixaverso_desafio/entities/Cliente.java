package com.caixa.caixaverso_desafio.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String perfil;
    private Integer pontuacao;

    @Column(name = "volume_investimentos")
    private BigDecimal volumeInvestimentos;

    @Column(name = "frequencia_movimentacoes")
    private Integer frequenciaMovimentacoes;
    private String preferencia;

    public Cliente() {
    }

    public Cliente(Long id, String perfil, Integer pontuacao, BigDecimal volumeInvestimentos, Integer frequenciaMovimentacoes, String preferencia) {
        this.id = id;
        this.perfil = perfil;
        this.pontuacao = pontuacao;
        this.volumeInvestimentos = volumeInvestimentos;
        this.frequenciaMovimentacoes = frequenciaMovimentacoes;
        this.preferencia = preferencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BigDecimal getVolumeInvestimentos() {
        return volumeInvestimentos;
    }

    public void setVolumeInvestimentos(BigDecimal volumeInvestimentos) {
        this.volumeInvestimentos = volumeInvestimentos;
    }

    public Integer getFrequenciaMovimentacoes() {
        return frequenciaMovimentacoes;
    }

    public void setFrequenciaMovimentacoes(Integer frequenciaMovimentacoes) {
        this.frequenciaMovimentacoes = frequenciaMovimentacoes;
    }

    public String getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(String preferencia) {
        this.preferencia = preferencia;
    }
}
