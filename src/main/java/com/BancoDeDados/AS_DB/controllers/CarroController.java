package com.BancoDeDados.AS_DB.controllers;

import com.BancoDeDados.AS_DB.model.Carro;
import com.BancoDeDados.AS_DB.model.Cliente;
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

    @GetMapping("/{id_carro}")
    public ResponseEntity<Carro> listarPorId (@PathVariable int id_carro) {
        return ResponseEntity
                .ok(this.carroService.listarPorId(id_carro));
    }

    @PostMapping
    public ResponseEntity<Carro> criarCarro(@RequestBody Carro carroRequest) {
        Carro carro = this.carroService.criarCarro(carroRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id_carro}")
                .buildAndExpand(carro.getId_carro()).toUri();

        return ResponseEntity
                .created(uri)
                .body(carro);
    }
    @PutMapping("/{id_carro}")
    public ResponseEntity<Carro> updateCarro(@PathVariable int id_carro, @RequestBody Carro carroAtualizado) {
        this.carroService.updateCarro(id_carro, carroAtualizado);
        return ResponseEntity
                .ok()
                .build();
    }


    @DeleteMapping("/{id_carro}")
    public ResponseEntity<Void> deleteCarro(@PathVariable int id_carro) {
        this.carroService.deleteCarro(id_carro);
        return  ResponseEntity
                .ok()
                .build();
    }
}
