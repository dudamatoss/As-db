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

    private Double valorFinal;

    public Vendas() {
    }

    // Construtor com todos os campos (menos id_venda, que é auto-gerado)
    public Vendas(Carro carro, Cliente cliente, Vendedor vendedor, double valorFinal) {
        this.carro = carro;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.valorFinal = valorFinal;
    }

    public Double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    // Getters e setters
    public Integer getId_venda() {
        return id_venda;
    }

    public void setId_venda(Integer id_venda) {
        this.id_venda = id_venda;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}