package com.locadora.ms_aluguel.service;

import com.locadora.ms_aluguel.dto.ClienteDto;
import com.locadora.ms_aluguel.dto.VeiculoDto;
import com.locadora.ms_aluguel.entity.Aluguel;
import com.locadora.ms_aluguel.repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Aluguel criarAluguel(Aluguel aluguel) {
        try {
            String clienteUrl = "http://ms-clientes/clientes/" + aluguel.getClienteId();
            ClienteDto cliente = restTemplate.getForObject(clienteUrl, ClienteDto.class);

            if (cliente == null || cliente.getIdade() < 18) {
                throw new RuntimeException("Cliente deve ter 18 anos ou mais");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao verificar cliente: " + e.getMessage());
        }

        try {
            String veiculoUrl = "http://ms-veiculos/veiculos/" + aluguel.getVeiculoId();
            VeiculoDto veiculo = restTemplate.getForObject(veiculoUrl, VeiculoDto.class);

            if (veiculo == null || !veiculo.getDisponivel()) {
                throw new RuntimeException("Veiculo nao disponivel");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao verificar veiculo: " + e.getMessage());
        }

        return aluguelRepository.save(aluguel);
    }
}