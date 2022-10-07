package com.suely.crudcadastro.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.suely.crudcadastro.entidades.Associado;
import com.suely.crudcadastro.entidades.Dependente;
import com.suely.crudcadastro.servico.AssociadoService;
import com.suely.crudcadastro.servico.DependenteService;


@Controller
public class DependenteController {


    @Autowired
    public AssociadoService aService;
    @Autowired
    public DependenteService dService;
    



    // página cadastro dependente
    @RequestMapping(value = "/novodependente/{id}", method = RequestMethod.POST)
    public ModelAndView cadastrarDependente(@PathVariable("id") Long id, Dependente dependente){
        Associado associado = aService.buscarPorId(id);
        dependente.setAssociado(associado);
        dService.salvarDependente(dependente);
        return "redirect:/{id}";
    }



    /* public String cadastrarDependente(Model model, @PathVariable("id") Long id, Associado associado){
        associado = aService.buscarPorId(id);
        Dependente dependente = new Dependente();        
        dependente.setAssociado(associado);
        model.addAttribute("dependente", dependente);
        return "redirect:/associado/{id}";
    } */

    // salvar
    @PostMapping("/salvardependente")
    public String salvarDependente(@ModelAttribute("dependente") Dependente dependente){
        dService.salvarDependente(dependente);
        return "redirect:/";
    }

    // editar
    @GetMapping("/editardependente/{id}")
    public ModelAndView editarDependente(@PathVariable("id") Long id){
        ModelAndView mav = new ModelAndView("editarassociado");
        Dependente dependente = dService.buscarPorId(id);
        mav.addObject("dependente", dependente);
        return mav;
    }
   

}
