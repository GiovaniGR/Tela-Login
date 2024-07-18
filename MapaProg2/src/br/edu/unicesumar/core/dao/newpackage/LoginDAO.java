/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.unicesumar.core.dao.newpackage;

import br.edu.unicesumar.core.dao.conexao.ConexaoJDBC;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import br.edu.unicesumar.core.entity.Login;

/**
 *
 * @author gigui
 */
public class LoginDAO {
    
    public void pessoa (Login login){
    
    String sql = "SELECT nome, login, senha, email from usuario where login = ? and senha = ?";
    
    PreparedStatement ps = null; 
    ResultSet rs = null;
    
    
    
    try{
        ps = ConexaoJDBC.getConexao().prepareStatement(sql);
        ps.setString(1, login.getLog());
        ps.setString(2, login.getSen());
        
        rs = ps.executeQuery();
        
        if(rs.next()){
            String nome = rs.getString("NOME");
            String email = rs.getString("EMAIL");
            
            JOptionPane.showMessageDialog(null, "Acesso Autorizado");
        }else{
            JOptionPane.showMessageDialog(null,"Acesso negado");
        }
    }catch(SQLException e){        
        
    }finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    }   
}
}