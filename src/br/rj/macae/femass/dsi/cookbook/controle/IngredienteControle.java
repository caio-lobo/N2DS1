/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.dsi.cookbook.controle;


import br.rj.macae.femass.dsi.cookbook.dao.IngredienteDAO;
import br.rj.macae.femass.dsi.cookbook.jpa.IngredienteE;
import br.rj.macae.femass.dsi.cookbook.modelo.Categoria;
import br.rj.macae.femass.dsi.cookbook.modelo.Ingrediente;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author anamm
 */
public class IngredienteControle{
    public void gravar(IngredienteE i)throws SQLException{
        IngredienteDAO dao = new IngredienteDAO();
        try{
        if(i.getId()==null || i.getId()<=0)
            dao.adicionar(i);
        else
            dao.alterar(i);
        }catch(SQLException ex){
            throw new SQLException("Erro ao salvar as informações: \n"+ex.getMessage());
        }
    }
    public void excluir(IngredienteE i)throws SQLException{
        if(JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir este ingrediente?")==JOptionPane.YES_OPTION){
            IngredienteDAO dao = new IngredienteDAO();    
            dao.excluir(i);
        }
        
    }
    public void excluir(Long id)throws SQLException{
        if(JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir este ingrediente?")==JOptionPane.YES_OPTION){
            IngredienteDAO dao = new IngredienteDAO();    
            dao.excluir(id);
        }
    }
    public void atualizarLista(JTable tabela) throws SQLException{
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        //limpa as linhas da tabela.
        for(int i=0; i<model.getRowCount(); i++)
            model.removeRow(i);
        
        IngredienteDAO dao = new IngredienteDAO();
        List categorias = dao.listarTodos();
        //Adiciona as linhas
        for (Object o : categorias){
            IngredienteE i = (IngredienteE) o;
            model.addRow(new Object[]{i.getId(),i.getNome(),i.getDescricao()});
        }
        
    }

    public IngredienteE getIngredientePorId(Long id) throws SQLException {
        IngredienteDAO dao = new IngredienteDAO();
        IngredienteE i = (IngredienteE)dao.listarPorId(id);
        return i;       
    }
}
