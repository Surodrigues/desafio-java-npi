package com.suely.crudcadastro.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.suely.crudcadastro.entidades.Associado;
import com.suely.crudcadastro.entidades.Dependente;
import com.suely.crudcadastro.servico.AssociadoService;

@Controller
public class AssociadoController {

    @Autowired
    public AssociadoService Aservice;


    
    @RequestMapping("/")
    public String associados(Model model){
        List<Associado> associado = Aservice.listarAssociados();
        model.addAttribute("associados", associado);
        return "index";
    }
    
    // página associado
    @RequestMapping(value="associado/{id}", method = RequestMethod.GET)
    public ModelAndView buscarAssociado(@PathVariable("id") Long id){
        Associado associado = Aservice.buscarPorId(id);
        ModelAndView mav = new ModelAndView("associado");
        mav.addObject("associado", associado);
        List<Dependente> dependentes = associado.getDependentes();
        mav.addObject("dependentes", dependentes);
        return mav;
    }

    
    @GetMapping("cpf/{cpf}")
    public ModelAndView buscaAssociadoCpf(@PathVariable("cpf") Long cpf){
        Associado associado = Aservice.buscarPorCpf(cpf);
        ModelAndView mav = new ModelAndView("associado");
        mav.addObject("associado", associado);
        List<Dependente> dependentes = associado.getDependentes();
        mav.addObject("dependentes", dependentes);
        return mav;
    }


    // página cadastro associado
    @GetMapping("/novoassociado")
    public String paginaCadastroAssociado(Model model){
        Associado associado = new Associado();
        model.addAttribute("associado", associado);
        return "/cadastroassociado";
    }

    // salvar
    @RequestMapping(value = "/salvarassociado", method = RequestMethod.POST)
    public String salvarAssociado(Model model, Associado associado){
        Aservice.salvarAssociado(associado);
        return "redirect:/";
    }

    // editar
    @RequestMapping("editarassociado/{id}")
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
