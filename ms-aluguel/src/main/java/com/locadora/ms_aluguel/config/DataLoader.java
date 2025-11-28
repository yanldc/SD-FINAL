package com.locadora.ms_aluguel.config;

import com.locadora.ms_aluguel.entity.Aluguel;
import com.locadora.ms_aluguel.entity.StatusAluguel;
import com.locadora.ms_aluguel.repository.AluguelRepository;
import com.locadora.ms_aluguel.repository.StatusAluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private StatusAluguelRepository statusRepository;

    @Override
    public void run(String... args) throws Exception {
        if (statusRepository.count() == 0) {
            StatusAluguel ativo = new StatusAluguel();
            ativo.setNome("ATIVO");
            ativo.setDescricao("Aluguel em andamento");
            statusRepository.save(ativo);

            StatusAluguel finalizado = new StatusAluguel();
            finalizado.setNome("FINALIZADO");
            finalizado.setDescricao("Aluguel concluído");
            statusRepository.save(finalizado);
        }

        if (aluguelRepository.count() == 0) {
            StatusAluguel statusAtivo = statusRepository.findByNome("ATIVO");

            Aluguel aluguel1 = new Aluguel();
            aluguel1.setClienteId(1L);
            aluguel1.setVeiculoId(1L);
            aluguel1.setDataAluguel(LocalDate.of(2024, 1, 15));
            aluguel1.setDataDevolucao(LocalDate.of(2024, 1, 20));
            aluguel1.setStatus(statusAtivo);
            aluguelRepository.save(aluguel1);

            Aluguel aluguel2 = new Aluguel();
            aluguel2.setClienteId(2L);
            aluguel2.setVeiculoId(2L);
            aluguel2.setDataAluguel(LocalDate.of(2024, 1, 18));
            aluguel2.setDataDevolucao(LocalDate.of(2024, 1, 25));
            aluguel2.setStatus(statusAtivo);
            aluguelRepository.save(aluguel2);
        }
    }
}