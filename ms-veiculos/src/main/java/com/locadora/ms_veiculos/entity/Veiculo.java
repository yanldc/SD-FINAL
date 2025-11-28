package com.locadora.ms_veiculos.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "veiculos")
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String cor;
    
    @Column(nullable = false)
    private String marca;
    
    @Column(nullable = false)
    private Integer ano;
    
    @Column(nullable = false, unique = true)
    private String placa;
    
    @Column(nullable = false)
    private Boolean disponivel = true;
}