package br.com.contas.demo.repository.Controller;

import br.com.contas.demo.controller.OrderController;
import br.com.contas.demo.dto.OrdersDTO;
import br.com.contas.demo.entity.Orders;
import br.com.contas.demo.entity.Status;
import br.com.contas.demo.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OrderControllerTest {

    @InjectMocks
    private OrderController controller;

    @Mock
    private OrderService service;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void findAllOrders() {
        // Arrange
        List<Orders> ordersList = new ArrayList<>();
        when(service.Findall()).thenReturn(ordersList);

        // Act
        List<Orders> result = controller.Findall();

        // Assert
        assertEquals(ordersList, result);
    }

    @Test
    void findOrdersByStatus() {
        // Arrange
        Status status = Status.ENVIADO;
        List<Orders> ordersList = new ArrayList<>();
        when(service.findByStatus(status)).thenReturn(ordersList);

        // Act
        List<Orders> result = controller.findByStatus(status);

        // Assert
        assertEquals(ordersList, result);
    }

    @Test
    void createOrder() {
        // Arrange
        OrdersDTO orderDTO = new OrdersDTO();
        when(service.create(orderDTO)).thenReturn(new ResponseEntity<>(HttpStatus.CREATED));

        // Act
        ResponseEntity<Orders> result = controller.create(orderDTO);

        // Assert
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
    }

    @Test
    void updateOrder() {
        // Arrange
        Long orderId = 1L;
        OrdersDTO orderDTO = new OrdersDTO();
        when(service.update(orderId, orderDTO)).thenReturn(new ResponseEntity<>(HttpStatus.OK));

        // Act
        ResponseEntity<Object> result = controller.update(orderDTO, orderId);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}