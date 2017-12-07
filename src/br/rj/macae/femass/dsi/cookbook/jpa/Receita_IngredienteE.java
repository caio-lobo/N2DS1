/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.dsi.cookbook.jpa;

import br.rj.macae.femass.dsi.cookbook.modelo.Ingrediente;
import br.rj.macae.femass.dsi.cookbook.modelo.Receita;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author hellk
 */
@Entity
public class Receita_IngredienteE implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(targetEntity = ReceitaE.class)
    private ReceitaE receita;
    
    
    @ManyToOne 
    private IngredienteE ingrediente;
    
    private float quantidade;
    private String unidade;

    /**
     * @return the receita
     */
    public ReceitaE getReceita() {
        return receita;
    }

    /**
     * @param receita the receita to set
     */
    public void setReceita(ReceitaE receita) {
        this.receita = receita;
    }

    /**
     * @return the ingrediente
     */
    public IngredienteE getIngrediente() {
        return ingrediente;
    }

    /**
     * @param ingrediente the ingrediente to set
     */
    public void setIngrediente(IngredienteE ingrediente) {
        this.ingrediente = ingrediente;
    }

    /**
     * @return the quantidade
     */
    public float getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the unidade
     */
    public String getUnidade() {
        return unidade;
    }

    /**
     * @param unidade the unidade to set
     */
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receita_IngredienteE)) {
            return false;
        }
        Receita_IngredienteE other = (Receita_IngredienteE) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.rj.macae.femass.dsi.cookbook.jpa.Receita_IngredienteEE[ id=" + id + " ]";
    }
    
}
