package br.com.contas.demo.repository.Entity;
import br.com.contas.demo.entity.Delivery;
import br.com.contas.demo.entity.MetodoEntrega;
import br.com.contas.demo.entity.Orders;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeliveryTest {

    @Test
    public void testGettersAndSetters() {
        Delivery delivery = new Delivery();

        delivery.setId(1L);
        delivery.setMetodoEntrega(MetodoEntrega.DELIVERY);
        delivery.setDeliveryName("iFood");
        delivery.setValueDelivery(10.0f);
        delivery.setOrder(new Orders(1L, LocalDateTime.of(2023, 9, 21, 12, 0), null, null, null, null, null));

        assertEquals(1L, delivery.getId());
        assertEquals(MetodoEntrega.DELIVERY, delivery.getMetodoEntrega());
        assertEquals("iFood", delivery.getDeliveryName());
        assertEquals(10.0f, delivery.getValueDelivery());
    }

    @Test
     void testGetId() {
        Delivery delivery = new Delivery();

        delivery.setId(1L);

        assertEquals(1L, delivery.getId());
    }
}