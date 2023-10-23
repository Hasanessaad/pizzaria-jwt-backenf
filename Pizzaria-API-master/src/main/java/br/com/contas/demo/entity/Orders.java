package br.com.contas.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalTime time;

    private LocalDate day;
    @Enumerated(EnumType.STRING)
    private Payment payment;
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    private String Description;

    @ManyToOne
    @JoinColumn(name = "ClientID")
    private Client cliente;
    @ManyToMany
    private List<Item> items;

    public Orders() {
    }

    public Orders(Long id, LocalDateTime data, Payment payment, Status status, String description, Client cliente, List<Item> items) {
        this.id = id;
        this.time   = data.toLocalTime();
        this.payment = payment;
        this.status = status;
        Description = description;
        this.cliente = cliente;
        this.items = items;
        this.day = data.toLocalDate();
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getData() {
        return time ;
    }

    public void setData(LocalDateTime data) {
        this.time = LocalTime.from(data);
    }

    public Enum<Payment> getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Enum<Status> getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }

    public LocalTime getTime() {
        return  this.time;
    }
}
