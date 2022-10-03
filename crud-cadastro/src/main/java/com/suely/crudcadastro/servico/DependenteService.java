package com.suely.crudcadastro.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suely.crudcadastro.entidades.Dependente;
import com.suely.crudcadastro.repositorio.DependenteRepository;

@Service
public class DependenteService {

    @Autowired
    DependenteRepository repo;   

    

    // ADICIONAR
    public void adicionarDependente(Dependente dependente){
        repo.save(dependente);
    }    

    // LISTAR DEPENDENTES DO ASSOCIADO PELA ID DO ASSOCIADO==========
    public List<Dependente> listarDependentes(Long idAssociado){
        return repo.findByAssociadoIdAssociado(idAssociado);

    }

    

    // PROCURAR POR CPF
    public Dependente procurarDependente(Long cpfDependente){
        return repo.findByCpfDependente(cpfDependente);
    }   

    // EDITAR
    public Dependente editarDependente(Long idDependente){
        return repo.findById(idDependente).get();
    }    

    // DELETAR
    public void deletarDependente(Long idDependente){
        repo.deleteById(idDependente);
    }
    
}
