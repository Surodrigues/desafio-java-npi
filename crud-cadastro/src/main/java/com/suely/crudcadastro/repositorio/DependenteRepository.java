package com.suely.crudcadastro.repositorio;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suely.crudcadastro.entidades.Dependente;


@Repository
public interface DependenteRepository extends JpaRepository<Dependente, Long> {

    Optional<Dependente> findByCpfDependente(Long cpf);

    Collection<Dependente> findByAssociado(Long associado);
}
