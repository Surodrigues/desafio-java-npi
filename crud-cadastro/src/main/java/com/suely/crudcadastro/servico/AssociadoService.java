package com.suely.crudcadastro.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suely.crudcadastro.entidades.Associado;
import com.suely.crudcadastro.repositorio.AssociadoRepository;

@Service
public class AssociadoService {

    @Autowired
    AssociadoRepository Arepo;


    // listar
    public List<Associado> listarAssociados(){
        return Arepo.findAll();
    }
        //buscar por CPF
    public Associado buscarPorCpf(Long cpf){
        return Arepo.findByCpfAssociado(cpf);        
    }
        //buscar por ID
    public Associado buscarPorId(Long id){
        return Arepo.findById(id).get();
    }
    
    // salvar
    public void salvarAssociado(Associado associado){
        Arepo.save(associado);
    }

    // editar
    public Associado editarAssociado(Long id){
        return Arepo.findById(id).get();
    }

    // deletar
    public void deletarAssociado(Long id){
        Arepo.deleteById(id);
    }    
    
    
}
