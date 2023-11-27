package br.com.contas.demo.controller;

import br.com.contas.demo.dto.AdressDTO;
import br.com.contas.demo.dto.ItemDTO;
import br.com.contas.demo.dto.OrdersDTO;
import br.com.contas.demo.entity.Orders;
import br.com.contas.demo.entity.Orders;
import br.com.contas.demo.entity.Status;
import br.com.contas.demo.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Order")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping("/findall")

    public List<Orders> Findall() {
        return service.Findall();
    }


    @GetMapping("/nome/{status}")

    public List<Orders> findByStatus(@RequestParam Status status) {
        return service.findByStatus(status);
    }

    @PostMapping("/create")

    public ResponseEntity<Orders> create(@RequestBody OrdersDTO orderDTO) {

        return service.create(orderDTO);
    }

    ;

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody OrdersDTO orderDTO, @RequestParam Long id) {
        return service.update(id, orderDTO);
    }

    @PutMapping("/Item")
    public ResponseEntity<Object> addItem(@RequestBody ItemDTO itemDTO, @RequestParam Long id) {
    Orders order = service.AddItem(id, itemDTO);

        return ResponseEntity.ok(order);
    }

}
