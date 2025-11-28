package com.locadora.ms_aluguel.repository;

import com.locadora.ms_aluguel.entity.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
    boolean existsByVeiculoIdAndDataDevolucaoAfter(Long veiculoId, LocalDate data);
    List<Aluguel> findByClienteId(Long clienteId);
}