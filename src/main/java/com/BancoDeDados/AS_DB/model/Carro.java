package com.BancoDeDados.AS_DB.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Carros")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carro", nullable = false)
    private Integer id_carro;

    private String modelo;
    private String marca;
    private int ano;
    private String status;
    private double preco;
    private String placa;

    public Carro() {}

    public Carro(int id, String modelo, String marca, int ano, String status, double preco, String placa) {
        this.id_carro = id;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.status = status;
        this.preco = preco;
        this.placa = placa;
    }

    public int getId() {
        return id_carro;
    }

    public void setId(int id) {
        this.id_carro = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}