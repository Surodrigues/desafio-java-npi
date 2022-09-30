package com.suely.crudcadastro.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Dependente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDependente;
    @Column(unique = true)
    private Long cpfDependente;
    @Column(length = 50, nullable = false)
    private String nomeDependente;
    @ManyToOne(optional = false)
    private Associado associado;
    @Column(nullable = false)
    private int idade;

    

    // CONTRUTOR =========================================
    public Dependente(){};

    public Dependente(Long cpfDependente, String nomeDependente, Associado associado, int idade) {
        this.cpfDependente = cpfDependente;
        this.nomeDependente = nomeDependente;
        this.associado = associado;
        this.idade = idade;
    }


    // GETTERS E SETTERS =================================
    public long getIdDependente() {
        return idDependente;
    }

    public long getCpfDependente() {
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

    public Associado getAssociado() {
        return associado;
    }
    public void setAssociado(Associado associado) {
        this.associado = associado;
    }

    public int getIdade(){
        return idade;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }

    
    // TOSTRING ==========================================
    @Override
    public String toString() {
        return "Dependente [associado=" + associado + ", cpfDependente=" + cpfDependente + ", idDependente="
                + idDependente + ", nomeDependente=" + nomeDependente + ", idade=" + idade + "]";
    }
}
