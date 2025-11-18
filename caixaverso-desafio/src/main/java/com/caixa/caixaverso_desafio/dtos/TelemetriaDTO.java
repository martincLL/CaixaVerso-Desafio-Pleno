package com.caixa.caixaverso_desafio.dtos;

import java.util.List;

public class TelemetriaDTO {

    private List<TelemetriaServicoDTO> servicos;
    private PeriodoDTO periodo;

    public TelemetriaDTO() {
    }

    public TelemetriaDTO(List<TelemetriaServicoDTO> servicos, PeriodoDTO periodo) {
        this.servicos = servicos;
        this.periodo = periodo;
    }

    public List<TelemetriaServicoDTO> getServicos() {
        return servicos;
    }

    public void setServicos(List<TelemetriaServicoDTO> servicos) {
        this.servicos = servicos;
    }

    public PeriodoDTO getPeriodo() {
        return periodo;
    }

    public void setPeriodo(PeriodoDTO periodo) {
        this.periodo = periodo;
    }
}
