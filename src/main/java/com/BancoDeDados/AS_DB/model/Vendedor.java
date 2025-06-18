package com.BancoDeDados.AS_DB.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_vendedor;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;

    public Vendedor() {}

    public Vendedor(int id_vendedor, String nome, String cpf, String telefone, String email)
    {
        this.id_vendedor = id_vendedor;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
