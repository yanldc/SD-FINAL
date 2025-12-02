package com.locadora.ms_veiculos.dto;

public class VeiculoDto {
    private Long id;
    private String nome;
    private String cor;
    private String marca;
    private String placa;
    private Integer ano;
    private Boolean disponivel;

    public VeiculoDto() {}

    public VeiculoDto(Long id, String nome, String cor, String marca, String placa, Integer ano, Boolean disponivel) {
        this.id = id;
        this.nome = nome;
        this.cor = cor;
        this.marca = marca;
        this.placa = placa;
        this.ano = ano;
        this.disponivel = disponivel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }
}