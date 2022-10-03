package com.suely.crudcadastro.servico;

import java.util.List;

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
    public Associado procurarAssociado(Long cpf_associado){
        Associado a = repo.findByCpfAssociado(cpf_associado);
        return a;
    }

    // PROCURAR POR ID ==============
    public Associado procurarAssociadoPorId(Long id){
        Associado a = repo.findByIdAssociado(id);
        return a;
    }
    
    // EDITAR ====================
    public Associado editarAssociado(Long id_associado){
        Associado a = repo.findByIdAssociado(id_associado);
        return a;
    }

    
    
    // DELETAR ===================
    public void deletarAssociado(Long idAssociado){
        repo.deleteById(idAssociado);
    }
    
    
}
