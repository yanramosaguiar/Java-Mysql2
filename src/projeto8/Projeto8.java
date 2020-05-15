/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author root
 */
public class Projeto8 {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        Connection conexao = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:8889/universidade", "aluno", "123456");
        
        String sql = "SELECT * from `professor` WHERE `titulacao` LIKE ?;";
        
        PreparedStatement psmt = conexao.prepareStatement(sql);
        
        psmt.setString(1, "Dr");
        
        ResultSet rs = psmt.executeQuery();
        
        while(rs.next()){
            System.out.println(rs.getString("nome"));
        }
        
    }
    
}
