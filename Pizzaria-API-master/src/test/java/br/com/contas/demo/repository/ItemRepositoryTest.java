package br.com.contas.demo.repository;

import br.com.contas.demo.entity.Item;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class ItemRepositoryTest {
    @Autowired
    public  ItemRepository underTest;


    @AfterEach
    void tearDown () {
        underTest.deleteAll();;
    }

    @Test
     void findByCodigoTest () {
        //given
        String codigo = "coca";
        Float preco = 5F;
        Boolean pizza = false;

        Item item    = new Item(codigo, preco, pizza);

        underTest.save(item);

        //when
        Optional<Item> expected = underTest.findByCodigo("coca");

        //then
        Assertions.assertThat(expected).isNotEmpty();

    }

    @Test
     void NoFindByCodigoTest () {
        //given

        //when
        Optional<Item> expected = underTest.findByCodigo("coca");

        //then
        Assertions.assertThat(expected).isEmpty();

    }
}