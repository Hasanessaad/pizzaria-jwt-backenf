package br.com.contas.demo.service;

import br.com.contas.demo.dto.ItemDTO;
import br.com.contas.demo.entity.Item;
import br.com.contas.demo.repository.ItemRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository repository;


    public List<Item> Findall() { return repository.findAll();}

    public Optional<Item> FindByCodigo(String name) { return repository.findByCodigo(name);}

    public ResponseEntity<Object> update (Long id, ItemDTO itemDTO){
        Optional<Item> iteme_update = repository.findById(id);
        if ( iteme_update.isEmpty()) {
            ResponseEntity<Object> objectResponseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return objectResponseEntity;
        } else {
            Item item = iteme_update.get();
            BeanUtils.copyProperties(itemDTO,item);
            return ResponseEntity.ok(iteme_update);

        }

    }

    public ResponseEntity<Item> create(ItemDTO itemDTO){

        try {
            Item iteme = new Item();
            BeanUtils.copyProperties(itemDTO, iteme);

            repository.save(iteme);

            return ResponseEntity.ok(iteme);
        } catch (Exception e) {
         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}

    }


    public ResponseEntity<Object> delete ( Long id){
        Optional<Item> iteme_optional = repository.findById(id) ;
        if ( iteme_optional.isEmpty()) {
            ResponseEntity<Object> objectResponseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return objectResponseEntity;
        } else {


        Item iteme = iteme_optional.get();
        repository.delete(iteme);
        return ResponseEntity.ok("Iteme deletado com sucesso");


        }

    }





}
