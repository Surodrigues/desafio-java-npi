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

    @ManyToOne
    private Associado associado;


    //private Long idAssociado;



    // CONTRUTOR =========================================
    public Dependente(){};

    public Dependente(Long cpfDependente, String nomeDependente, int idade, Associado associado) {
        this.cpfDependente = cpfDependente;
        this.nomeDependente = nomeDependente;
        this.idade = idade;
        this.associado = associado;
        //this.idAssociado = idAssociado;
    }

    // GETTERS E SETTERS =================================
    @JoinColumn(name = "id_associado")
    public Associado getAssociado() {
        return associado;
    }
    public void setAssociado(Associado associado) {
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

    /* public Long getIdAssociado() {
        return idAssociado;
    }

    public void setAssociado(Long associado) {
        this.idAssociado = associado;
    } */

    
    // TOSTRING ==========================================
    @Override
    public String toString() {
        return "Dependente [idDependente=" + idDependente + ", cpfDependente=" + cpfDependente + ", nomeDependente="
                + nomeDependente + ", idade=" + idade + ", associado=" + associado.getIdAssociado() + "]";
    }












    // CONTRUTOR =========================================
 /*    public Dependente(){}


    public Dependente(Long cpf, String nome, int idade) {
        this.cpfDependente = cpf;
        this.nomeDependente = nome;
        this.idade = idade;
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


    public Associado getAssociado() {
        return associado;
    }
    public void setAssociado(Associado associado) {
        this.associado = associado;
    }

    


    // MÉTODO QUE RETORNA A ID DO ASSOCIADO DESTE DEPENDENTE ==================
    public Long getThisAssociadoId(Associado a) {        
        Long associadoId = this.associado.getIdAssociado();
        return associadoId;
    }
    // ==========================



    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }


        

    @Override
    public String toString() {
        return "Dependente [id=" + idDependente + ", cpf=" + cpfDependente + ", nome=" + nomeDependente + ", associado=" + associado + ", idade="
                + idade + "]";
    } */


    

    
}
