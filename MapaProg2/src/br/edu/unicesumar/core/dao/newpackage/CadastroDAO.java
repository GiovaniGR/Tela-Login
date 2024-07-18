/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.unicesumar.core.dao.newpackage;

import br.edu.unicesumar.core.entity.Usuario;
import br.edu.unicesumar.core.dao.conexao.ConexaoJDBC;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author gigui
 */
public class CadastroDAO { 
    
    public void cad (Usuario usuario){
    
    
    String sql = "INSERT INTO USUARIO (NOME, LOGIN, SENHA, EMAIL) VALUES (?,?,?,?)";
    
    PreparedStatement ps = null; 
    
    try{
        ps = ConexaoJDBC.getConexao().prepareStatement(sql);
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getLogin());
        ps.setString(3, usuario.getSenha());
        ps.setString(4, usuario.getEmail());     
               
        ps.execute();
        
        JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
        
    }catch(SQLException e){
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
    }finally {
        try {            
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
}
}
}