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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private Long cpf;
    @Column(nullable = false, length = 50)
    private String nome;    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "associado")
    private Set<Dependente> dependentes;
    @Column(nullable = false, precision = 7, scale = 2)
    private BigDecimal renda;
    private boolean ativo;

        

    // CONTRUTOR ======================================
    public Associado(){};    

    public Associado(Long cpf, String nome, BigDecimal renda) {
        this.cpf = cpf;
        this.nome = nome;
        this.renda = renda;
        this.ativo = true;
    }


    // GETTERS E SETTERS ==============================
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getCpf() {        
        return cpf;
    }
    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
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
        return "Associado [ativo=" + this.isAtivo() + ", cpf=" + cpf + ", id=" + id
                + ", nome=" + nome + ", renda=" + renda + "]";
    }

}
