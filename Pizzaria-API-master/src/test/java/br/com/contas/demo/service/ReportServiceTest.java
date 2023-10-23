package br.com.contas.demo.service;

import br.com.contas.demo.entity.Orders;
import br.com.contas.demo.entity.Payment;
import br.com.contas.demo.entity.Report;
import br.com.contas.demo.entity.Status;
import br.com.contas.demo.repository.OrdersRepository;
import br.com.contas.demo.repository.ReportRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ReportServiceTest {

    @InjectMocks
    private ReportService reportService;

    @Mock
    private OrdersRepository ordersRepository;

    @Mock
    private ReportRepository reportRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetReport() {
        // Create a list of mock Orders for testing
        List<Orders> ordersList = new ArrayList<>();
        Orders order1 = new Orders();
        order1.setStatus(Status.CANCELADO);
        order1.setPayment(Payment.CARTAO);
        // Add more orders as needed

        // Configure the mock behavior of the ordersRepository
        when(ordersRepository.findByDay(any(LocalDate.class))).thenReturn(ordersList);

        // Call the GetReport method
        ResponseEntity<Report> result = reportService.GetReport(LocalDate.of(2023, 9, 1), LocalDate.of(2023, 9, 2));

        // Verify the behavior and assertions
        assertEquals(200, result.getStatusCodeValue()); // Assuming 200 is the status code for success
        verify(reportRepository, times(1)).save(any(Report.class)); // Verify that save was called once
    }

    @Test
    void testGetReportDay() {
        // Create a list of mock Orders for testing
        List<Orders> ordersList = new ArrayList<>();
        Orders order1 = new Orders();
        order1.setStatus(Status.ENTREGUE);
        order1.setPayment(Payment.DINHEIRO);
        // Add more orders as needed

        // Configure the mock behavior of the ordersRepository
        when(ordersRepository.findByDay(any(LocalDate.class))).thenReturn(ordersList);

        // Call the GetReportDay method
        ResponseEntity<Report> result = reportService.GetReportDay(LocalDate.of(2023, 9, 1));

        // Verify the behavior and assertions
        assertEquals(200, result.getStatusCodeValue()); // Assuming 200 is the status code for success
        verify(reportRepository, times(1)).save(any(Report.class)); // Verify that save was called once
    }


    @Test
    public void testGetReport2() {
        // Arrange
        LocalDate day1 = LocalDate.of(2023, 9, 21);
        LocalDate day2 = LocalDate.of(2023, 9, 22);

        List<Orders> pedidos_dia = new ArrayList<>();
        Orders order1 = new Orders(1L, LocalDateTime.of(2023, 9, 21, 12, 0), null, null, null, null, null);
        order1.setStatus(Status.CANCELADO);
        pedidos_dia.add(order1);

        Orders order2 = new Orders(2L, LocalDateTime.of(2023, 9, 22, 12, 0), null, null, null, null, null);
        order2.setStatus(Status.ENTREGUE);
        pedidos_dia.add(order2);

        Orders order3 = new Orders(3L, LocalDateTime.of(2023, 9, 22, 12, 0), null, null, null, null, null);
        order3.setStatus(Status.ENVIADO);
        pedidos_dia.add(order3);

        when(ordersRepository.findByDay(day1)).thenReturn(pedidos_dia);
        when(ordersRepository.findByDay(day2)).thenReturn(pedidos_dia);

        // Act
        ResponseEntity<Report> response = reportService.GetReport(day1, day2);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        Report report = response.getBody();
        assertEquals(1, report.getCanceledOrders());
        assertEquals(1, report.getOrdersDelivered());
        assertEquals(1, report.getWithdrawnOrders());
        assertEquals(0.0f, report.getTotalVillingCard());
        assertEquals(0.0f, report.getTotalBillingMoney());
    }


    @Test
     void testGetReportDay2() {
        // Arrange
        LocalDate day = LocalDate.of(2023, 9, 21);

        List<Orders> pedidos_dia = new ArrayList<>();
        Orders order1 = new Orders(1L, LocalDateTime.of(2023, 9, 21, 12, 0), null, null, null, null, null);
        order1.setStatus(Status.CANCELADO);
        pedidos_dia.add(order1);

        Orders order2 = new Orders(2L, LocalDateTime.of(2023, 9, 21, 12, 0), null, null, null, null, null);
        order2.setStatus(Status.ENTREGUE);
        pedidos_dia.add(order2);

        Orders order3 = new Orders(3L, LocalDateTime.of(2023, 9, 21, 12, 0), null, null, null, null, null);
        order3.setStatus(Status.ENVIADO);
        pedidos_dia.add(order3);

        when(ordersRepository.findByDay(day)).thenReturn(pedidos_dia);

        // Act
        ResponseEntity<Report> response = reportService.GetReportDay(day);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        Report report = response.getBody();
        assertEquals(1, report.getCanceledOrders());
        assertEquals(1, report.getOrdersDelivered());
        assertEquals(1, report.getWithdrawnOrders());
        assertEquals(0.0f, report.getTotalVillingCard());
        assertEquals(0.0f, report.getTotalBillingMoney());
    }

    @Test
     void testGetReportDayWhenNoOrders() {
        // Arrange
        LocalDate day = LocalDate.of(2023, 9, 21);

        List<Orders> pedidos_dia = new ArrayList<>();

        when(ordersRepository.findByDay(day)).thenReturn(pedidos_dia);

        // Act
        ResponseEntity<Report> response = reportService.GetReportDay(day);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        Report report = response.getBody();
        assertEquals(0, report.getCanceledOrders());
        assertEquals(0, report.getOrdersDelivered());
        assertEquals(0, report.getWithdrawnOrders());
        assertEquals(0.0f, report.getTotalVillingCard());
        assertEquals(0.0f, report.getTotalBillingMoney());
    }
}