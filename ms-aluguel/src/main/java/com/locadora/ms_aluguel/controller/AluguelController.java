package com.locadora.ms_aluguel.controller;

import com.locadora.ms_aluguel.entity.Aluguel;
import com.locadora.ms_aluguel.repository.AluguelRepository;
import com.locadora.ms_aluguel.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {
    
    @Autowired
    private AluguelRepository aluguelRepository;
    
    @Autowired
    private AluguelService aluguelService;
    
    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Aluguel aluguel) {
        try {
            return ResponseEntity.ok(aluguelService.criarAluguel(aluguel));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Aluguel> buscar(@PathVariable Long id) {
        return aluguelRepository.findById(id)
            .map(aluguel -> ResponseEntity.ok().body(aluguel))
            .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/cliente/{clienteId}")
    public List<Aluguel> buscarPorCliente(@PathVariable Long clienteId) {
        return aluguelRepository.findByClienteId(clienteId);
    }
    
    @GetMapping
    public List<Aluguel> listarTodos() {
        return aluguelRepository.findAll();
    }
}