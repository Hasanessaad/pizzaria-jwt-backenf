package br.com.contas.demo.service;

import br.com.contas.demo.entity.*;
import br.com.contas.demo.repository.OrdersRepository;
import br.com.contas.demo.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private ReportRepository repository;


    public ResponseEntity<Report> GetReport (LocalDate day1, LocalDate day2) {
        LocalDate start = day1;
    LocalDate end = day2;

    List<LocalDate> daysBetween = new ArrayList<>();

    while (!start.isAfter(end)){
        daysBetween.add(start);
        start = start.plusDays(1);
    }

        Integer CanceledOrders = 0;
        Integer OrdersDelivered= 0;
        Integer WithdrawnOrders = 0;
        Float TotalVillingCard = 0F;
        Float TotalBillingMoney = 0F;

        for (LocalDate day : daysBetween) {
            List<Orders> pedidos_dia =new ArrayList<>();
            pedidos_dia = ordersRepository.findByDay(day);

            for ( Orders pedido: pedidos_dia) {
                if (pedido.getStatus() == Status.CANCELADO) {
                    CanceledOrders = +1;
                }
                if (pedido.getStatus() == Status.ENTREGUE) {
                    WithdrawnOrders = +1;
                }
                if (pedido.getStatus() == Status.ENVIADO) {
                    OrdersDelivered = +1;
                }
                if (pedido.getPayment() == Payment.CARTAO) {
                    List<Item> items = pedido.getItems();

                    for (Item item : items) {
                        TotalVillingCard = +item.getPreco();
                    }

                }
                if (pedido.getPayment() == Payment.DINHEIRO) {
                    List<Item> items = pedido.getItems();

                    for (Item item : items) {
                        TotalBillingMoney = +item.getPreco();
                    }
                }
            }

        }

        Report report = new Report();
        report.setData(LocalDateTime.now());
        report.setCanceledOrders(CanceledOrders);
        report.setOrdersDelivered(OrdersDelivered);
        report.setWithdrawnOrders(WithdrawnOrders);
        report.setTotalVillingCard(TotalVillingCard);
        report.setTotalBillingMoney(TotalBillingMoney);
        repository.save(report);
        return ResponseEntity.ok(report);




    };

    public ResponseEntity<Report> GetReportDay (LocalDate day) {
List<Orders> pedidos_dia =new ArrayList<>();
pedidos_dia = ordersRepository.findByDay(day);
         Integer CanceledOrders = 0;
         Integer OrdersDelivered= 0;
         Integer WithdrawnOrders = 0;
         Float TotalVillingCard = 0F;
         Float TotalBillingMoney = 0F;

         for ( Orders pedido: pedidos_dia) {
             if (pedido.getStatus() == Status.CANCELADO) {
                 CanceledOrders = +1;
             }
             if (pedido.getStatus() == Status.ENTREGUE) {
                 WithdrawnOrders = +1;
             }
             if (pedido.getStatus() == Status.ENVIADO) {
                 OrdersDelivered = +1;
             }
             if (pedido.getPayment() == Payment.CARTAO) {
                 List<Item> items = pedido.getItems();

                 for (Item item : items) {
                     TotalVillingCard = +item.getPreco();
                 }

             }
             if (pedido.getPayment() == Payment.DINHEIRO) {
                 List<Item> items = pedido.getItems();

                 for (Item item : items) {
                     TotalBillingMoney = +item.getPreco();
                 }
             }
         }

             Report report = new Report();
             report.setData(LocalDateTime.now());
             report.setCanceledOrders(CanceledOrders);
             report.setOrdersDelivered(OrdersDelivered);
             report.setWithdrawnOrders(WithdrawnOrders);
             report.setTotalVillingCard(TotalVillingCard);
             report.setTotalBillingMoney(TotalBillingMoney);
             repository.save(report);
             return ResponseEntity.ok(report);

    };


}
