/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.dsi.cookbook.controle;

import br.rj.macae.femass.dsi.cookbook.dao.CategoriaDAO;
import br.rj.macae.femass.dsi.cookbook.jpa.CategoriaE;
import br.rj.macae.femass.dsi.cookbook.jpa.ReceitaE;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author anamm
 */
public class CategoriaControle{
    public void gravar(CategoriaE c)throws SQLException{
      CategoriaDAO dao = new CategoriaDAO();
        try{
        if(c.getId()==null || c.getId()<=0)
            dao.adicionar(c);
        else
            dao.alterar(c);
        }catch(SQLException ex){
            throw new SQLException("Erro ao salvar as informações: \n"+ex.getMessage());
        }
    }
    public void excluir(CategoriaE c)throws SQLException{
        if(JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir esta categoria?")==JOptionPane.YES_OPTION){
            CategoriaDAO dao = new CategoriaDAO();    
            dao.excluir(c);
        }
        
    }
    public void excluir(Long id)throws SQLException{
        if(JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir esta categoria?")==JOptionPane.YES_OPTION){
            CategoriaDAO dao = new CategoriaDAO();    
            dao.excluir(id);
        }
    }
    public void atualizarLista(JTable tabela) throws SQLException{
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        //limpa as linhas da tabela.
        for(int i=0; i<model.getRowCount(); i++)
            model.removeRow(i);
        
        CategoriaDAO dao = new CategoriaDAO();
        List categorias = dao.listarTodos();
        //Adiciona as linhas
        for (Object o : categorias){
            CategoriaE c = (CategoriaE) o;
            model.addRow(new Object[]{c.getId(),c.getNome(),c.getDescricao()});
        }
        
    }

    public CategoriaE getCategoriaPorId(Long id) throws SQLException {
        CategoriaDAO dao = new CategoriaDAO();
        CategoriaE c = (CategoriaE)dao.listarPorId(id);
        return c;       
    }

    public List getReceitas(Long id) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("cookbookPU");
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<ReceitaE> query = em.createQuery("select c from ReceitaE c", ReceitaE.class);
        
        List<ReceitaE> list = query.getResultList();
        List<ReceitaE> result = new ArrayList<>();
        result.clear();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getCategoria().getId() == id){
                result.add(list.get(i));
            }
            
        }
        
        
        em.close();
        emf.close();
        return result;}
}
