package br.com.contas.demo.service;

import br.com.contas.demo.dto.SaborDTO;
import br.com.contas.demo.entity.Sabor;
import br.com.contas.demo.repository.SaborRepository;
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

class SaborServiceTest {

    @InjectMocks
    private SaborService saborService;

    @Mock
    private SaborRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testUpdate() {
        // Create a mock SaborDTO for testing
        SaborDTO saborDTO = new SaborDTO();
        saborDTO.setNome("Test Flavor");
        // Set other properties as needed

        // Create a mock Sabor for testing
        Sabor mockSabor = new Sabor();
        mockSabor.setId(1L);
        // Set other properties as needed

        // Configure the mock behavior of the repository
        when(repository.findById(anyLong())).thenReturn(Optional.of(mockSabor));

        // Call the update method
        ResponseEntity<Object> result = saborService.update(1L, saborDTO);

        // Verify the behavior and assertions
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void testCreate() {
        // Create a mock SaborDTO for testing
        SaborDTO saborDTO = new SaborDTO();
        saborDTO.setNome("Test Flavor");
        // Set other properties as needed

        // Call the create method
        ResponseEntity<Sabor> result = saborService.create(saborDTO);

        // Verify the behavior and assertions
        assertEquals("Test Flavor", result.getBody().getNome()); // Assuming you set "Test Flavor" in the DTO
        verify(repository, times(1)).save(any(Sabor.class)); // Verify that save was called once
    }

    @Test
    void testDelete() {
        // Create a mock Sabor for testing
        Sabor mockSabor = new Sabor();
        mockSabor.setId(1L);
        // Set other properties as needed

        // Configure the mock behavior of the repository
        when(repository.findById(anyLong())).thenReturn(Optional.of(mockSabor));

        // Call the delete method
        ResponseEntity<Object> result = saborService.delete(1L);

        // Verify the behavior and assertions
        assertEquals(HttpStatus.OK, result.getStatusCode());
        verify(repository, times(1)).delete(any(Sabor.class)); // Verify that delete was called once

    }
}