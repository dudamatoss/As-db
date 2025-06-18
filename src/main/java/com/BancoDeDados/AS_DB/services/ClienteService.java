package com.BancoDeDados.AS_DB.services;

import com.BancoDeDados.AS_DB.model.Carro;
import com.BancoDeDados.AS_DB.model.Cliente;
import com.BancoDeDados.AS_DB.repositories.CarroRepository;
import com.BancoDeDados.AS_DB.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarTodosCliente(){
        return this.clienteRepository.findAll();
    }

    public Cliente listarPorId (int id) {
        return this.clienteRepository.findById(id).orElseThrow();
    }

    public Cliente criarCarro (Cliente clienteRequest){
        return this.clienteRepository.save(clienteRequest);
    }

    public void updateCliente(int id_cliente, Cliente clienteRequest){
        Cliente cliente = this.clienteRepository.getReferenceById(id_cliente);
        cliente.setCpf(clienteRequest.getCpf());

        this.clienteRepository.save(cliente);
    }


    public void deleteCliente (int id_cliente){
        Cliente cliente = this.clienteRepository.getReferenceById(id_cliente);
        this.clienteRepository.delete(cliente);
    }
}
