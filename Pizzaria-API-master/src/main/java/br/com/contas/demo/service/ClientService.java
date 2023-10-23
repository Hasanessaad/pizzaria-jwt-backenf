package br.com.contas.demo.service;

import br.com.contas.demo.dto.AdressDTO;
import br.com.contas.demo.dto.ClientDTO;
import br.com.contas.demo.entity.Adress;
import br.com.contas.demo.entity.Client;
import br.com.contas.demo.repository.Adress_repository;
import br.com.contas.demo.repository.Client_Repository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {


    private Client_Repository repository;

    private Adress_repository adressRepository;

    public ClientService(Client_Repository repository, Adress_repository adressRepository) {
        this.repository = repository;
        this.adressRepository = adressRepository;
    }


    public List<Client> Findall() { return repository.findAll();}

    public List<Optional<Client>> FindByName(String name) { return Collections.singletonList(repository.findByNome(name));}

    public ResponseEntity<Client> update (Long id, ClientDTO clientDTO){
        Optional<Client> cliente_update = repository.findById(id);
        if ( cliente_update.isEmpty()) {
            throw new RuntimeException("cliente nao existe");
        } else {
            Client client = cliente_update.get();
            BeanUtils.copyProperties(clientDTO,client);
            repository.save(client);

            return new ResponseEntity<Client>(HttpStatus.OK);

        }

    }

    public Client create( ClientDTO clientDTO){

        try {
            Client cliente = new Client();
            BeanUtils.copyProperties(clientDTO, cliente);

            repository.save(cliente);

            return cliente;
        } catch (Exception e) {
         throw new RuntimeException(e.getCause().getMessage()) ;
                 }

    }



    public Client AddAdress(Long id, AdressDTO adressdto) {
        Optional<Client> cliente_update = repository.findById(id);
        if ( cliente_update.isEmpty()) {
            throw new RuntimeException() ;
        } else {
            Client client = cliente_update.get();
            List<Adress> adresses = new ArrayList<>();
            Adress adress = new Adress();

            BeanUtils.copyProperties(adressdto, adress);
            adressRepository.save(adress);
            adresses.add(adress);
            client.setEndereco(adresses);
            repository.save(client);



            return client;

        }

    }

    public ResponseEntity<Object> delete ( Long id){
        Optional<Client> cliente_optional = repository.findById(id) ;
        if ( cliente_optional.isEmpty()) {
            ResponseEntity<Object> objectResponseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return objectResponseEntity;
        } else {


        Client cliente = cliente_optional.get();
        repository.delete(cliente);
        return ResponseEntity.ok("Cliente deletado com sucesso");


        }

    }





}
