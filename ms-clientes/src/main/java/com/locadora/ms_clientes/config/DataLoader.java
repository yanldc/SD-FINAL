package com.locadora.ms_clientes.config;

import com.locadora.ms_clientes.entity.Cliente;
import com.locadora.ms_clientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Override
    public void run(String... args) throws Exception {
        if (clienteRepository.count() == 0) {
            Cliente cliente1 = new Cliente();
            cliente1.setNome("João Silva");
            cliente1.setIdade(25);
            cliente1.setCnh("CNH123456789");
            clienteRepository.save(cliente1);
            
            Cliente cliente2 = new Cliente();
            cliente2.setNome("Maria Santos");
            cliente2.setIdade(30);
            cliente2.setCnh("CNH987654321");
            clienteRepository.save(cliente2);
        }
    }
}