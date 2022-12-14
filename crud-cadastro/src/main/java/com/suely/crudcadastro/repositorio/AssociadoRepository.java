package com.suely.crudcadastro.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suely.crudcadastro.entidades.Associado;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Long>{

    

    Associado findByCpfAssociado(Long cpf);

    

}
