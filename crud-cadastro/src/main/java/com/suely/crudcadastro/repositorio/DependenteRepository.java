package com.suely.crudcadastro.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suely.crudcadastro.entidades.Dependente;


@Repository
public interface DependenteRepository extends JpaRepository<Dependente, Long> {

    List<Dependente> findAllByAssociado(Long id);

    Dependente findByCpfDependente(Long cpf);


}
