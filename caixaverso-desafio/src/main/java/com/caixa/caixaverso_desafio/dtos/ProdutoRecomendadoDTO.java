package com.caixa.caixaverso_desafio.dtos;

import com.caixa.caixaverso_desafio.entities.Produto;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Produto de investimento sugerido para o perfil de cada cliente")
public class ProdutoRecomendadoDTO {

    @Schema(description = "ID do produto")
    private Long id;

    @Schema(description = "Nome do produto sugerido")
    private String nome;

    @Schema(description = "Tipo do produto sugerido")
    private String tipo;

    @Schema(description = "Rentabilidade do investimento sugerido")
    private BigDecimal rentabilidade;

    @Schema(description = "Risco do produto recomendado")
    private String risco;

    public ProdutoRecomendadoDTO() {
    }

    public ProdutoRecomendadoDTO(Long id, String nome, String tipo, BigDecimal rentabilidade, String risco) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.rentabilidade = rentabilidade;
        this.risco = risco;
    }

    public ProdutoRecomendadoDTO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.tipo = produto.getTipo();
        this.rentabilidade = produto.getRentabilidade();
        this.risco = produto.getRisco();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getRentabilidade() {
        return rentabilidade;
    }

    public void setRentabilidade(BigDecimal rentabilidade) {
        this.rentabilidade = rentabilidade;
    }

    public String getRisco() {
        return risco;
    }

    public void setRisco(String risco) {
        this.risco = risco;
    }
}
