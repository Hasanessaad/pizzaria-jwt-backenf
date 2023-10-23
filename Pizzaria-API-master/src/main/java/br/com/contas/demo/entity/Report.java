package br.com.contas.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private LocalDateTime data;
    private Integer CanceledOrders;

    private Integer OrdersDelivered;

    private Integer WithdrawnOrders;

    private Float TotalVillingCard;

    private Float TotalBillingMoney;

    public Report() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Integer getCanceledOrders() {
        return CanceledOrders;
    }

    public void setCanceledOrders(Integer canceledOrders) {
        CanceledOrders = canceledOrders;
    }

    public Integer getOrdersDelivered() {
        return OrdersDelivered;
    }

    public void setOrdersDelivered(Integer ordersDelivered) {
        OrdersDelivered = ordersDelivered;
    }

    public Integer getWithdrawnOrders() {
        return WithdrawnOrders;
    }

    public void setWithdrawnOrders(Integer withdrawnOrders) {
        WithdrawnOrders = withdrawnOrders;
    }

    public Float getTotalVillingCard() {
        return TotalVillingCard;
    }

    public void setTotalVillingCard(Float totalVillingCard) {
        TotalVillingCard = totalVillingCard;
    }

    public Float getTotalBillingMoney() {
        return TotalBillingMoney;
    }

    public void setTotalBillingMoney(Float totalBillingMoney) {
        TotalBillingMoney = totalBillingMoney;
    }

    public Report(Long id, LocalDateTime data, Integer canceledOrders, Integer ordersDelivered, Integer withdrawnOrders, Float totalVillingCard, Float totalBillingMoney) {
        this.id = id;
        this.data = data;
        CanceledOrders = canceledOrders;
        OrdersDelivered = ordersDelivered;
        WithdrawnOrders = withdrawnOrders;
        TotalVillingCard = totalVillingCard;
        TotalBillingMoney = totalBillingMoney;
    }
}
