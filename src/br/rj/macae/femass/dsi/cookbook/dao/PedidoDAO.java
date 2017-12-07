/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.dsi.cookbook.dao;

import br.rj.macae.femass.dsi.cookbook.jpa.PedidoE;
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
public class PedidoDAO implements IDAO{

    @Override
    public void adicionar(Object o) throws SQLException {
   
        PedidoE pe = (PedidoE) o;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cookbookPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        em.persist(pe);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    @Override
    public void alterar(Object o) throws SQLException {
    
        PedidoE pe = (PedidoE) o;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cookbookPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        em.merge(pe);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    @Override
    public void excluir(Object o) throws SQLException {
    
        PedidoE pe = (PedidoE) o;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cookbookPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        em.remove(pe);
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
        
        TypedQuery<PedidoE> query = em.createQuery("select c from PedidoE c", PedidoE.class);
        List<PedidoE> list = query.getResultList();
        
        
        em.close();
        emf.close();
        return list;}

    @Override
    public Object listarPorId(Long id) throws SQLException {
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("cookbookPU");
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<PedidoE> query = em.createQuery("select c from PedidoE c where id ="+id+"", PedidoE.class);
        List<PedidoE> list = query.getResultList();
        
        em.close();
        emf.close();
        return list; }
    
}
