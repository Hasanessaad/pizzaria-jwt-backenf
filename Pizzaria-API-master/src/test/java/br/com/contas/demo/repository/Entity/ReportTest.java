
package br.com.contas.demo.repository.Entity;
import br.com.contas.demo.entity.Report;
import org.junit.jupiter.api.Test;


import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReportTest {

    @Test
    public void testGettersAndSetters() {
        Report report = new Report();

        report.setId(1L);
        report.setData(LocalDateTime.of(2023, 9, 21, 12, 0));
        report.setCanceledOrders(10);
        report.setOrdersDelivered(20);
        report.setWithdrawnOrders(30);
        report.setTotalVillingCard(100.0f);
        report.setTotalBillingMoney(200.0f);

        assertEquals(1L, report.getId());
        assertEquals(LocalDateTime.of(2023, 9, 21, 12, 0), report.getData());
        assertEquals(10, report.getCanceledOrders());
        assertEquals(20, report.getOrdersDelivered());
        assertEquals(30, report.getWithdrawnOrders());
        assertEquals(100.0f, report.getTotalVillingCard());
        assertEquals(200.0f, report.getTotalBillingMoney());
    }

    @Test
     void testGetId() {
        Report report = new Report();

        report.setId(1L);

        assertEquals(1L, report.getId());
    }
}