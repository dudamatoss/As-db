package com.BancoDeDados.AS_DB.controllers;

import com.BancoDeDados.AS_DB.model.Carro;
import com.BancoDeDados.AS_DB.model.Vendas;
import com.BancoDeDados.AS_DB.services.VendaService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/vendas")

public class VendaController {

    private VendaService vendaService;

    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @GetMapping
    public ResponseEntity<List<Vendas>> listarTodosVendas() {
        return ResponseEntity
                .ok()
                .body(this.vendaService.listarTodosVendas());
    }

    @GetMapping("/{id_venda}")
    public ResponseEntity<Vendas> listarPorId (@PathVariable int id_venda) {
        return ResponseEntity
                .ok(this.vendaService.listarPorId(id_venda));
    }

    @PostMapping
    public ResponseEntity<Vendas> criarVendas(@RequestBody Vendas vendaRequest) {
        Vendas cliente = this.vendaService.criarVendas(vendaRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id_venda}")
                .buildAndExpand(cliente.getId_venda()).toUri();

        return ResponseEntity
                .created(uri)
                .body(cliente);
    }

    @PutMapping("/{id_venda}")
    public ResponseEntity<Vendas> updateVendas(@PathVariable int id_venda, @RequestBody Vendas vendaAtualizada) {
        this.vendaService.updateVendas(id_venda, vendaAtualizada);
        return ResponseEntity
                .ok()
                .build();
    }

    @DeleteMapping("/{id_venda}")
    public ResponseEntity<Void> deleteVendas(@PathVariable int id_venda) {
        this.vendaService.deleteVendas(id_venda);
        return  ResponseEntity
                .ok()
                .build();
    }
}
