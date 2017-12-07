/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.dsi.cookbook.dao;

import br.rj.macae.femass.dsi.cookbook.jpa.ReceitaE;
import br.rj.macae.femass.dsi.cookbook.modelo.Categoria;
import br.rj.macae.femass.dsi.cookbook.modelo.Ingrediente;
import br.rj.macae.femass.dsi.cookbook.modelo.Receita;
import br.rj.macae.femass.dsi.cookbook.modelo.Receita_Ingrediente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author anamm
 */
public class ReceitaDAO implements IDAO{

    @Override
    public void adicionar(Object o) throws SQLException {
        ReceitaE re = (ReceitaE) o;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cookbookPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        em.persist(re);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }

    @Override
    public void alterar(Object o) throws SQLException {
        ReceitaE re = (ReceitaE) o;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cookbookPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        em.persist(re);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    @Override
    public void excluir(Object o) throws SQLException {
        ReceitaE re = (ReceitaE) o;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cookbookPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        em.remove(re);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
   /* @Override
    public void excluir(Long id) throws SQLException {
        
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();

            String sql = "DELETE FROM public.receita\n" +
"	WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            // preenche os valores                     
            stmt.setLong(1, id);
            
            stmt.executeUpdate();
            stmt.close();
            
        } catch (SQLException e) {
            throw new SQLException("Eroo ao tentar remover a receita. \n" + e.getMessage());
        }
    }*/

    @Override
    public List listarTodos() throws SQLException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cookbookPU");
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<ReceitaE> query = em.createQuery("select c from ReceitaE c", ReceitaE.class);
        List<ReceitaE> list = query.getResultList();
        
        
        em.close();
        emf.close();
        return list;
    }

    @Override
    public Object listarPorId(Long id) throws SQLException {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("cookbookPU");
        EntityManager em = emf.createEntityManager();
        
        ReceitaE r = em.find(ReceitaE.class, id);
        
        em.close();
        emf.close();
        return r;    }

    @Override
    public void excluir(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
