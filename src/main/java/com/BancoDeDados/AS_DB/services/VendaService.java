package com.BancoDeDados.AS_DB.services;

import com.BancoDeDados.AS_DB.DTO.VendaDTO;
import com.BancoDeDados.AS_DB.model.Carro;
import com.BancoDeDados.AS_DB.model.Cliente;
import com.BancoDeDados.AS_DB.model.Vendas;
import com.BancoDeDados.AS_DB.model.Vendedor;
import com.BancoDeDados.AS_DB.repositories.CarroRepository;
import com.BancoDeDados.AS_DB.repositories.ClienteRepository;
import com.BancoDeDados.AS_DB.repositories.VendaRepository;
import com.BancoDeDados.AS_DB.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
public class VendaService {

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

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

    public void updateVendas(int id_venda, Vendas vendaRequest) {
        Vendas venda = this.vendaRepository.getReferenceById(id_venda);

        if (vendaRequest.getCarro() != null && vendaRequest.getCarro().getId_carro() != null) {
            Carro carro = carroRepository.getReferenceById(vendaRequest.getCarro().getId_carro());
            venda.setCarro(carro);
        }

        if (vendaRequest.getCliente() != null && vendaRequest.getCliente().getId_cliente() != null) {
            Cliente cliente = clienteRepository.getReferenceById(vendaRequest.getCliente().getId_cliente());
            venda.setCliente(cliente);
        }

        if (vendaRequest.getVendedor() != null && vendaRequest.getVendedor().getId_vendedor() != null) {
            Vendedor vendedor = vendedorRepository.getReferenceById(vendaRequest.getVendedor().getId_vendedor());
            venda.setVendedor(vendedor);
        }

        if (vendaRequest.getValorFinal() != null) {
            venda.setValorFinal(vendaRequest.getValorFinal());
        }

        this.vendaRepository.save(venda);
    }


    public void deleteVendas (int id_venda_cliente){
        Vendas cliente = this.vendaRepository.getReferenceById(id_venda_cliente);
        this.vendaRepository.delete(cliente);
    }

    public VendaDTO toDTO(Vendas venda) {
        return new VendaDTO(
                venda.getId_venda(),
                venda.getVendedor() != null ? venda.getVendedor().getId_vendedor() : null,
                venda.getCliente() != null ? venda.getCliente().getId_cliente() : null,
                venda.getCarro() != null ? venda.getCarro().getId_carro() : null,
                venda.getValorFinal() != null ? venda.getValorFinal() : 0.0
        );
    }
}


