package com.locadora.ms_aluguel.repository;

import com.locadora.ms_aluguel.entity.StatusAluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusAluguelRepository extends JpaRepository<StatusAluguel, Long> {
    StatusAluguel findByNome(String nome);
}