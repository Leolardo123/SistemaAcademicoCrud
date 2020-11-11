/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaacademico;

import BD.Conexao_Debug;
import BD.Conexao;
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
public class Debug_SA {
    private static String CRIAR_BD = 
        "CREATE DATABASE IF NOT EXISTS sistema_academico";
    
    private static String CRIAR_TABELA_PROFESSORES = 
        " CREATE TABLE IF NOT EXISTS alunos(" +
        "RA int(12) NOT NULL," +
        "nome varchar(256) NOT NULL," +
        "curso varchar(256) NOT NULL,"
        + "endereco varchar(256),"
        + "telefone varchar(256),"
        + "sexo varchar(256),"
        + "PRIMARY KEY (RA)" +
        ");";
    
    private static String CRIAR_TABELA_ALUNOS = 
        " CREATE TABLE IF NOT EXISTS professores(" +
        "registro int(12) NOT NULL," +
        "nome varchar(256) NOT NULL," +
        "materia varchar(256) NOT NULL,"
        + "endereco varchar(256),"
        + "telefone varchar(256),"
        + "sexo varchar(256),"
        + "PRIMARY KEY (registro)" +
        ");";
    
    private static BD.Conexao_Debug con = new Conexao_Debug();
    private static Connection conexao = con.getConnection("");
    private static PreparedStatement ps = null;
    
    public static void create_database(){//cria BD configurado para executar o programa sistema academico

            try{
                ps = conexao.prepareStatement(CRIAR_BD);
                ps.executeUpdate();
            }catch(SQLException ex){
                Logger.getLogger(Debug_SA.class.getName()).log(Level.SEVERE,null,ex);
                System.out.println(ex);
            }
            conexao = con.getConnection("sistema_academico");
            create_tableAlunos();
            create_tableProfessores();
    }
    private static void create_tableAlunos(){//cria BD configurado para executar o programa sistema academico
            try{
                ps = conexao.prepareStatement(CRIAR_TABELA_ALUNOS);
                ps.executeUpdate();
            }catch(SQLException ex){
                Logger.getLogger(Debug_SA.class.getName()).log(Level.SEVERE,null,ex);
            }
    }
    private static void create_tableProfessores(){//cria BD configurado para executar o programa sistema academico
            try{
                ps = conexao.prepareStatement(CRIAR_TABELA_PROFESSORES);
                ps.executeUpdate();
            }catch(SQLException ex){
                Logger.getLogger(Debug_SA.class.getName()).log(Level.SEVERE,null,ex);
            }
    }
    public static void Delete_All(){//cria BD configurado para executar o programa sistema academico
            conexao = con.getConnection("sistema_academico");    
            try{
                ps = conexao.prepareStatement("DELETE FROM alunos");
                ps.executeUpdate();
            }catch(SQLException ex){
                Logger.getLogger(Debug_SA.class.getName()).log(Level.SEVERE,null,ex);
            }
            try{
                ps = conexao.prepareStatement("DELETE FROM professores");
                ps.executeUpdate();
            }catch(SQLException ex){
                Logger.getLogger(Debug_SA.class.getName()).log(Level.SEVERE,null,ex);
                System.out.println(ex);
            }
    }
}
