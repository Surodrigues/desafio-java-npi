package com.suely.crudcadastro;

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

import com.suely.crudcadastro.entidades.Associado;
import com.suely.crudcadastro.entidades.Dependente;
import com.suely.crudcadastro.servico.AssociadoService;
import com.suely.crudcadastro.servico.DependenteService;

@Controller
public class CrudcadastroController {

    @Autowired
    private AssociadoService associadoServico;

    @Autowired
    private DependenteService dependenteServico;


    // INDEX LISTAR ASSOCIADOS =================
    @RequestMapping("/")
    public String paginaInicial(Model model){
        List<Associado> associado = associadoServico.listarAssociados();
        associado.sort(Comparator.comparing(Associado::getNomeAssociado));

        for(Associado a : associado){
            System.out.println(a.getNomeAssociado());
        }

        model.addAttribute("listaassociados", associado);
        return "index";
    }

    // CADASTRO ASSOCIADOS NOVO ================
    @RequestMapping("/novoassociado")
    public String novoAssociado(Model model){
        Associado associado = new Associado();
        model.addAttribute("associado", associado);
        return "associadocadastro";
    }

    // SALVAR ASSOCIADO ========================
    @PostMapping("/salvarassociado")
    public String salvarAssociado(@ModelAttribute("associado") Associado associado){
        associadoServico.adicionarAssociado(associado);
        return "redirect:/";
    }

    // EDITAR ASSOCIADO ========================
    @RequestMapping("/editarassociado/{idAssociado}")
    public ModelAndView paginaEditarAssociado(@PathVariable(name = "idAssociado") Long id){
        ModelAndView mav = new ModelAndView("editarassociado");
        Associado associado = associadoServico.editarAssociado(id);
        mav.addObject("associado", associado);
        return mav;
    }

    // DELETAR ASSOCIADO =======================
    @RequestMapping("deletarassociado/{idAssociado}")
    public String deletarAssociado(@PathVariable(name = "idAssociado") Long id){
        associadoServico.deletarAssociado(id);
        return "redirect:/";
    }
    
    //==========================================
    //******************************************
    //==========================================


    // LISTAR DEPENDENTES DO ASSOCIADO =========
/*     @RequestMapping("/listardependentesdoassociado")
    public String listaDependentes(Model model){
        Associado a = associadoServico.procurarAssociadoPorId(null)
        List<Dependente> dependente = dependenteServico.listarDependentes(null) ;
        dependente.sort(Comparator.comparing(Dependente::getNomeDependente));
        model.addAttribute("dependente", dependente);
        return "listardependentesdoassociado";
    } */

    @RequestMapping("/listardependentes/{idAssociado}")
    public ModelAndView paginaDependentes(@PathVariable(name = "idAssociado") Long id) {
        ModelAndView mav = new ModelAndView("listardependentes");
        List<Dependente> dependente = dependenteServico.listarDependentes(id);
        mav.addObject("dependente", dependente);
        return mav;



        /* @RequestMapping("/editarassociado/{idAssociado}")
        public ModelAndView paginaEditarAssociado(@PathVariable(name = "idAssociado") Long id){
            ModelAndView mav = new ModelAndView("editarassociado");
            Associado associado = associadoServico.editarAssociado(id);
            mav.addObject("associado", associado);
            return mav;
        } */

    }

    // CADASTRAR DEPENDENTE NOVO ===============
    @RequestMapping("/novodependente")
    public String novoDependente(Model model){
        Dependente dependente = new Dependente();
        model.addAttribute("dependente", dependente);
        return "dependentecadastro";
    }

    // SALVAR DEPENDENTE =======================
    @RequestMapping("/salvardependente")
    public String salvarDependente(@ModelAttribute("dependente") Dependente dependente){
        dependenteServico.adicionarDependente(dependente);
        return "listardependentes";
    }

    // EDITAR DEPENDENTE =======================
    @RequestMapping("/editardependente/{idDependente}")
    public ModelAndView paginaEditarDependente(@PathVariable(name = "idDependente") Long id){
        ModelAndView mav = new ModelAndView("editarassociado");
        Dependente dependente = dependenteServico.editarDependente(id);
        mav.addObject("dependente", dependente);
        return mav;
    }

    // DELETAR DEPENDENTE ======================
    @RequestMapping("/deletardependente/{idDependente}")
    public String deletarDependente(@PathVariable(name = "idDependente") Long id){
        dependenteServico.deletarDependente(id);
        return "redirect:/listardependentes";
    }
    
}
