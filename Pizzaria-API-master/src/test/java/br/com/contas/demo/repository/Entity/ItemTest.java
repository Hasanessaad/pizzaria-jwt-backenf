package br.com.contas.demo.repository.Entity;

import br.com.contas.demo.entity.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {

    @Test
     void testGettersAndSetters() {
        Item item = new Item();

        item.setCodigo("ABC123");
        item.setPreco(10.0f);
        item.setPizza(true);
        item.setTamanho(30);
        item.setExtra("Extra cheese");
        item.setRemove("Onions");

        assertEquals("ABC123", item.getCodigo());
        assertEquals(10.0f, item.getPreco());
        assertEquals(true, item.getPizza());
        assertEquals(30, item.getTamanho());
        assertEquals("Extra cheese", item.getExtra());
        assertEquals("Onions", item.getRemove());
    }

    @Test
     void testGetId() {
        Item item = new Item();

        item.setId(1L);

        assertEquals(1L, item.getId());
    }
}
