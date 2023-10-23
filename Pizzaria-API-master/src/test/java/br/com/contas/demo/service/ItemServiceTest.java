package br.com.contas.demo.service;

import br.com.contas.demo.dto.ItemDTO;
import br.com.contas.demo.entity.Item;
import br.com.contas.demo.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ItemServiceTest {

    @InjectMocks
    private ItemService itemService;

    @Mock
    private ItemRepository itemRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
     void testFindAll() {
        // Arrange
        Item item1 = new Item(1L, "123", 10.0f, true);
        Item item2 = new Item(2L, "456", 15.0f, false);
        List<Item> itemList = Arrays.asList(item1, item2);

        when(itemRepository.findAll()).thenReturn(itemList);

        // Act
        List<Item> result = itemService.Findall();

        // Assert
        assertEquals(itemList, result);
    }

    @Test
     void testFindByCodigo() {
        // Arrange
        String codigo = "123";
        Item item = new Item(1L, codigo, 10.0f, true);

        when(itemRepository.findByCodigo(codigo)).thenReturn(Optional.of(item));

        // Act
        Optional<Item> result = itemService.FindByCodigo(codigo);

        // Assert
        assertEquals(Optional.of(item), result);
    }

    @Test
     void testCreate() {
        // Arrange
        ItemDTO itemDTO = new ItemDTO("789", 20.0f, false, 12, "Extra", "Remove", Arrays.asList(1L));
        Item createdItem = new Item(1L, "789", 20.0f, false, 12, "Extra", "Remove");

        when(itemRepository.save(any(Item.class))).thenReturn(createdItem);

        // Act
        ResponseEntity<Item> result = itemService.create(itemDTO);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
     void testUpdate() {
        // Arrange
        Long id = 1L;
        ItemDTO itemDTO = new ItemDTO("789", 20.0f, false, 12, "Extra", "Remove", Arrays.asList(1L));
        Item existingItem = new Item(id, "123", 10.0f, true);

        when(itemRepository.findById(id)).thenReturn(Optional.of(existingItem));
        when(itemRepository.save(any(Item.class))).thenReturn(existingItem);

        // Act
        ResponseEntity<Object> result = itemService.update(id, itemDTO);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
     void testDelete() {
        // Arrange
        Long id = 1L;
        Item existingItem = new Item(id, "123", 10.0f, true);

        when(itemRepository.findById(id)).thenReturn(Optional.of(existingItem));

        // Act
        ResponseEntity<Object> result = itemService.delete(id);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}