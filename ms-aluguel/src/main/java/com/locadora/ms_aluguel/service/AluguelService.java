package com.locadora.ms_aluguel.service;

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

    public static class ClienteDto {
        private Long id;
        private String nome;
        private Integer idade;
        private String cnh;

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

    public static class VeiculoDto {
        private Long id;
        private String nome;
        private String cor;
        private String marca;
        private Integer ano;
        private Boolean disponivel;

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

        public String getCor() {
            return cor;
        }

        public void setCor(String cor) {
            this.cor = cor;
        }

        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public Integer getAno() {
            return ano;
        }

        public void setAno(Integer ano) {
            this.ano = ano;
        }

        public Boolean getDisponivel() {
            return disponivel;
        }

        public void setDisponivel(Boolean disponivel) {
            this.disponivel = disponivel;
        }
    }
}