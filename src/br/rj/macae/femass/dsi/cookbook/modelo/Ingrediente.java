/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.dsi.cookbook.modelo;

import br.rj.macae.femass.dsi.cookbook.jpa.Receita_IngredienteE;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author anamm
 */
public class Ingrediente {
    private Long id;
    private String nome;
    private String descricao;
    private List<Receita_Ingrediente> receitas;
    
    public List<Receita_Ingrediente> getReceitas(){
        return Collections.unmodifiableList(receitas);
    }
    public void setReceita(Receita_Ingrediente receita){
        this.receitas.add(receita);
    }
    public void removeReceita(Receita_Ingrediente receita){
        if(this.receitas.contains(receita))
            this.receitas.remove(receita);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
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
        final Ingrediente other = (Ingrediente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

    public List<Receita_IngredienteE> getReceitastoE() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
