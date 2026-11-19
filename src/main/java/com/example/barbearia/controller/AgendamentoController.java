package com.example.barbearia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.barbearia.model.Agendamento;
import com.example.barbearia.service.AgendamentoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private final AgendamentoService service;

    public AgendamentoController(AgendamentoService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(@RequestParam(required = false) String busca, Model model) {
        if (busca != null && !busca.isBlank()) {
            model.addAttribute("agendamentos", service.buscarPorNome(busca));
        } else {
            model.addAttribute("agendamentos", service.listar());
        }
        return "agendamentos/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("agendamento", new Agendamento());
        return "agendamentos/form";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("agendamento") Agendamento agendamento,
                         BindingResult result) {
        if (result.hasErrors()) {
            return "agendamentos/form";
        }
        service.salvar(agendamento);
        return "redirect:/agendamentos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("agendamento", service.buscarPorId(id));
        return "agendamentos/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/agendamentos";
    }
}