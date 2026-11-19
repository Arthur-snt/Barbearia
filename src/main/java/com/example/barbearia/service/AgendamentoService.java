package com.example.barbearia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.barbearia.model.Agendamento;
import com.example.barbearia.repository.AgendamentoRepository;

@Service
public class AgendamentoService {

    private final AgendamentoRepository repository;

    public AgendamentoService(AgendamentoRepository repository) {
        this.repository = repository;
    }

    public List<Agendamento> listar() {
        return repository.findAll();
    }

    public List<Agendamento> buscarPorNome(String nome) {
        return repository.findByNomeClienteContainingIgnoreCase(nome);
    }

    public Agendamento buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado: " + id));
    }

    public void salvar(Agendamento agendamento) {
        repository.save(agendamento);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}