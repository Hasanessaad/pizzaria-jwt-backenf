package br.com.contas.demo.entity;

import jakarta.persistence.*;

@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private MetodoEntrega metodoEntrega;

    private String DeliveryName;

    private Float ValueDelivery;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    public Delivery() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MetodoEntrega getMetodoEntrega() {
        return this.metodoEntrega;
    }

    public void setMetodoEntrega(MetodoEntrega metodoEntrega) {
        this.metodoEntrega = metodoEntrega;
    }

    public String getDeliveryName() {
        return DeliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        DeliveryName = deliveryName;
    }

    public Float getValueDelivery() {
        return ValueDelivery;
    }

    public void setValueDelivery(Float valueDelivery) {
        ValueDelivery = valueDelivery;
    }

    public Delivery(Long id, MetodoEntrega metodoEntrega, String deliveryName, Float valueDelivery, Orders order) {
        this.id = id;
        this.metodoEntrega = metodoEntrega;
        this.DeliveryName = deliveryName;
        this.ValueDelivery = valueDelivery;
        this.order = order;
    }
    public Delivery(Long id, MetodoEntrega metodoEntrega, String deliveryName, Float valueDelivery) {
        this.id = id;
        this.metodoEntrega = metodoEntrega;
        this.DeliveryName = deliveryName;
        this.ValueDelivery = valueDelivery;

    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

}
