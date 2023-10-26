package br.com.contas.demo.controller;

import br.com.contas.demo.dto.AdressDTO;
import br.com.contas.demo.dto.ItemDTO;
import br.com.contas.demo.dto.SaborDTO;
import br.com.contas.demo.entity.Client;
import br.com.contas.demo.entity.Item;
import br.com.contas.demo.entity.Sabor;
import br.com.contas.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/Item")
public class ItemController {

    @Autowired
    private ItemService service;

    @GetMapping("/findall")

    public List<Item> Findall() {
        return service.Findall();
    }

    @GetMapping("/codigo")
    public Optional<Item> FindByCOdigo(@RequestParam String codigo) {
        return service.FindByCodigo(codigo);
    }

    @PostMapping("/create")
    public ResponseEntity<Item> create(@RequestBody ItemDTO itemDTO) {

        return service.create(itemDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody ItemDTO itemDTO, @RequestParam Long id) {
        return service.update(id, itemDTO);
    }

    @DeleteMapping
    public ResponseEntity<Object> Delete(@RequestParam long id) {

        return service.delete(id);
    }

    @PutMapping("/sabor")
    public ResponseEntity<Object> AddSabor(@RequestBody SaborDTO saborDTO, @RequestParam Long id) {
        Item item = service.AddSabor(id, saborDTO);

        return ResponseEntity.ok(item);
    }


}
