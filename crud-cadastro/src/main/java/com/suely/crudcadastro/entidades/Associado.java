package com.suely.crudcadastro.entidades;

import java.math.BigDecimal;
import java.util.Set;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAssociado;
    @Column(unique = true, nullable = false)
    private Long cpfAssociado;
    @Column(nullable = false, length = 50)
    private String nomeAssociado;    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "associado")
    private Set<Dependente> dependentes;
    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal renda;
    private boolean ativo;

        

    // CONTRUTOR ======================================
    public Associado(){};    

    public Associado(Long cpfAssociado, String nomeAssociado, BigDecimal renda) {
        this.cpfAssociado = cpfAssociado;
        this.nomeAssociado = nomeAssociado;
        this.renda = renda;
        this.ativo = true;
    }


    // GETTERS E SETTERS ==============================
    public Long getIdAssociado() {
        return idAssociado;
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

    public Set<Dependente> getDependentes() {
        return dependentes;
    }
    public void setDependentes(Set<Dependente> dependentes) {
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
        }else{
            System.out.println("inativo");
        }
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

        
    @Override
    public String toString() {
        return "Associado [ativo=" + this.isAtivo() + ", cpfAssociado=" + cpfAssociado + ", idAssociado=" + idAssociado
                + ", nomeAssociado=" + nomeAssociado + ", renda=" + renda + "]";
    }

}
