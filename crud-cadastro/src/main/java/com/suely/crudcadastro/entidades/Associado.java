package com.suely.crudcadastro.entidades;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;



@Entity
public class Associado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_associado")
    private Long idAssociado;
    @Column(name = "cpf_associado")
    private Long cpfAssociado;
    @Column(name = "nome_associado")
    private String nomeAssociado;   
    private BigDecimal renda;
    private boolean ativo = true;

    @OneToMany
    @Transient
    private List<Dependente> dependentes;



    public Associado(){}



    public Associado(Long cpfAssociado, String nomeAssociado, BigDecimal renda, boolean ativo,
            List<Dependente> dependentes) {
        this.cpfAssociado = cpfAssociado;
        this.nomeAssociado = nomeAssociado;
        this.renda = renda;
        this.ativo = ativo;
        this.dependentes = dependentes;
    }




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

    public BigDecimal getRenda() {
        return renda;
    }

    public void setRenda(BigDecimal renda) {
        this.renda = renda;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    
    public List<Dependente> getDependentes() {
        return dependentes;
    }
    
    public void setDependentes(List<Dependente> dependentes) {
        this.dependentes = dependentes;
    }

    


    


    





    


}
