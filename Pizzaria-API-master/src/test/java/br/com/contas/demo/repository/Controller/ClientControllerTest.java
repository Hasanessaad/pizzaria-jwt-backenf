package br.com.contas.demo.repository.Controller;

import br.com.contas.demo.controller.ClientController;
import br.com.contas.demo.dto.AdressDTO;
import br.com.contas.demo.dto.ClientDTO;
import br.com.contas.demo.entity.Client;
import br.com.contas.demo.service.ClientService;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClientControllerTest {

    @InjectMocks
    private ClientController controller;

    @Mock
    private ClientService service;

    private Validator validator;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    void findAllClients() {
        // Arrange
        List<Client> clients = new ArrayList<>();
        when(service.Findall()).thenReturn(clients);

        // Act
        List<Client> result = controller.Findall();

        // Assert
        assertEquals(clients, result);
    }

    @Test
    void findClientsByName() {
        // Arrange
        String name = "John";
        List<Optional<Client>> clients = new ArrayList<>();
        when(service.FindByName(name)).thenReturn(clients);

        // Act
        List<Optional<Client>> result = controller.findByName(name);

        // Assert
        assertEquals(clients, result);
    }

    @Test
    void createClient() {
        // Arrange
        ClientDTO clientDTO = new ClientDTO("John Doe", "1234567890", "12345678901");
        Client expectedClient = new Client(); // You should create an expected client object here.
        when(service.create(clientDTO)).thenReturn(expectedClient);

        // Act
        Client result = controller.create(clientDTO);

        // Assert
        assertEquals(expectedClient, result);
    }

    @Test
    void updateClient() {
        // Arrange
        Long clientId = 1L;
        ClientDTO clientDTO = new ClientDTO("Updated Name", "9876543210", "98765432109");

        // Act
        ResponseEntity<Client> result = controller.update(clientDTO, clientId);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void deleteClient() {
        // Arrange
        Long clientId = 1L;
        when(service.delete(clientId)).thenReturn(new ResponseEntity<>(HttpStatus.OK));

        // Act
        ResponseEntity<Object> result = controller.Delete(clientId);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void addAddressToClient() {
        // Arrange
        Long clientId = 1L;
        AdressDTO addressDTO = new AdressDTO("123 Main St", "City", 12345);
        Client client = new Client();
        when(service.AddAdress(clientId, addressDTO)).thenReturn(client);

        // Act
        ResponseEntity<Object> result = controller.addAdress(addressDTO, clientId);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}