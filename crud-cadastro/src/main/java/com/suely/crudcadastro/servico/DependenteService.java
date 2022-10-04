package com.suely.crudcadastro.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suely.crudcadastro.entidades.Associado;
import com.suely.crudcadastro.entidades.Dependente;
import com.suely.crudcadastro.repositorio.AssociadoRepository;
import com.suely.crudcadastro.repositorio.DependenteRepository;

@Service
public class DependenteService {

    @Autowired
    DependenteRepository repo;   

    @Autowired
    AssociadoRepository arepo;

    

    // ADICIONAR
    public void adicionarDependente(Dependente dependente){
        repo.save(dependente);
        /* dependente.setAssociado(null);
        repo.save(dependente); */
    }    

    // LISTAR DEPENDENTES DO ASSOCIADO PELA ID DO ASSOCIADO==========
    public List<Dependente> listarDependentes(Long associado){
        Associado a = arepo.findById(associado).get();      
        List<Dependente> dependentes = a.getDependentes();
        return dependentes;
    }

    // PROCURAR POR ID
    public Optional<Dependente> preocurarPorId(Long id){
        Optional<Dependente> dependente = repo.findById(id);
        return dependente;
    }    

    // PROCURAR POR CPF
    public Optional<Dependente> procurarDependente(Long cpf){
        Optional<Dependente> dependente = repo.findByCpfDependente(cpf);
        return dependente;
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
