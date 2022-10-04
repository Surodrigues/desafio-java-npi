package com.suely.crudcadastro;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.suely.crudcadastro.entidades.Associado;
import com.suely.crudcadastro.entidades.Dependente;
import com.suely.crudcadastro.servico.AssociadoService;
import com.suely.crudcadastro.servico.DependenteService;

@Controller
public class CrudcadastroController {

    @Autowired
    private AssociadoService aService;

    @Autowired
    private DependenteService dService;


    // INDEX LISTAR ASSOCIADOS =================
    @RequestMapping("/")
    public String paginaInicial(Model model){
        List<Associado> associados = aService.listarAssociados();
        associados.sort(Comparator.comparing(Associado::getNomeAssociado));
        model.addAttribute("listaassociados", associados);
        return "index";
    }


    // CADASTRO ASSOCIADOS NOVO ================
    @RequestMapping("/novoassociado")
    public String cadastroAssociado(Model model){
        Associado associado = new Associado();
        model.addAttribute("associado", associado);
        return "cadastroassociado";
    }


    // SALVAR ASSOCIADO ========================
    @PostMapping("/salvarassociado")
    public String salvarAssociado(@ModelAttribute("associado") Associado associado){
        aService.adicionarAssociado(associado);
        return "redirect:/";
    }

    // LISTAR DEPENDENTES ======================
/*     @RequestMapping("/dependentes")
    public String listaDependentes(Model model){
        List<Dependente> dependente = dService.listarDependentes();
    }
 */ 



    @RequestMapping("/dependentes/{associado}")
    public String dependentes(Model model, @PathVariable(name = "associado") Long associado){
        List<Dependente> dependente = dService.listarDependentes(associado);

        //aService.retornaNome(associado);
        dependente.sort(Comparator.comparing(Dependente::getNomeDependente));
        
        for(Dependente d : dependente){
            System.out.println(d.getNomeDependente());
        }

        model.addAttribute("listadependentes", dependente);
        return "listadependentes";
    }


    // EDITAR ASSOCIADO ========================
    @RequestMapping("/editarassociado/{id}")
    public ModelAndView editarAssociado(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("editarassociado");
        Optional<Associado> associado = aService.editarAssociado(id);
        mav.addObject("associado", associado);
        return mav;
    }

    // DELETAR ASSOCIADO =======================
    @RequestMapping("/deletarassociado/{id}")
    public String deletarAssociado(@PathVariable("id") Long id){
        aService.deletarAssociado(id);
        return "redirect:/";
    }
    
    //==========================================
    //******************************************
    //==========================================


    // CADASTRO DEPENDENTE NOVO ================
    @RequestMapping("/novodependente/{id}")
    public String cadastrodepende(Model model, @PathVariable("id") Long id){
        Dependente dependente = new Dependente();
        dependente.setAssociado(id);
        model.addAttribute("dependente", dependente);
        return "cadastrodependente";
    }

    // SALVAR DEPENDENTE ========================
    @PostMapping("/salvardependente")
    public String salvarDependente(@ModelAttribute("dependente") Dependente dependente, @PathVariable(name = "id") Long id){
        dependente.setAssociado(id);
        dService.adicionarDependente(dependente);
       
        return "redirect:/";
    }

    // EDITAR DEPENDENTE ========================
    @RequestMapping("/editardependente/{id}")
    public ModelAndView editarDependente(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("editardependente");
        Dependente dependente = dService.editarDependente(id);
        mav.addObject("dependente", dependente);
        return mav;
    }

    // DELETAR DEPENDENTE =======================
    @RequestMapping("/deletardependente/{id}")
    public String deletarDependente(@PathVariable("id") Long id){
        dService.deletarDependente(id);
        return "redirect:/dependentes";
    }
    
}
