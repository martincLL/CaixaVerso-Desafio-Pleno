package com.caixa.caixaverso_desafio.dtos;

import java.util.List;

public class TelemetriaDTO {

    private List<TelemetriaServicoDTO> telemetriaServico;
    private PeriodoDTO periodoDTO;

    public TelemetriaDTO() {
    }

    public TelemetriaDTO(List<TelemetriaServicoDTO> telemetriaServico, PeriodoDTO periodoDTO) {
        this.telemetriaServico = telemetriaServico;
        this.periodoDTO = periodoDTO;
    }

    public List<TelemetriaServicoDTO> getTelemetriaServico() {
        return telemetriaServico;
    }

    public void setTelemetriaServico(List<TelemetriaServicoDTO> telemetriaServico) {
        this.telemetriaServico = telemetriaServico;
    }

    public PeriodoDTO getPeriodoDTO() {
        return periodoDTO;
    }

    public void setPeriodoDTO(PeriodoDTO periodoDTO) {
        this.periodoDTO = periodoDTO;
    }
}
