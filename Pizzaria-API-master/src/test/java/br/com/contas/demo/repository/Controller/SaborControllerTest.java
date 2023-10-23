package br.com.contas.demo.repository.Controller;

import br.com.contas.demo.controller.SaborController;
import br.com.contas.demo.dto.SaborDTO;
import br.com.contas.demo.entity.Sabor;
import br.com.contas.demo.service.SaborService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SaborControllerTest {

    @InjectMocks
    private SaborController saborController;

    @Mock
    private SaborService saborService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
     void testFindAll() {
        // Arrange
        Sabor sabor1 = new Sabor(1L,"Margherita", 2.0f);
        Sabor sabor2 = new Sabor(2L,"Pepperoni", 2.0f);
        List<Sabor> saborList = Arrays.asList(sabor1, sabor2);

        when(saborService.Findall()).thenReturn(saborList);

        // Act
        List<Sabor> result = saborController.Findall();

        // Assert
        assertEquals(saborList, result);
    }

    @Test
     void testFindByNome() {
        // Arrange
        String nome = "Margherita";
        Sabor sabor = new Sabor(1L,nome, 0.0f);

        when(saborService.findByNome(nome)).thenReturn(sabor);

        // Act
        Sabor result = saborController.findByNome(nome);

        // Assert
        assertEquals(sabor, result);
    }

    @Test
     void testCreate() {
        // Arrange
        SaborDTO saborDTO = new SaborDTO("Pepperoni", 2.0f);
        Sabor createdSabor = new Sabor(1L,"Pepperoni", 2.0f);

        when(saborService.create(saborDTO)).thenReturn(new ResponseEntity<>(createdSabor, HttpStatus.CREATED));

        // Act
        ResponseEntity<Sabor> result = saborController.create(saborDTO);

        // Assert
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(createdSabor, result.getBody());
    }

    @Test
     void testUpdate() {
        // Arrange
        Long id = 1L;
        SaborDTO saborDTO = new SaborDTO("Calabresa", 1.5f);

        when(saborService.update(id, saborDTO)).thenReturn(new ResponseEntity<>(HttpStatus.OK));

        // Act
        ResponseEntity<Object> result = saborController.update(saborDTO, id);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
     void testDelete() {
        // Arrange
        Long id = 1L;

        when(saborService.delete(id)).thenReturn(new ResponseEntity<>(HttpStatus.NO_CONTENT));

        // Act
        ResponseEntity<Object> result = saborController.Delete(id);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
    }
}