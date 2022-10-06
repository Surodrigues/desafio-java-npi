package com.suely.crudcadastro.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Dependente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dependente")
    private Long idDependente;
    @Column(name = "cpf_dependente", unique = true)
    private Long cpfDependente;
    @Column(name = "nome_dependente", length = 50, nullable = false)
    private String nomeDependente;    
    @Column(nullable = false)
    private int idade;

    @ManyToOne(targetEntity = Associado.class)
    @JoinColumn(name ="dependente_id_associado")
    private Long associado;






    public Dependente(){}    

    public Dependente(Long cpfDependente, String nomeDependente, int idade, Long associado) {
        this.cpfDependente = cpfDependente;
        this.nomeDependente = nomeDependente;
        this.idade = idade;
        this.associado = associado;
    }


    


    

    public Long getIdDependente() {
        return idDependente;
    }

    public void setIdDependente(Long idDependente) {
        this.idDependente = idDependente;
    }

    public Long getCpfDependente() {
        return cpfDependente;
    }

    public void setCpfDependente(Long cpfDependente) {
        this.cpfDependente = cpfDependente;
    }

    public String getNomeDependente() {
        return nomeDependente;
    }

    public void setNomeDependente(String nomeDependente) {
        this.nomeDependente = nomeDependente;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }    
    public Long getAssociado() {
        return associado;
    }
    
    public void setAssociado(Long associado) {
        this.associado = associado;
    }

    


    



    


    

    
}
