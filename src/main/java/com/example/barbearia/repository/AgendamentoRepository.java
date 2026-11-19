package com.example.barbearia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.barbearia.model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    List<Agendamento> findByNomeClienteContainingIgnoreCase(String nomeCliente);
}