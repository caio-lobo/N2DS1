/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.dsi.cookbook.dao;

import br.rj.macae.femass.dsi.cookbook.jpa.ClienteE;
import br.rj.macae.femass.dsi.cookbook.jpa.QuartoE;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author hellk
 */
public class QuartoDAO implements IDAO{

    @Override
    public void adicionar(Object o) throws SQLException {
    
        QuartoE qe = (QuartoE) o;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cookbookPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        em.persist(qe);
        em.getTransaction().commit();
        em.close();
        emf.close();
    
    }

    @Override
    public void alterar(Object o) throws SQLException {
   
        QuartoE qe = (QuartoE) o;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cookbookPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        em.merge(qe);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    
        
    }

    @Override
    public void excluir(Object o) throws SQLException {
    
        QuartoE qe = (QuartoE) o;
            
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cookbookPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        em.remove(qe);
        em.getTransaction().commit();
        em.close();
        emf.close();
    
    }

    @Override
    public void excluir(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listarTodos() throws SQLException {
    
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("cookbookPU");
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<QuartoE> query = em.createQuery("select c from QuartoE c", QuartoE.class);
        List<QuartoE> list = query.getResultList();
        
        
        em.close();
        emf.close();
        return list;
    }

    @Override
    public Object listarPorId(Long id) throws SQLException {
   
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cookbookPU");
        EntityManager em = emf.createEntityManager();
        
        QuartoE q = em.find(QuartoE.class, id);
        
        em.close();
        emf.close();
        return q;
    }
    
    
}
