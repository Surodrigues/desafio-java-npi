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
            System.out.println(a.getNome());
        }
        return repo.findAll();
    }

    // PROCURAR POR CPF ==================
    public Associado procurarAssociado(Long cpfAssociado){
        return repo.findByCpf(cpfAssociado);
    }
    
    // EDITAR ====================
    public Associado editarAssociado(Long idAssociado){
        return repo.findById(idAssociado).get();
    }
    
    // DELETAR ===================
    public void deletarAssociado(Long idAssociado){
        repo.deleteById(idAssociado);
    }
    
    
}
