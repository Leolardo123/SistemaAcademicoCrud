/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaacademico;

import BD.Conexao;
import BD.expressoes_BD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leofe_qbel5qv
 */
public class debug {
    private static String CRIAR_BD = "CREATE DATABASE IF NOT EXISTS sistema_academico";
    private static String CRIAR_TABELA_PROFESSORES = " CREATE TABLE IF NOT EXISTS alunos(" +
                                                "RA int(12) NOT NULL," +
                                                "nome varchar(256) NOT NULL," +
                                                "curso varchar(256) NOT NULL,"
                                                + "endereco varchar(256),"
                                                + "telefone varchar(256),"
                                                + "sexo varchar(256),"
                                                + "PRIMARY KEY (RA)" +
                                                ");";
    private static String CRIAR_TABELA_ALUNOS = " CREATE TABLE IF NOT EXISTS professores(" +
                                                "registro int(12) NOT NULL," +
                                                "nome varchar(256) NOT NULL," +
                                                "materia varchar(256) NOT NULL,"
                                                + "endereco varchar(256),"
                                                + "telefone varchar(256),"
                                                + "sexo varchar(256),"
                                                + "PRIMARY KEY (registro)" +
                                                ");";
    public static Connection connection = null;
    static PreparedStatement stmt = null;
    public static Connection getConfigConnection(String statement){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(statement,"root","");
            return connection;
        } catch (ClassNotFoundException | SQLException ex) {
            return null;
            //Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public static void create_database(){//cria BD configurado para executar o programa sistema academico
            Connection con = getConfigConnection("jdbc:mysql://localhost/");

            try{
                stmt = con.prepareStatement(CRIAR_BD);
                stmt.executeUpdate();
            }catch(SQLException ex){
                Logger.getLogger(debug.class.getName()).log(Level.SEVERE,null,ex);
            }
            create_tableAlunos();
            create_tableProfessores();
    }
    private static void create_tableAlunos(){//cria BD configurado para executar o programa sistema academico
            Connection con = getConfigConnection("jdbc:mysql://localhost/sistema_academico");
            try{
                stmt = con.prepareStatement(CRIAR_TABELA_ALUNOS);
                stmt.executeUpdate();
                con.close();
            }catch(SQLException ex){
                Logger.getLogger(debug.class.getName()).log(Level.SEVERE,null,ex);
            }
    }
    private static void create_tableProfessores(){//cria BD configurado para executar o programa sistema academico
            Connection con = getConfigConnection("jdbc:mysql://localhost/sistema_academico");
            try{
                stmt = con.prepareStatement(CRIAR_TABELA_PROFESSORES);
                stmt.executeUpdate();
            }catch(SQLException ex){
                Logger.getLogger(debug.class.getName()).log(Level.SEVERE,null,ex);
            }
    }
    public static void Delete_All(){//cria BD configurado para executar o programa sistema academico
            Connection con = getConfigConnection("jdbc:mysql://localhost/sistema_academico");
            try{
                stmt = con.prepareStatement("DELETE FROM alunos");
                stmt.executeUpdate();
            }catch(SQLException ex){
                Logger.getLogger(debug.class.getName()).log(Level.SEVERE,null,ex);
            }
            try{
                stmt = con.prepareStatement("DELETE FROM professores");
                stmt.executeUpdate();
            }catch(SQLException ex){
                Logger.getLogger(debug.class.getName()).log(Level.SEVERE,null,ex);
            }
    }
}
