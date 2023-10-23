package br.com.contas.demo.service;

import br.com.contas.demo.dto.AdressDTO;
import br.com.contas.demo.entity.Adress;
import br.com.contas.demo.repository.Adress_repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AdressServiceTest {

    @InjectMocks
    private AdressService adressService;

    @Mock
    private Adress_repository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testUpdate() {
        // Create a mock AdressDTO for testing
        AdressDTO adressDTO = new AdressDTO();
        adressDTO.setCidade("City");
        // Set other properties as needed

        // Create a mock Adress for testing
        Adress mockAdress = new Adress();
        mockAdress.setId(1L);
        // Set other properties as needed

        // Configure the mock behavior of the repository
        when(repository.findById(anyLong())).thenReturn(Optional.of(mockAdress));

        // Call the update method
        ResponseEntity<Object> result = adressService.update(1L, adressDTO);

        // Verify the behavior and assertions
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void testCreate() {
        // Create a mock AdressDTO for testing
        AdressDTO adressDTO = new AdressDTO();
        adressDTO.setCidade("City");
        // Set other properties as needed

        // Call the create method
        ResponseEntity<Adress> result = adressService.create(adressDTO);

        // Verify the behavior and assertions
        assertEquals("City", result.getBody().getCidade()); // Assuming you set "City" in the DTO
        verify(repository, times(1)).save(any(Adress.class)); // Verify that save was called once
    }

    @Test
    void testDelete() {
        // Create a mock Adress for testing
        Adress mockAdress = new Adress();
        mockAdress.setId(1L);
        // Set other properties as needed

        // Configure the mock behavior of the repository
        when(repository.findById(anyLong())).thenReturn(Optional.of(mockAdress));

        // Call the delete method
        ResponseEntity<Object> result = adressService.delete(1L);

        // Verify the behavior and assertions
        assertEquals(HttpStatus.OK, result.getStatusCode());
        verify(repository, times(1)).delete(any(Adress.class)); // Verify that delete was called once
    }
}