package br.com.contas.demo.service;

import br.com.contas.demo.dto.AdressDTO;
import br.com.contas.demo.dto.ItemDTO;
import br.com.contas.demo.dto.OrdersDTO;
import br.com.contas.demo.entity.*;
import br.com.contas.demo.repository.ItemRepository;
import br.com.contas.demo.repository.OrdersRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrdersRepository repository;

    @Autowired
    private ItemRepository itemRepository;

    public List<Orders> Findall() {
        return repository.findAll();
    }

    public List<Orders> findByStatus(Status name) {
        return repository.findByStatus(name);
    }

    public ResponseEntity<Object> update(Long id, OrdersDTO orderDTO) {
        Optional<Orders> order_update = repository.findById(id);
        if (order_update.isEmpty()) {
            ResponseEntity<Object> objectResponseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return objectResponseEntity;
        } else {
            Orders order = order_update.get();
            BeanUtils.copyProperties(orderDTO, order);
            return ResponseEntity.ok(order_update);
        }
    }

    public ResponseEntity<Orders> create(OrdersDTO orderDTO) {

        try {
            Orders order = new Orders();
            BeanUtils.copyProperties(orderDTO, order);
            order.setData(LocalDateTime.now());
            repository.save(order);

            return ResponseEntity.ok(order);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    public Orders AddItem(Long id, ItemDTO itemDTO) {
        Optional<Orders> orders_update = repository.findById(id);
        if (orders_update.isEmpty()) {
            throw new RuntimeException();
        } else {
            Orders orders = orders_update.get();
            List<Item> itemses = new ArrayList<>();
            Item items = new Item();

            BeanUtils.copyProperties(itemDTO, items);
            itemRepository.save(items);
            itemses.add(items);
            orders.setItems(itemses);
            repository.save(orders);


            return orders;

        }

    }

}
