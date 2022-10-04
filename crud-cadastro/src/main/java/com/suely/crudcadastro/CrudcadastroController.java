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



    // EDITAR ASSOCIADO ========================
    @RequestMapping("/editarassociado/{id}")
    public ModelAndView editarAssociado(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("editarassociado");
        Optional<Associado> associado = aService.editarAssociado(id);
        mav.addObject("associado", associado);
        return mav;
    }

    // EDITAR ASSOCIADO SALVANDO DEPENDENTE =================
    @RequestMapping("editarassociadosalvandodependente/{id}")
    public ModelAndView editarAssocSalvDep(@PathVariable("id") Long id){
        ModelAndView mav = new ModelAndView("edicaoassociadoadicionandodependente");
        Optional<Associado> associado = aService.editarAssociado(id);
        
        mav.
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
    



    // SALVAR DEPENDENTE ========================
    


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
