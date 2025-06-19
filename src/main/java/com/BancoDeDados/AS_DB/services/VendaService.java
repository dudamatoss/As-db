package com.BancoDeDados.AS_DB.services;

import com.BancoDeDados.AS_DB.model.Vendas;
import com.BancoDeDados.AS_DB.repositories.VendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VendaService {

    private VendaRepository vendaRepository;

    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public List<Vendas> listarTodosVendas(){
        return this.vendaRepository.findAll();
    }

    public Vendas listarPorId (int id_venda) {
        return this.vendaRepository.findById(id_venda).orElseThrow();
    }

    public Vendas criarVendas (Vendas vendaRequest){
        return this.vendaRepository.save(vendaRequest);
    }

    public void updateVendas(int id_venda, Vendas vendaRequest){
        Vendas cliente = this.vendaRepository.getReferenceById(id_venda);
        cliente.setId_venda(vendaRequest.getId_venda());

        this.vendaRepository.save(cliente);
    }


    public void deleteVendas (int id_venda_cliente){
        Vendas cliente = this.vendaRepository.getReferenceById(id_venda_cliente);
        this.vendaRepository.delete(cliente);
    }
}


