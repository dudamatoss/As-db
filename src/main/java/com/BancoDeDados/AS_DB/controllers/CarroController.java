package com.BancoDeDados.AS_DB.controllers;

import com.BancoDeDados.AS_DB.model.Carro;
import com.BancoDeDados.AS_DB.services.CarroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {
    private CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping
    public ResponseEntity<List<Carro>> listarTodosCarros() {
        return ResponseEntity
                .ok()
                .body(this.carroService.listarTodosCarros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> listarPorId (@PathVariable int id) {
        return ResponseEntity
                .ok(this.carroService.listarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Carro> criarCarro(@RequestBody Carro carroRequest) {
        Carro carro = this.carroService.criarCarro(carroRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(carro.getId()).toUri();

        return ResponseEntity
                .created(uri)
                .body(carro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarro(@PathVariable int id) {
        this.carroService.deleteCarro(id);
        return  ResponseEntity
                .ok()
                .build();
    }
}
