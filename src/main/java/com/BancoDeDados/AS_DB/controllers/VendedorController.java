package com.BancoDeDados.AS_DB.controllers;

import com.BancoDeDados.AS_DB.model.Cliente;
import com.BancoDeDados.AS_DB.model.Vendedor;
import com.BancoDeDados.AS_DB.services.VendedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {
    private VendedorService vendedorService;

    public VendedorController(VendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }

    @GetMapping
    public ResponseEntity<List<Vendedor>> listarTodosVendedors() {
        return ResponseEntity
                .ok()
                .body(this.vendedorService.listarTodosVendedores());
    }

    @GetMapping("/{id_vendedor}")
    public ResponseEntity<Vendedor> listarPorId (@PathVariable int id_vendedor) {
        return ResponseEntity
                .ok(this.vendedorService.listarPorId(id_vendedor));
    }

    @PostMapping
    public ResponseEntity<Vendedor> criarVendedor(@RequestBody Vendedor vendedorRequest) {
        Vendedor cliente = this.vendedorService.criarVendedor(vendedorRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id_vendedor}")
                .buildAndExpand(cliente.getId_vendedor()).toUri();

        return ResponseEntity
                .created(uri)
                .body(cliente);
    }
    @PutMapping("/{id_vendedor}")
    public ResponseEntity<Vendedor> updateVendedor(@PathVariable int id_vendedor, @RequestBody Vendedor vendedorAtualizado) {
        this.vendedorService.updateVendedor(id_vendedor, vendedorAtualizado);
        return ResponseEntity
                .ok()
                .build();
    }

    @DeleteMapping("/{id_vendedor}")
    public ResponseEntity<Void> deleteVendedor(@PathVariable int id_vendedor) {
        this.vendedorService.deleteVendedor(id_vendedor);
        return  ResponseEntity
                .ok()
                .build();
    }
}
