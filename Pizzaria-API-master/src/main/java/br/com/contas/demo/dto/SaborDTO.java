package br.com.contas.demo.dto;

public class SaborDTO {
    private String nome;
    //algumas pizzarias tem sabores que contam com um adicional de preco
    private Float preco_adicional;


    public SaborDTO() {
    }

    public SaborDTO( String nome, Float preco_adicional) {
        this.nome = nome;
        this.preco_adicional = preco_adicional;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPreco_adicional() {
        return preco_adicional;
    }

    public void setPreco_adicional(Float preco_adicional) {
        this.preco_adicional = preco_adicional;
    }


}
