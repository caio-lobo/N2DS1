/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.dsi.cookbook.dao;

import br.rj.macae.femass.dsi.cookbook.jpa.ClienteE;
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
public class ClienteDAO implements IDAO{

    @Override
    public void adicionar(Object o) throws SQLException {
    
        ClienteE ce = (ClienteE) o;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cookbookPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        em.persist(ce);
        em.getTransaction().commit();
        em.close();
        emf.close();
    
    }

    @Override
    public void alterar(Object o) throws SQLException {
         ClienteE ce = (ClienteE) o;
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cookbookPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        em.merge(ce);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    @Override
    public void excluir(Object o) throws SQLException {
    ClienteE ce = (ClienteE) o;
    
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("cookbookPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        em.remove(ce);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    
    @Override
    public List listarTodos() throws SQLException {
    
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cookbookPU");
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<ClienteE> query = em.createQuery("select c from ClienteE c", ClienteE.class);
        List<ClienteE> list = query.getResultList();
        
        
        em.close();
        emf.close();
        return list;
    }

    @Override
    public Object listarPorId(Long id) throws SQLException {
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cookbookPU");
        EntityManager em = emf.createEntityManager();
        
        ClienteE c = em.find(ClienteE.class, id);
        
        em.close();
        emf.close();
        return c;
    }

    @Override
    public void excluir(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Object listarPorEmail(String id) throws SQLException {
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cookbookPU");
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<ClienteE> query = em.createQuery("select c from ClienteE c where email ="+id, ClienteE.class);
        List<ClienteE> list = query.getResultList();
        
        em.close();
        emf.close();
        return list;
    }
    
}
