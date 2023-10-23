package br.com.contas.demo.dto;

import br.com.contas.demo.entity.Client;


public class AdressDTO {

    private String cidade;
    private String rua;
    private Integer numero_rua;
    private Client cliente;

    public AdressDTO() {
    }

    public AdressDTO(String cidade, String rua, Integer numero_rua) {

        this.cidade = cidade;
        this.rua = rua;
        this.numero_rua = numero_rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero_rua() {
        return numero_rua;
    }

    public void setNumero_rua(Integer numero_rua) {
        this.numero_rua = numero_rua;
    }
}
