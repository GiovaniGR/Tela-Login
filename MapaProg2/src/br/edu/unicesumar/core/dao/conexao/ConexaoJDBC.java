/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.unicesumar.core.dao.conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author gigui
 */
public class ConexaoJDBC {
    
    private static final String URL = "jdbc:mysql://localhost:3306/mapa2";
    private static final String USER = "root";
    private static final String PASSWORD = "giovani13";
    
    public static Connection conn;
    
    public static Connection getConexao(){
        try{
            if (conn == null){
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                return conn;
            }else{
                return conn;
            
            }
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Houve um erro ao tentar conectar com o banco de dados");
            return null;
        }   
}
    
}
