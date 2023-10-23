package br.com.contas.demo.service;

import br.com.contas.demo.dto.AdressDTO;
import br.com.contas.demo.dto.ClientDTO;
import br.com.contas.demo.entity.Adress;
import br.com.contas.demo.entity.Client;
import br.com.contas.demo.repository.Adress_repository;
import br.com.contas.demo.repository.Client_Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;

import java.util.Optional;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    private ClientService underTest;
    @Mock
    private Client clientMock;
    @Mock
    private Client_Repository repository;
    @Mock
    private Adress_repository adressRepository;
    ClientDTO client;

    @BeforeEach
    public void Setup() {

       MockitoAnnotations.initMocks(this);
       underTest = new ClientService(repository, adressRepository);
    }

    @Test
    void FindallClient() {
        //when
        underTest.Findall();
        //then
        verify(repository).findAll();
    }

    @Test
    void findByName() {
        //when
        underTest.FindByName("teste");
        //then
        verify(repository).findByNome("teste");
    }

    @Test

    void update() {
        ClientDTO clientDTO = new ClientDTO("jose update", "4599326309", "010.254.719-03");
        ClientDTO clientUpdate = new ClientDTO("Jose", "4599326309", "010.254.719-03");

        Client cliente = new Client();
        Client clientUpdated = new Client();
        BeanUtils.copyProperties(clientUpdate, cliente);
        BeanUtils.copyProperties(clientDTO, cliente);
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(cliente));

        //when
        underTest.update(1L, clientDTO);

        //then
        ArgumentCaptor<Client> clientArgumentCaptor =
                ArgumentCaptor.forClass(Client.class);

        verify(repository).save(clientArgumentCaptor.capture());



    }

    @Test
    void create() {
        //given

        ClientDTO clientDTO = new ClientDTO("Jose", "4599326309", "010.254.719-03");
        Client cliente = new Client();
        BeanUtils.copyProperties(clientDTO, cliente);

        //when
        underTest.create(clientDTO);
        //then
        ArgumentCaptor<Client> clientArgumentCaptor =
                ArgumentCaptor.forClass(Client.class);

        verify(repository).save(clientArgumentCaptor.capture());
    }

    @Test
    void addAdress() {
        //given
        ClientDTO clientDTO = new ClientDTO("Jose", "4599326309", "010.254.719-03");
        Client cliente = new Client();
        BeanUtils.copyProperties(clientDTO, cliente);
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(cliente));
        Adress adress = new Adress();
        AdressDTO adressDTO = new AdressDTO();
        adress.setCidade("foz");
        adress.setRua("Av das cataratas");
        adress.setNumero_rua(12);
        BeanUtils.copyProperties(adress,adressDTO);

        //when
        underTest.AddAdress(1L,adressDTO );

        //then
        ArgumentCaptor<Adress> adressArgumentCaptor =
                ArgumentCaptor.forClass(Adress.class);

        ArgumentCaptor<Client> clientArgumentCaptor =
                ArgumentCaptor.forClass(Client.class);
        verify(adressRepository).save(adressArgumentCaptor.capture());

        verify(repository).save(clientArgumentCaptor.capture());

    }

    @Test

    void delete() {
        //given
        ClientDTO clientDTO = new ClientDTO("Jose", "4599326309", "010.254.719-03");
        Client cliente = new Client();
        BeanUtils.copyProperties(clientDTO, cliente);
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(cliente));

        //when
        underTest.delete(1L);

        //then
        ArgumentCaptor<Client> clientArgumentCaptor =
                ArgumentCaptor.forClass(Client.class);

        verify(repository).delete(clientArgumentCaptor.capture());


    }


}
