package br.com.contas.demo.controller;

import br.com.contas.demo.dto.AdressDTO;
import br.com.contas.demo.entity.Adress;
import br.com.contas.demo.entity.Client;
import br.com.contas.demo.service.AdressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/Adress")
public class AdressController {
//aaaa
    @Autowired
    private AdressService service;

    @GetMapping("/findall")

    public List<Adress> Findall() {
        return service.Findall();
    }

    @PostMapping
    public ResponseEntity<Adress> create( @Valid @RequestBody AdressDTO adressDTO) {
        return service.create(adressDTO);
    }

    @PutMapping("/update/id")
    public ResponseEntity<Object> update(@RequestBody AdressDTO adressDTO, @RequestParam Long id){
        return service.update(id, adressDTO);
    }

    @DeleteMapping
    public ResponseEntity<Object> Delete(@RequestParam Long id){
        return service.delete(id);
    }
}
