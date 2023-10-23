package br.com.contas.demo.repository.Entity;

import br.com.contas.demo.entity.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrdersTest {

    @Test
    public void testGettersAndSetters() {
        Orders orders = new Orders();

        orders.setId(1L);
        orders.setDay(LocalDate.of(2023, 9, 21));
        orders.setPayment(Payment.DINHEIRO);
        orders.setStatus(Status.PENDENTE);
        orders.setDescription("This is a test order.");
        orders.setCliente(new Client("jose", "45991122463", "01025471903"));
        orders.setItems(List.of(new Item(1L, "ABC123", 10.0f, true)));

        Client expected = new Client("jose", "45991122463", "01025471903");
        assertEquals(1L, orders.getId());
        assertEquals(LocalDate.of(2023, 9, 21), orders.getDay());
        assertEquals(Payment.DINHEIRO, orders.getPayment());
        assertEquals(Status.PENDENTE, orders.getStatus());
        assertEquals("This is a test order.", orders.getDescription());
    }

    @Test
     void testGetId() {
        Delivery delivery = new Delivery();

        delivery.setId(1L);

        assertEquals(1L, delivery.getId());
    }
}
