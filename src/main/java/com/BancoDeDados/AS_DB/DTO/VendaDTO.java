package com.BancoDeDados.AS_DB.DTO;

public class VendaDTO {
    private Integer id_venda;
    private Integer id_vendedor;
    private Integer id_cliente;
    private Integer id_carro;
    private Double valorFinal;

    // Construtor vazio
    public VendaDTO() {}


    public VendaDTO(Integer id_venda, Integer id_vendedor, Integer id_cliente, Integer id_carro, Double valorFinal) {
        this.id_venda = id_venda;
        this.id_vendedor = id_vendedor;
        this.id_cliente = id_cliente;
        this.id_carro = id_carro;
        this.valorFinal = valorFinal;
    }

    // Getters e setters
    public Integer getId_venda() { return id_venda; }
    public void setId_venda(Integer id_venda) { this.id_venda = id_venda; }

    public Integer getId_vendedor() { return id_vendedor; }
    public void setId_vendedor(Integer id_vendedor) { this.id_vendedor = id_vendedor; }

    public Integer getId_cliente() { return id_cliente; }
    public void setId_cliente(Integer id_cliente) { this.id_cliente = id_cliente; }

    public Integer getId_carro() { return id_carro; }
    public void setId_carro(Integer id_carro) { this.id_carro = id_carro; }

    public Double getVelorFinal() {return valorFinal; }
    public void setValorFinal(Double valorFinal) { this.valorFinal = valorFinal; }
}
