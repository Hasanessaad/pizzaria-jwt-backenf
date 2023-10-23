package br.com.contas.demo.ControllerTest;

import br.com.contas.demo.controller.AdressController;
import br.com.contas.demo.dto.AdressDTO;
import br.com.contas.demo.entity.Adress;
import br.com.contas.demo.service.AdressService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AdressControllerTest {

    @InjectMocks
    private AdressController controller;

    @Mock
    private AdressService service;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void createAddress() {
        // Arrange
        AdressDTO adressDTO = new AdressDTO("City", "123 Main St", 123);
        Adress expectedAdress = new Adress();
        ResponseEntity<Adress> createResponse = new ResponseEntity<>(expectedAdress,HttpStatus.OK);
        when(service.create(adressDTO)).thenReturn(createResponse);

        // Act
        ResponseEntity<Adress> result = controller.create(adressDTO);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void updateAddress() {
        // Arrange
        Long addressId = 1L;
        AdressDTO addressDTO = new AdressDTO("Updated City", "456 Elm St", 456);
        when(service.update(addressId, addressDTO)).thenReturn(new ResponseEntity<>(HttpStatus.OK));

        // Act
        ResponseEntity<Object> result = controller.update(addressDTO, addressId);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void deleteAddress() {
        // Arrange
        Long addressId = 1L;
        when(service.delete(addressId)).thenReturn(new ResponseEntity<>(HttpStatus.OK));

        // Act
        ResponseEntity<Object> result = controller.Delete(addressId);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}