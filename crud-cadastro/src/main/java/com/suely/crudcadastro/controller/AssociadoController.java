package com.suely.crudcadastro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suely.crudcadastro.entidades.Associado;
import com.suely.crudcadastro.servico.AssociadoService;

@RestController
public class AssociadoController {

    @Autowired
    private AssociadoService servico;

    @RequestMapping(value = "/")
    public String paginaInicial(Model model){
        return "index";
    }

    @RequestMapping("/associado-cadastro")
    public String paginaCadastro(Model model){
        Associado associado = new Associado();
        model.addAttribute("associadoNovo", associado);
        return "associado-cadastro";
    }

    @PostMapping(value = "salvar")
    public String salvarAssociado(@ModelAttribute("associadoNovo") Associado associado){
        servico.adicionarAssociado(associado);
        return "redirect:/";
    }

    
    
}
