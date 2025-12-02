package com.locadora.ms_clientes.dto;

public class ClienteDto {
    private Long id;
    private String nome;
    private Integer idade;
    private String cnh;

    public ClienteDto() {}

    public ClienteDto(Long id, String nome, Integer idade, String cnh) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cnh = cnh;
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

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }
}