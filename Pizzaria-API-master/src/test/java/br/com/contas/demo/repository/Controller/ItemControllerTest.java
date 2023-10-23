package br.com.contas.demo.repository.Controller;

import br.com.contas.demo.controller.ItemController;
import br.com.contas.demo.dto.ItemDTO;
import br.com.contas.demo.entity.Item;
import br.com.contas.demo.service.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ItemControllerTest {

    @InjectMocks
    private ItemController controller;

    @Mock
    private ItemService service;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void findAllItems() {
        // Arrange
        List<Item> itemList = new ArrayList<>();
        when(service.Findall()).thenReturn(itemList);

        // Act
        List<Item> result = controller.Findall();

        // Assert
        assertEquals(itemList, result);
    }

    @Test
    void findItemByCode() {
        // Arrange
        String itemCode = "ITEM123";
        Item item = new Item(1L, itemCode, 10.0f, true);
        when(service.FindByCodigo(itemCode)).thenReturn(Optional.of(item));

        // Act
        Optional<Item> result = controller.FindByCOdigo(itemCode);

        // Assert
        assertEquals(Optional.of(item), result);
    }

    @Test
    void createItem() {
        // Arrange
        ItemDTO itemDTO = new ItemDTO("ITEM123", 10.0f, true, 30, "Extra", "Remove", new ArrayList<>());
        when(service.create(itemDTO)).thenReturn(new ResponseEntity<>(HttpStatus.CREATED));

        // Act
        ResponseEntity<Item> result = controller.create(itemDTO);

        // Assert
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
    }

    @Test
    void updateItem() {
        // Arrange
        Long itemId = 1L;
        ItemDTO itemDTO = new ItemDTO("ITEM123", 15.0f, true, 30, "Updated Extra", "Updated Remove", new ArrayList<>());
        when(service.update(itemId, itemDTO)).thenReturn(new ResponseEntity<>(HttpStatus.OK));

        // Act
        ResponseEntity<Object> result = controller.update(itemDTO, itemId);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void deleteItem() {
        // Arrange
        Long itemId = 1L;
        when(service.delete(itemId)).thenReturn(new ResponseEntity<>(HttpStatus.OK));

        // Act
        ResponseEntity<Object> result = controller.Delete(itemId);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}