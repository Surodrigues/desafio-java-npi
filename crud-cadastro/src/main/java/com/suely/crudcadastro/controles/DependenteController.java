package com.suely.crudcadastro.controles;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.suely.crudcadastro.entidades.Dependente;
import com.suely.crudcadastro.servico.AssociadoService;
import com.suely.crudcadastro.servico.DependenteService;

@Controller
public class DependenteController {

    @Autowired
    public DependenteService dService;
    @Autowired
    public AssociadoService aService;



    // *** Não funciona pois não está associando o dependente ao associado ***
    // pagina cadastro
    @RequestMapping("/listardependentes/{id}")
    public String paginaDependentes(Model model, @PathVariable("id") Long id){
        
        List<Dependente> dependente = dService.buscarDependentes(id);
        dependente.sort(Comparator.comparing(Dependente::getNomeDependente));
        model.addAttribute("listardependentes", dependente);
        return "/dependentes";        
    }

    @RequestMapping("/novodependente/{id}")
    public String paginaCadastroDependente(Model model, @PathVariable("id") Long id){
        //Associado associado = aService.buscarPorId(id);
        Dependente dependente = dService.setarAssociado(id);
        model.addAttribute("dependente", dependente);
        return "cadastrodependente";
    }

    // salvar
    @PostMapping("/salvardependente")
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
   

}
