package br.com.contas.demo.repository.Entity;

import br.com.contas.demo.entity.Adress;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdressTest {

    @Test
     void testGettersAndSetters() {
        Adress adress = new Adress();

        adress.setId(1L);
        adress.setCidade("Foz do Iguaçu");
        adress.setRua("Rua das Cataratas");
        adress.setNumero_rua(1000);

        assertEquals(1L, adress.getId());
        assertEquals("Foz do Iguaçu", adress.getCidade());
        assertEquals("Rua das Cataratas", adress.getRua());
        assertEquals(1000, adress.getNumero_rua());
    }


    @Test
     void testGetId() {
        Adress adress = new Adress();

        adress.setId(1L);

        assertEquals(1L, adress.getId());
    }
}
