package com.caixa.caixaverso_desafio.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Dados técnicos de monitoramento da API")
public class TelemetriaDTO {

    @Schema(description = "Lista com os dados")
    private List<TelemetriaServicoDTO> servicos;

    @Schema(description = "Periodo dos dados")
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
