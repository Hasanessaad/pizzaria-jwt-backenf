package br.com.contas.demo.repository;
import org.assertj.core.api.Assertions;
import br.com.contas.demo.entity.Client;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class ClientRepositoryTest {

    @Autowired
    private Client_Repository underTest;


    @AfterEach
    void tearDown () {
        underTest.deleteAll();;
    }

    @Test
    void findByIdtest () {
        //setup
        Client client = new Client("Jose", "459911224630" , "010.254.719-03");
        //when
        underTest.save(client);
        Optional<Client> expected = underTest.findById(client.getId());
        //assert
        Assertions.assertThat(expected).isNotEmpty();
    }

    @Test
    void notFindByIdtest () {
        //setup
        Client client = new Client("Jose", "459911224630" , "010.254.719-03");
        //when

        underTest.save(client);

        underTest.deleteAll();

        Optional<Client> expected = underTest.findById(client.getId());
        //assert
        Assertions.assertThat(expected).isEmpty();
    }

    @Test
    void findByNameTest () {
        Client client = new Client("Jose", "459911224630" , "010.254.719-03");
        underTest.save(client);
        Optional<Client> expected = underTest.findByNome(client.getNome());
        Assertions.assertThat(expected).isNotEmpty();
    }
    @Test
    void NotFindByNameTest () {
        Client client = new Client("Jose", "459911224630" , "010.254.719-03");

//        underTest.save(client);
        Optional<Client> expected = underTest.findByNome(client.getNome());
        Assertions.assertThat(expected).isEmpty();
    }






}