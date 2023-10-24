package br.com.contas.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "client")

public class Client {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Getter
    private String nome;

    @Getter
    private String phone;
    @Getter
    private  String cpf;
    @ManyToMany
    private List<Adress> adress;

    public Client(String nome, String phone, String cpf) {

    }

    public Client() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Adress> getEndereco() {
        return adress;
    }

    public void setEndereco(List<Adress> adress) {
        this.adress = adress;
    }

    public void addEndereco(Adress adress) {
        this.adress.add(adress);
    }


}
