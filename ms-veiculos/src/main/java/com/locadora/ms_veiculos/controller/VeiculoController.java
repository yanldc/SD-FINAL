package com.locadora.ms_veiculos.controller;

import com.locadora.ms_veiculos.entity.Veiculo;
import com.locadora.ms_veiculos.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    
    @Autowired
    private VeiculoRepository veiculoRepository;
    
    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Veiculo veiculo) {
        if (veiculoRepository.existsByPlaca(veiculo.getPlaca())) {
            return ResponseEntity.badRequest().body("Carro ja cadastrado");
        }
        return ResponseEntity.ok(veiculoRepository.save(veiculo));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscar(@PathVariable Long id) {
        return veiculoRepository.findById(id)
            .map(veiculo -> ResponseEntity.ok().body(veiculo))
            .orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        if (!veiculoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        veiculo.setId(id);
        return ResponseEntity.ok(veiculoRepository.save(veiculo));
    }
    
    @GetMapping
    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }
}