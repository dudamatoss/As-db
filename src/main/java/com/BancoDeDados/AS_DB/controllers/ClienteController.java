package com.BancoDeDados.AS_DB.controllers;

import com.BancoDeDados.AS_DB.model.Carro;
import com.BancoDeDados.AS_DB.model.Cliente;
import com.BancoDeDados.AS_DB.services.CarroService;
import com.BancoDeDados.AS_DB.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodosClientes() {
        return ResponseEntity
                .ok()
                .body(this.clienteService.listarTodosCliente());
    }

    @GetMapping("/{id_cliente}")
    public ResponseEntity<Cliente> listarPorId (@PathVariable int id_cliente) {
        return ResponseEntity
                .ok(this.clienteService.listarPorId(id_cliente));
    }

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente clienteRequest) {
        Cliente cliente = this.clienteService.criarCliente(clienteRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id_cliente}")
                .buildAndExpand(cliente.getId_cliente()).toUri();

        return ResponseEntity
                .created(uri)
                .body(cliente);
    }
    @PutMapping("/{id_cliente}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable int id_cliente, @RequestBody Cliente clienteAtualizado) {
        this.clienteService.updateCliente(id_cliente, clienteAtualizado);
        return ResponseEntity
                .ok()
                .build();
    }

    @DeleteMapping("/{id_cliente}")
    public ResponseEntity<Void> deleteCliente(@PathVariable int id_cliente) {
        this.clienteService.deleteCliente(id_cliente);
        return  ResponseEntity
                .ok()
                .build();
    }
}
