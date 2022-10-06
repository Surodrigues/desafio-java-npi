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

import com.suely.crudcadastro.entidades.Associado;
import com.suely.crudcadastro.servico.AssociadoService;

@Controller
public class AssociadoController {

    @Autowired
    public AssociadoService Aservice;

    // index
    @RequestMapping("/")
    public String paginaInicial(Model model){
        List<Associado> associados = Aservice.listarAssociados();
        associados.sort(Comparator.comparing(Associado::getNomeAssociado));
        model.addAttribute("listaassociados", associados);
        return "index";
    }
    // *** Não dá certo. Lista dependentes retorna nula ***
    // pagina dependentes 
    /* @RequestMapping("listardependentes/{id}")
    public ModelAndView paginaDependentes(@PathVariable("id") Long id){
        ModelAndView mav = new ModelAndView("associadodependentes");
        Associado associado = Aservice.buscarPorId(id);
        List<Dependente> dependentes = Aservice.buscarDependentes(id);
        mav.addObject("associado", associado);
        mav.addObject("dependentes", dependentes);        
        return mav;
    } */

   /*  @RequestMapping("listardependentes/{id}")
    public String paginaDependentes(Model model, @PathVariable("id") Long id){
        Associado associado = Aservice.buscarPorId(id);
        List<Dependente> dependentes = associado.getDependentes();
    } */

    // página cadastro
    @RequestMapping("/novoassociado")
    public String paginaCadastroAssociado(Model model){
        Associado associado = new Associado();
        model.addAttribute("associado", associado);
        return "/cadastroassociado";
    }

    // salvar
    @PostMapping("/salvarassociado")
    public String salvarAssociado(@ModelAttribute("associado") Associado associado){
        Aservice.salvarAssociado(associado);
        return "redirect:/";
    }

    // editar
    @RequestMapping("/editarassociado/{id}")
    public ModelAndView editarAssociado(@PathVariable(name="id") Long id){
        ModelAndView mav = new ModelAndView("editarassociado");
        Associado associado = Aservice.editarAssociado(id);
        mav.addObject("associado", associado);
        return mav; 
    }

    // deletar
    @RequestMapping("deletarassociado/{id}")
    public String deletarAssociado(@PathVariable("id") Long id){
        Aservice.deletarAssociado(id);
        return "redirect:/";
    }    


}
