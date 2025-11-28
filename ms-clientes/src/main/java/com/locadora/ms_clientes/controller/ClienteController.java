package com.locadora.ms_clientes.controller;

import com.locadora.ms_clientes.entity.Cliente;
import com.locadora.ms_clientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Cliente cliente) {
        if (clienteRepository.existsByCnh(cliente.getCnh())) {
            return ResponseEntity.badRequest().body("Usuario ja cadastrado");
        }
        return ResponseEntity.ok(clienteRepository.save(cliente));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
        return clienteRepository.findById(id)
            .map(cliente -> ResponseEntity.ok().body(cliente))
            .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }
}