package com.caixa.caixaverso_desafio.dtos;

import java.time.LocalDateTime;

public class RespostaErroExcecaoDTO {

    private LocalDateTime localDateTime;
    private Integer status;
    private String erro;
    private String msg;
    private String path;

    public RespostaErroExcecaoDTO() {
    }

    public RespostaErroExcecaoDTO(LocalDateTime localDateTime, Integer status, String erro, String msg, String path) {
        this.localDateTime = localDateTime;
        this.status = status;
        this.erro = erro;
        this.msg = msg;
        this.path = path;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
