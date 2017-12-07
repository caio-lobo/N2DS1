/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.dsi.cookbook.jpa;

import br.rj.macae.femass.dsi.cookbook.modelo.Categoria;
import br.rj.macae.femass.dsi.cookbook.modelo.Ingrediente;
import br.rj.macae.femass.dsi.cookbook.modelo.Receita_Ingrediente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author hellk
 */
@Entity
public class ReceitaE implements Serializable {

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the modoPreparo
     */
    public String getModoPreparo() {
        return modoPreparo;
    }

    /**
     * @param modoPreparo the modoPreparo to set
     */
    public void setModoPreparo(String modoPreparo) {
        this.modoPreparo = modoPreparo;
    }

    /**
     * @return the modoServir
     */
    public String getModoServir() {
        return modoServir;
    }

    /**
     * @param modoServir the modoServir to set
     */
    public void setModoServir(String modoServir) {
        this.modoServir = modoServir;
    }

    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;    
    private String modoPreparo;
    private String modoServir;
    @ManyToOne
    private CategoriaE categoria;
    
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Receita_IngredienteE> ingredientes;

   

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
        if (!(object instanceof ReceitaE)) {
            return false;
        }
        ReceitaE other = (ReceitaE) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.rj.macae.femass.dsi.cookbook.jpa.ReceitaE[ id=" + id + " ]";
    }

    /**
     * @return the categoria
     */
    public CategoriaE getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(CategoriaE categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the ingredientes
     */
    public List<Receita_IngredienteE> getIngredientes() {
        return ingredientes;
    }

    /**
     * @param ingredientes the ingredientes to set
     */
    public void setIngredientes(List<Receita_IngredienteE> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void addIngredientes(Receita_IngredienteE elementAt) {
           if(this.getIngredientes() == null){
                this.setIngredientes(new ArrayList<Receita_IngredienteE>());
            }
        this.getIngredientes().add(elementAt);
      
       
               }
    
}
