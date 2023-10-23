package br.com.contas.demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;



    private String codigo;
    private Float preco;
    private Boolean pizza;
    private Integer tamanho;
    private String extra;
    private String remove;
@ManyToMany
    private List<Sabor> sabor;

    public Item() {
    }

    public Item( String codigo, Float preco, Boolean pizza) {

        this.codigo = codigo;
        this.preco = preco;
        this.pizza = pizza;
    }
    public Item(Long id, String codigo, Float preco, Boolean pizza) {
        this.id = id;
        this.codigo = codigo;
        this.preco = preco;
        this.pizza = pizza;
    }

    public Item(Long id, String codigo, Float preco, Boolean pizza, Integer tamanho, String extra, String remove) {
        this.id = id;
        this.codigo = codigo;
        this.preco = preco;
        this.pizza = pizza;
        this.tamanho = tamanho;
        this.extra = extra;
        this.remove = remove;
    }

    public Long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Boolean getPizza() {
        return pizza;
    }

    public void setPizza(Boolean pizza) {
        this.pizza = pizza;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getRemove() {
        return remove;
    }

    public void setRemove(String remove) {
        this.remove = remove;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
