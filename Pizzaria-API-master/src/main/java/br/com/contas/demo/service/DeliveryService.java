package br.com.contas.demo.service;

import br.com.contas.demo.dto.DeliveryDTO;
import br.com.contas.demo.entity.Delivery;
import br.com.contas.demo.entity.MetodoEntrega;
import br.com.contas.demo.repository.DeliveryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {


    private DeliveryRepository repository;

    public DeliveryService(DeliveryRepository repository) {
        this.repository = repository;
    }

    public List<Delivery> Findall() { return repository.findAll();}

    public List<Delivery> FindByMetodoEntrega(MetodoEntrega name) { return repository.findByMetodoEntrega(name);}

    public Delivery update (Long id, DeliveryDTO deliveryDTO){
        Optional<Delivery> delivery_update = repository.findById(id);
        if ( delivery_update.isEmpty()) {
            throw  new RuntimeException("Entrega nao econtrada");
        } else {
            Delivery delivery = delivery_update.get();
            BeanUtils.copyProperties(deliveryDTO,delivery);
            repository.save(delivery);
            return delivery;

        }

    }

    public Delivery create(DeliveryDTO deliveryDTO){

        try {
            Delivery delivery = new Delivery();
            BeanUtils.copyProperties(deliveryDTO, delivery);

            repository.save(delivery);

            return delivery;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }


    public ResponseEntity<String> delete ( Long id){
        Optional<Delivery> delivery_optional = repository.findById(id) ;
        if ( delivery_optional.isEmpty()) {
            throw new RuntimeException();
        } else {
        Delivery delivery = delivery_optional.get();
        repository.delete(delivery);
        return new ResponseEntity<>("Delivery deletado", HttpStatus.OK);

        }

    }





}
