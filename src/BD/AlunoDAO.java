/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import BD.Conexao;
import BD.expressoes_BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistemaacademico.Aluno;
import sistemaacademico.Funcoes;

/**
 *
 * @author leofe_qbel5qv
 */
public class AlunoDAO {
    Aluno[] Alunos = new Aluno[40];
    static PreparedStatement stmt = null;
    static Connection  con = Conexao.getConnection();
    public static boolean create(Aluno a){
        try{
            stmt = con.prepareStatement(expressoes_BD.INSERIR_ALUNOS);
            stmt.setInt(1,a.getRA());
            stmt.setString(2,a.getNome());
            stmt.setString(3,a.getCurso());
            stmt.setString(4,a.getEndereço());
            stmt.setString(5,a.getTelefone());
            stmt.setString(6,a.getSexo());
            stmt.executeUpdate();
            return true;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
            return false;
        }
    }
    public static boolean update(Aluno a,int RA){
        try{
            stmt = con.prepareStatement(expressoes_BD.UPDATE_ALUNOS);
            stmt.setInt(1,a.getRA());
            stmt.setString(2,a.getNome());
            stmt.setString(3,a.getCurso());
            stmt.setString(4,a.getEndereço());
            stmt.setString(5,a.getTelefone());
            stmt.setString(6,a.getSexo());
            stmt.setInt(7,RA);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Aluno alterado com sucesso!");
            return true;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
            return false;
        }
    }
    public static boolean delete(int RA){
        try{
            stmt = con.prepareStatement(expressoes_BD.EXCLUIR_ALUNOS);
            stmt.setInt(1,RA);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Aluno excluído com sucesso!");
            return true;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
            return false;
        }
    }
    
}
