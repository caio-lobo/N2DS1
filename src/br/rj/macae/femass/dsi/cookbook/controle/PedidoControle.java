/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.dsi.cookbook.controle;

import br.rj.macae.femass.dsi.cookbook.dao.PedidoDAO;
import br.rj.macae.femass.dsi.cookbook.jpa.PedidoE;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hellk
 */
public class PedidoControle {
    
     public void gravar(PedidoE c)throws SQLException{
         PedidoDAO dao = new PedidoDAO();
        try{
        if(c.getId()==null || c.getId()<=0)
            dao.adicionar(c);
        else
            dao.alterar(c);
        }catch(SQLException ex){
            throw new SQLException("Erro ao salvar as informações: \n"+ex.getMessage());
        }
    }
    public void excluir(PedidoE c)throws SQLException{
        if(JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir esta categoria?")==JOptionPane.YES_OPTION){
            PedidoDAO dao = new PedidoDAO();    
            dao.excluir(c);
        }
    
}
    
     public void excluir(Long id)throws SQLException{
        if(JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir esta categoria?")==JOptionPane.YES_OPTION){
            PedidoDAO dao = new PedidoDAO();    
            dao.excluir(id);
        }
    }
    
    public void atualizarLista(JTable tabela) throws SQLException{
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        //limpa as linhas da tabela.
        for(int i=0; i<model.getRowCount(); i++)
            model.removeRow(i);
        
        PedidoDAO dao = new PedidoDAO();
        List clientes = dao.listarTodos();
        //Adiciona as linhas
        for (Object o : clientes){
            PedidoE c = (PedidoE) o;
           model.addRow(new Object[]{ c.getId(),c.getOrigem(), c.getEndereco()});
           
        }
        
    }
    
    public PedidoE getCategoriaPorId(Long id) throws SQLException {
        PedidoDAO dao = new PedidoDAO();
        PedidoE c = (PedidoE)dao.listarPorId(id);
        return c;       
    }

    public List getReceitas(long cliente) throws SQLException {
            PedidoDAO pdao = new PedidoDAO();
            return pdao.listarReceitas(cliente);
            
                    
            
            }
    
    
    
}
