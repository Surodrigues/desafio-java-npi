package com.suely.crudcadastro.controller;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.suely.crudcadastro.entidades.Associado;
import com.suely.crudcadastro.servico.AssociadoService;

@Controller
public class AssociadoController {

    @Autowired
    private AssociadoService servico;


    // INDEX ====================================
    @RequestMapping("/")
    public String paginaInicial(Model model){
        List<Associado> associado = servico.listarAssociados();
        associado.sort(Comparator.comparing(Associado::getNome));
        model.addAttribute("listaassociados", associado);
        return "index";
    }

    // PÁGINA CADASTRO DE ASSOCIADO =============
    @RequestMapping("/novoassociado")
    public String novoAssociado(Model model){
        Associado associado = new Associado();
        model.addAttribute("associado", associado);
        return "associadocadastro";
    }

    // SALVANDO ASSOCIADO ======================
    @PostMapping(value = "salvar")
    public String salvarAssociado(@ModelAttribute("associadoNovo") Associado associado){
        servico.adicionarAssociado(associado);
        return "redirect:/";
    }

    // LISTAR DEPENDENTES ======================

    // EDITAR ASSOCIADO ========================

    // DELETAR ASSOCIADO =======================



    
    
}
