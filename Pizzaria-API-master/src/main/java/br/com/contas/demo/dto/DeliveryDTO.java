package br.com.contas.demo.dto;

import br.com.contas.demo.entity.MetodoEntrega;
import br.com.contas.demo.entity.Orders;


public class DeliveryDTO {

    private br.com.contas.demo.entity.MetodoEntrega metodoEntrega;

    private String DeliveryName;

    private Float ValueDelivery;


    private Orders order;

    public DeliveryDTO() {
    }

    public DeliveryDTO(MetodoEntrega metodoEntrega, String deliveryName, Float valueDelivery, Orders order) {
        this.metodoEntrega = metodoEntrega;
        DeliveryName = deliveryName;
        ValueDelivery = valueDelivery;
        this.order = order;
    }

    public MetodoEntrega getMetodoEntrega() {
        return metodoEntrega;
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

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }
}
