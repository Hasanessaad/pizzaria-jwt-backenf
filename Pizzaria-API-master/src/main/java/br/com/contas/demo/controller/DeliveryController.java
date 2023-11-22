package br.com.contas.demo.controller;

import br.com.contas.demo.dto.DeliveryDTO;
import br.com.contas.demo.entity.Delivery;
import br.com.contas.demo.entity.MetodoEntrega;
import br.com.contas.demo.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService service;

    @GetMapping("/findall")

    public List<Delivery> Findall() {
        return service.Findall();
    }

    @GetMapping("/nome")
    private ResponseEntity<List<Delivery>> findByNome(@RequestParam MetodoEntrega nome) {
        return ResponseEntity.ok(service.FindByMetodoEntrega(nome));
    }

    @PostMapping

    public Delivery create(@RequestBody
                           DeliveryDTO deliveryDTO) {

        return service.create(deliveryDTO);
    }

    @PutMapping("/update")
    private Delivery update(@RequestBody DeliveryDTO deliveryDTO, @RequestParam Long id) {
        return service.update(id, deliveryDTO);
    }

    @DeleteMapping
    private ResponseEntity<String> Delete(@RequestParam long id) {

        return service.delete(id);
    }


}
