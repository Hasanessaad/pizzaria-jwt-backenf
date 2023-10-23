package br.com.contas.demo.dto;

import br.com.contas.demo.entity.Client;
import br.com.contas.demo.entity.Item;
import br.com.contas.demo.entity.Payment;
import br.com.contas.demo.entity.Status;

import java.util.List;

public class OrdersDTO {

    private Payment payment;

    private Status status;

    private String Description;

    private br.com.contas.demo.entity.Client cliente;
    private List<Item> items;

    public OrdersDTO() {
    }

    public OrdersDTO( Payment payment, Status status, String description, Client cliente, List<Item> items) {

        this.payment = payment;
        this.status = status;
        Description = description;
        this.cliente = cliente;
        this.items = items;
    }


    public Enum<Payment> getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Status getStatus() {
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

    public br.com.contas.demo.entity.Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }

}
