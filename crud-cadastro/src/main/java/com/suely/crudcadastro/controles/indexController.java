/* package com.suely.crudcadastro.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.suely.crudcadastro.entidades.Associado;
import com.suely.crudcadastro.servico.AssociadoService;

@Controller
public class indexController {

    @Autowired
    public AssociadoService Aservice;

    @RequestMapping("/associados")
    public String associados(Model model){
        List<Associado> associado = Aservice.listarAssociados();
        model.addAttribute("associados", associado);
        return "index";
    }
    

} */
