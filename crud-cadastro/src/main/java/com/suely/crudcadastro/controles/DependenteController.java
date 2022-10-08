package com.suely.crudcadastro.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.suely.crudcadastro.entidades.Associado;
import com.suely.crudcadastro.entidades.Dependente;
import com.suely.crudcadastro.servico.AssociadoService;
import com.suely.crudcadastro.servico.DependenteService;


@Controller
@RequestMapping("/dependente")
public class DependenteController {


    @Autowired
    public AssociadoService aService;
    @Autowired
    public DependenteService dService;


   
    
    // página cadastro dependente 
    @RequestMapping(value = "/novodependente/{id}")
    public ModelAndView cadastrarDependente(@PathVariable("id") Long idAssociado){
        Associado associado = aService.buscarPorId(idAssociado);
        Dependente dependente = new Dependente();
        dependente.setAssociado(associado);
        ModelAndView mav = new ModelAndView("cadastrodependente");
        mav.addObject("dependente", dependente);       
        return mav;
    }

    // salvar
    @RequestMapping("/salvardependente")
    public String salvarDependente(@ModelAttribute("dependente") Dependente dependente){
        dService.salvarDependente(dependente);
        return "redirect:/";
    }

    // editar
    @RequestMapping("/editardependente/{id}")
    public ModelAndView editarDependente(@PathVariable("id") Long id){
        ModelAndView mav = new ModelAndView("editarassociado");
        Dependente dependente = dService.buscarPorId(id);
        mav.addObject("dependente", dependente);
        return mav;
    }

    @RequestMapping("/deletardependente/{id}")
    public String deletarDependente(@PathVariable("id") Long id){
        dService.deletarDependente(id);
        return "/";
    }
   

}
