package com.suely.crudcadastro.entidades;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Associado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_associado")
    private Long idAssociado;
    @Column(name = "cpf_associado", unique = true, nullable = false)
    private Long cpfAssociado;
    @Column(name = "nome_associado", nullable = false, length = 50)
    private String nomeAssociado;    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "associado")
    private List<Dependente> dependentes;
    @Column(nullable = false, precision = 7, scale = 2)
    private BigDecimal renda;
    private boolean ativo = true;



    // CONTRUTOR ======================================
    public Associado(){};    

    public Associado(Long cpf, String nome, BigDecimal renda) {
        this.cpfAssociado = cpf;
        this.nomeAssociado = nome;
        this.renda = renda;
    }


    // GETTERS E SETTERS ==============================
    public Long getIdAssociado() {
        return idAssociado;
    }

    public void setIdAssociado(Long idAssociado) {
        this.idAssociado = idAssociado;
    }

    public Long getCpfAssociado() {
        return cpfAssociado;
    }

    public void setCpfAssociado(Long cpfAssociado) {
        this.cpfAssociado = cpfAssociado;
    }

    public String getNomeAssociado() {
        return nomeAssociado;
    }

    public void setNomeAssociado(String nomeAssociado) {
        this.nomeAssociado = nomeAssociado;
    }

    public List<Dependente> getDependentes() {
        return dependentes;
    }

    public void setDependentes(List<Dependente> dependentes) {
        this.dependentes = dependentes;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public void setRenda(BigDecimal renda) {
        this.renda = renda;
    }
   

    public boolean isAtivo() {
        if(this.ativo){
            System.out.println("ativo");
        } else {
            System.out.println("inativo");
        }
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    
        
    @Override
    public String toString() {
        return "Associado [ativo=" + this.isAtivo() + ", cpf=" + cpfAssociado + ", id=" + idAssociado
                + ", nome=" + nomeAssociado + ", renda=" + renda + "]";
    }

    

    

}
