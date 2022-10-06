package com.suely.crudcadastro.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suely.crudcadastro.entidades.Dependente;
import com.suely.crudcadastro.repositorio.DependenteRepository;

@Service
public class DependenteService {

    @Autowired
    DependenteRepository Drepo;

    
    // listar todos por id do associado
    public List<Dependente> buscarDependentes(Long id){
        List<Dependente> dependentes = Drepo.findAllByAssociado(id);
        return dependentes;
    }
        // buscar por cpf
    public Dependente buscarDependente(Long cpf){
        return Drepo.findByCpfDependente(cpf);
    }
        // buscar por id
    public Dependente buscarPorId(Long id){
        return Drepo.findByCpfDependente(id);
    }

    // salvar
    public void salvarDependente(Dependente dependente){
        Drepo.save(dependente);
    }

    // editar
    public Dependente editarDependente(Long id){
        return Drepo.findById(id).get();
    }

    // deletar
    public void deletarDependente(Long id){
        Drepo.deleteById(id);
    }



    public Dependente setarAssociado(Long id){
        Dependente dependente = new Dependente();
        dependente.setAssociado(id);
        return dependente;
    }
    
}
