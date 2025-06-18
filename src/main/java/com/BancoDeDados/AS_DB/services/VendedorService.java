package com.BancoDeDados.AS_DB.services;

import com.BancoDeDados.AS_DB.model.Vendedor;
import com.BancoDeDados.AS_DB.model.Vendedor;
import com.BancoDeDados.AS_DB.repositories.VendedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedorService {

    private VendedorRepository vendedorRepository;

    public VendedorService(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    public List<Vendedor> listarTodosVendedores(){
        return this.vendedorRepository.findAll();
    }

    public Vendedor listarPorId (int id_vendedor) {
        return this.vendedorRepository.findById(id_vendedor).orElseThrow();
    }

    public Vendedor criarVendedor (Vendedor vendedorRequest){
        return this.vendedorRepository.save(vendedorRequest);
    }

    public void updateVendedor(int id_vendedor, Vendedor vendedorRequest){
        Vendedor vendedor = this.vendedorRepository.getReferenceById(id_vendedor);
        vendedor.setCpf(vendedorRequest.getCpf());

        this.vendedorRepository.save(vendedor);
    }


    public void deleteVendedor (int id_vendedor){
        Vendedor vendedor = this.vendedorRepository.getReferenceById(id_vendedor);
        this.vendedorRepository.delete(vendedor);
    }
}
