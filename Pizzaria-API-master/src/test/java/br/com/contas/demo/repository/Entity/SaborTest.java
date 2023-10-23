package br.com.contas.demo.repository.Entity;

import br.com.contas.demo.entity.Sabor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaborTest {

    @Test
    public void testGettersAndSetters() {
        Sabor sabor = new Sabor();

        sabor.setId(1L);
        sabor.setNome("Calabresa");
        sabor.setPreco_adicional(0.0f);

        assertEquals(1L, sabor.getId());
        assertEquals("Calabresa", sabor.getNome());
        assertEquals(0.0f, sabor.getPreco_adicional());
    }

    @Test
     void testGetId() {
        Sabor sabor = new Sabor();

        sabor.setId(1L);

        assertEquals(1L, sabor.getId());
    }
}