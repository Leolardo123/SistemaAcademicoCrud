/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author leofe_qbel5qv
 */
public class Conexao_Debug {
    public static Connection connection = null;
    
    public static Connection getConnection(String BancoDados){
        if(BancoDados==null){
            BancoDados="";
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/"+BancoDados,"root","");
            return connection;
        } catch (ClassNotFoundException | SQLException ex) {
            return null;
            //Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
