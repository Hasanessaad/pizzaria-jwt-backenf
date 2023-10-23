package br.com.contas.demo.service;

import br.com.contas.demo.dto.OrdersDTO;
import br.com.contas.demo.entity.Orders;
import br.com.contas.demo.entity.Status;
import br.com.contas.demo.repository.OrdersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OrderServiceTest {

    @InjectMocks
    private OrderService undertest;

    @Mock
    private OrdersRepository repository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void findAllOrders() {
        // Arrange

        // Act
        undertest.Findall();

        // Assert
        verify(repository).findAll();
    }

    @Test
    void findByStatus() {
        // Arrange
        Status status = Status.ENVIADO;

        // Act
        undertest.findByStatus(status);

        // Assert
        verify(repository).findByStatus(status);
    }

//    @Test
//    void updateExistingOrder() {
//        // Arrange
//        Long orderId = 1L;
//        OrdersDTO ordersDTO = new OrdersDTO();
//        Orders existingOrder = new Orders();
//        existingOrder.setId(orderId);
//
//        when(repository.findById(orderId)).thenReturn(Optional.of(existingOrder));
//        when(repository.save(existingOrder)).thenReturn(existingOrder);
//
//        // Act
//        ResponseEntity<Object> response = undertest.update(orderId, ordersDTO);
//
//        // Assert
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        ArgumentCaptor<Orders> orderCaptor = ArgumentCaptor.forClass(Orders.class);
//        verify(repository).save(orderCaptor.capture());
//        Orders updatedOrder = orderCaptor.getValue();
//        assertEquals(existingOrder, updatedOrder);
//    }

//    @Test
//    void updateNonExistingOrder() {
//        // Arrange
//        Long orderId = 1L;
//        OrdersDTO ordersDTO = new OrdersDTO();
//
//        when(repository.findById(orderId)).thenReturn(Optional.empty());
//
//        // Act
//        ResponseEntity<Object> response = undertest.update(orderId, ordersDTO);
//
//        // Assert
//        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//        verify(repository, never()).save(any());
//    }

    @Test
    void createOrder() {
        // Arrange
        OrdersDTO ordersDTO = new OrdersDTO();
        ordersDTO.setStatus(Status.ENVIADO);

        Orders orderToSave = new Orders();
        BeanUtils.copyProperties(ordersDTO, orderToSave);
        orderToSave.setData(LocalDateTime.now());

        when(repository.save(orderToSave)).thenReturn(orderToSave);

        // Act
        ResponseEntity<Orders> response = undertest.create(ordersDTO);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void createOrderWithException() {
        // Arrange
        OrdersDTO ordersDTO = new OrdersDTO();
        ordersDTO.setStatus(Status.ENVIADO);

        when(repository.save(any(Orders.class))).thenThrow(new RuntimeException("Test Exception"));

        // Act
        ResponseEntity<Orders> response = undertest.create(ordersDTO);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}