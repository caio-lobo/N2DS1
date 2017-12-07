/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.dsi.cookbook.modelo;

import br.rj.macae.femass.dsi.cookbook.jpa.CategoriaE;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author anamm
 */
public class Receita {
    private Long id;
    private String nome;    
    private String modoPreparo;
    private String modoServir;
    private Categoria categoria;
    private List<Receita_Ingrediente> ingredientes;

    public Receita(Long receitaId) {
        this.setId(id);
        ingredientes = new ArrayList<Receita_Ingrediente>();
    }

    public Receita() {
        ingredientes = new ArrayList<Receita_Ingrediente>();
    }
    
    public List<Receita_Ingrediente> getIngredientes(){
        return Collections.unmodifiableList(ingredientes);
    }
    public void setIngrediente(Receita_Ingrediente ingrediente){
        this.ingredientes.add(ingrediente);
    }
    public void removeIngrediente(Receita_Ingrediente ingrediente){
        if(this.ingredientes.contains(ingrediente))
            this.ingredientes.remove(ingrediente);
    }
    
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

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

    /**
     * @return the categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
        categoria.setReceita(this);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Receita other = (Receita) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  nome;
    }

    public CategoriaE getCategoriatoE() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
