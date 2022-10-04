package com.suely.crudcadastro.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suely.crudcadastro.entidades.Associado;
import com.suely.crudcadastro.repositorio.AssociadoRepository;

@Service
public class AssociadoService {

    @Autowired
    AssociadoRepository repo;

    // ADICIONAR =================
    public void adicionarAssociado(Associado associado){
        repo.save(associado);
    }

    // LISTAR TODOS ====================
    public List<Associado> listarAssociados(){
        List<Associado> associados = repo.findAll();

        for(Associado a : associados){
            System.out.println(a.getNomeAssociado());
        }
        return repo.findAll();
    }

    
    // PROCURAR POR CPF ==================
    public Optional<Associado> procurarPorCpf(Long cpf){
        Optional<Associado> associado = repo.findByCpfAssociado(cpf);
        return associado;
    }

    // PROCURAR POR ID ==============
    public Optional<Associado> procurarPorId(Long id){
        Optional<Associado> associado = repo.findById(id);
        return associado;
    }
    // RETORNAR O NOME PELA ID =========
    public String retornaNome(Long id){
        Optional<Associado> associado = repo.findById(id);
        return associado.get().getNomeAssociado();

    }

    
    // EDITAR ====================
    public Optional<Associado> editarAssociado(Long id){
        Optional<Associado> associado = repo.findById(id);
        return associado;
    }

    
    
    // DELETAR ===================
    public void deletarAssociado(Long idAssociado){
        repo.deleteById(idAssociado);
    }
    
    
}
