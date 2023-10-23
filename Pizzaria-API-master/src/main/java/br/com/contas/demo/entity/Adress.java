package br.com.contas.demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String cidade;
    private String rua;
    private Integer numero_rua;
    @ManyToMany
    private List<Client> cliente;

    public Adress() {
    }

    public Adress(Long id, String cidade, String rua, Integer numero_rua) {
        this.id = id;
        this.cidade = cidade;
        this.rua = rua;
        this.numero_rua = numero_rua;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
