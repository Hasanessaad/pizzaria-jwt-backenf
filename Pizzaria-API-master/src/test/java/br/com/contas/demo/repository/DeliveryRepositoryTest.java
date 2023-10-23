package br.com.contas.demo.repository;

import br.com.contas.demo.entity.Delivery;
import br.com.contas.demo.entity.MetodoEntrega;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class DeliveryRepositoryTest {

    @Autowired
    private DeliveryRepository underTest;



    @AfterEach
    void tearDown () {
        underTest.deleteAll();;
    }

    @Test
     void findByMetodoEntregaTest () {
        //given
        Delivery delivery = new Delivery(1L, MetodoEntrega.DELIVERY, "joaquim", 15.8F );
        underTest.save(delivery);

        //when
        List<Delivery> expected = underTest.findByMetodoEntrega(MetodoEntrega.DELIVERY);

        //then
        Assertions.assertThat(expected).isNotEmpty();

    }

    @Test
     void notFindByMetodoEntregaTest () {

        //when
        List<Delivery> expected = underTest.findByMetodoEntrega(MetodoEntrega.DELIVERY);

        //then
        Assertions.assertThat(expected).isEmpty();


    }


}