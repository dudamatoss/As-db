package com.BancoDeDados.AS_DB.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Vendas")
public class Vendas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venda", nullable = false, unique = true)
    private Integer id_venda;


    @OneToOne
    @JoinColumn(name = "id_carro", referencedColumnName = "id_carro")
    private Carro carro;


    @OneToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_vendedor", referencedColumnName = "id_vendedor")
    private Vendedor vendedor;

    public Vendas() {}

    public Vendas(int id_venda,Carro id_carro, Cliente id_cliente) {
        this.id_venda = id_venda;
        this.carro = carro;
        this.cliente = cliente;

    }

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public Carro getId_carro() {
        return carro;
    }

    public void setId_carro(Carro carro) {
        this.carro = carro;
    }

    public Cliente getId_cliente() {
        return cliente;
    }

    public void setId_cliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}
