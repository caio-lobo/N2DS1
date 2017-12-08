/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.dsi.cookbook.controle;

import br.rj.macae.femass.dsi.cookbook.dao.ClienteDAO;
import br.rj.macae.femass.dsi.cookbook.jpa.ClienteE;
import br.rj.macae.femass.dsi.cookbook.jpa.QuartoE;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hellk
 */
public class ClienteControle {
    
    
    public void gravar(ClienteE c)throws SQLException{
        ClienteDAO dao = new ClienteDAO();
        try{
        if(c.getId()==null || c.getId()<=0)
            dao.adicionar(c);
        else
            dao.alterar(c);
        }catch(SQLException ex){
            throw new SQLException("Erro ao salvar as informações: \n"+ex.getMessage());
        }
    }
    public void excluir(ClienteE c)throws SQLException{
        if(JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir esta categoria?")==JOptionPane.YES_OPTION){
            ClienteDAO dao = new ClienteDAO();    
            dao.excluir(c);
        }
    
}
    
     public void excluir(Long id)throws SQLException{
        if(JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir esta categoria?")==JOptionPane.YES_OPTION){
            ClienteDAO dao = new ClienteDAO();    
            dao.excluir(id);
        }
    }
    
    public void atualizarLista(JTable tabela) throws SQLException{
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        //limpa as linhas da tabela.
        for(int i=0; i<model.getRowCount(); i++)
            model.removeRow(i);
        
        ClienteDAO dao = new ClienteDAO();
        List clientes = dao.listarTodos();
        //Adiciona as linhas
        for (Object o : clientes){
            ClienteE c = (ClienteE) o;
            if(c.getQuarto()!=null){ 
                QuartoE q = c.getQuarto();
                model.addRow(new Object[]{q.getId(), c.getId(),c.getNome(),c.getEndereco(), c.getTelefone(), c.getDependentes()});
            } else model.addRow(new Object[]{("AWAY"), c.getId(),c.getNome(),c.getEndereco(), c.getTelefone(), c.getDependentes()});
           
        }
        
    }
    
    public ClienteE getCategoriaPorId(Long id) throws SQLException {
        ClienteDAO dao = new ClienteDAO();
        ClienteE c = (ClienteE)dao.listarPorId(id);
        return c;       
    }

    public void getClientePorEmail(String text) throws SQLException {
       ClienteDAO dao = new ClienteDAO();
       ClienteE c = (ClienteE) dao.listarPorEmail(text);
    }

    public List listarTodos() throws SQLException {
     ClienteDAO dao = new ClienteDAO();
     return dao.listarTodos();
             }

    public void atualizarCbb(JComboBox<Object> cbbCliente) throws SQLException {
    cbbCliente.removeAllItems();
    ClienteDAO dao = new ClienteDAO();
    List dados = dao.listarTodos();
    
    for(Object o : dados){
        cbbCliente.addItem(o);
    }
    
    }
    
}
