package com.example.barbearia.model;
    
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCliente;
    private String servico;
    private LocalDate data;
    private Double preco;

    public Agendamento() {}

    public Long getId(){ 
        return id; }
    public void setId(Long id) { 
        this.id = id; }

    public String getNomeCliente() { 
        return nomeCliente; }
    public void setNomeCliente(String nomeCliente) { 
        this.nomeCliente = nomeCliente; }

    public String getServico() { 
        return servico; }
    public void setServico(String servico) { 
        this.servico = servico; }

    public LocalDate getData() { 
        return data; }
    public void setData(LocalDate data) { 
        this.data = data; }

    public Double getPreco() { 
        return preco; }
    public void setPreco(Double preco) { 
        this.preco = preco; }
}