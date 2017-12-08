/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.dsi.cookbook.controle;


import br.rj.macae.femass.dsi.cookbook.dao.ClienteDAO;
import br.rj.macae.femass.dsi.cookbook.dao.QuartoDAO;
import br.rj.macae.femass.dsi.cookbook.jpa.ClienteE;
import br.rj.macae.femass.dsi.cookbook.jpa.QuartoE;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hellk
 */
public class QuartoControle {
     public void gravar(QuartoE c)throws SQLException{
         QuartoDAO dao = new QuartoDAO();
        try{
        if(c.getId()==null || c.getId()<=0)
            dao.adicionar(c);
        else
            dao.alterar(c);
        }catch(SQLException ex){
            throw new SQLException("Erro ao salvar as informações: \n"+ex.getMessage());
        }
    }
    public void excluir(QuartoE c)throws SQLException{
        if(JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir esta categoria?")==JOptionPane.YES_OPTION){
            QuartoDAO dao = new QuartoDAO();    
            dao.excluir(c);
        }
    
}
    
     public void excluir(Long id)throws SQLException{
        if(JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir esta categoria?")==JOptionPane.YES_OPTION){
            QuartoDAO dao = new QuartoDAO();    
            dao.excluir(id);
        }
    }
    
    public void atualizarLista(JTable tabela) throws SQLException{
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        //limpa as linhas da tabela.
        for(int i=0; i<model.getRowCount(); i++)
            model.removeRow(i);
        
        QuartoDAO dao = new QuartoDAO();
        List clientes = dao.listarTodos();
        //Adiciona as linhas
        for (Object o : clientes){
            QuartoE c = (QuartoE) o;
            if(c.getInquilino()!=null){ 
                ClienteE q = c.getInquilino();
                model.addRow(new Object[]{c.getId(),q.getNome(),c.getTipo()});
            } else model.addRow(new Object[]{ c.getId(),("VAGO"),c.getTipo()});
           
        }
        
    }
    
    public QuartoE getCategoriaPorId(Long id) throws SQLException {
        QuartoDAO dao = new QuartoDAO();
        QuartoE c = (QuartoE)dao.listarPorId(id);
        return c;       
    }

    public List listarClientesCbb() throws SQLException {
      ClienteDAO dao = new ClienteDAO();
      return dao.listarTodos();
    }
    
}
