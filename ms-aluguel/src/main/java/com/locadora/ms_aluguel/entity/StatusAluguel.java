package com.locadora.ms_aluguel.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "status_aluguel")
public class StatusAluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column
    private String descricao;
}