package com.suely.crudcadastro.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suely.crudcadastro.entidades.Associado;
import com.suely.crudcadastro.entidades.Dependente;
import com.suely.crudcadastro.repositorio.DependenteRepository;

@Service
public class DependenteService {

    @Autowired
    DependenteRepository Drepo;

    
    // buscar por associado
    public List<Dependente> buscarDependentes(Associado associado){
        List<Dependente> dependentes = Drepo.findByAssociado(associado);
        return dependentes;
    }
        // buscar por cpf
    public Dependente buscarDepCpf(Long cpf){
        return Drepo.findByCpfDependente(cpf);
    }
        // buscar por id
    public Dependente buscarPorId(Long id){
        return Drepo.findById(id).get();
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

    
}
