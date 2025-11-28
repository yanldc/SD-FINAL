package com.locadora.ms_aluguel.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "alugueis")
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private Long clienteId;
    
    @Column(nullable = false)
    private Long veiculoId;
    
    @Column(nullable = false)
    private LocalDate dataAluguel;
    
    @Column(nullable = false)
    private LocalDate dataDevolucao;
    
    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private StatusAluguel status;
}