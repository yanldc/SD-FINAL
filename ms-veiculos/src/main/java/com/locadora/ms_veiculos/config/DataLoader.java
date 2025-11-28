package com.locadora.ms_veiculos.config;

import com.locadora.ms_veiculos.entity.Veiculo;
import com.locadora.ms_veiculos.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    
    @Autowired
    private VeiculoRepository veiculoRepository;
    
    @Override
    public void run(String... args) throws Exception {
        if (veiculoRepository.count() == 0) {
            Veiculo veiculo1 = new Veiculo();
            veiculo1.setNome("Civic");
            veiculo1.setCor("Preto");
            veiculo1.setMarca("Honda");
            veiculo1.setAno(2022);
            veiculo1.setPlaca("ABC-1234");
            veiculo1.setDisponivel(true);
            veiculoRepository.save(veiculo1);
            
            Veiculo veiculo2 = new Veiculo();
            veiculo2.setNome("Corolla");
            veiculo2.setCor("Branco");
            veiculo2.setMarca("Toyota");
            veiculo2.setAno(2023);
            veiculo2.setPlaca("XYZ-5678");
            veiculo2.setDisponivel(true);
            veiculoRepository.save(veiculo2);
        }
    }
}