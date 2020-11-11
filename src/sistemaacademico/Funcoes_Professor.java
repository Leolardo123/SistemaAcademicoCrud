/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaacademico;

import BD.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PICHAU
 */
public class Funcoes_Professor {
    
    private static BD.Conexao con = new Conexao();
    private static Connection conexao = con.getConnection();
    private static PreparedStatement ps = null;
    
    public static boolean isRegister(Sentenca_Professor s){
        String sql = Sentenca_Professor.REGISTRAR;
        
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, s.getRegistro());
            ps.setString(2, s.getNome());
            ps.setString(3, s.getMateria());
            ps.setString(4, s.getEndereco());
            ps.setString(5, s.getTelefone());
            ps.setString(6, s.getSexo());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
            //Logger.getLogger(Funcoes_Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean isUpdate(Sentenca_Professor s){
        String sql = Sentenca_Professor.ATUALIZAR;
        
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, s.getNome());
            ps.setString(2, s.getMateria());
            ps.setString(3, s.getEndereco());
            ps.setString(4, s.getTelefone());
            ps.setString(5, s.getSexo());
            ps.setString(6, s.getRegistro());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
            //Logger.getLogger(Funcoes_Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean isDelete(Sentenca_Professor s){
        String sql = Sentenca_Professor.ELIMINAR;
        
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, s.getRegistro());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
            //Logger.getLogger(Funcoes_Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean isTruncate(Sentenca_Professor s){
        String sql = Sentenca_Professor.ELIMINAR_TODOS;
        
        try {
            ps = conexao.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
            //Logger.getLogger(Funcoes_Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void setListar(String buscar){
        DefaultTableModel modelo = (DefaultTableModel)Menu_Principal.tbl_professores.getModel();
        
        while(modelo.getRowCount() > 0){
            modelo.removeRow(0);
        }
        
        String sql = "";
        
        if(buscar.equals("")){
            sql = Sentenca_Professor.LISTAR;
        }else{
            sql = "SELECT * FROM alunos WHERE ("
                    + "nome LIKE '"+buscar+"%' OR "
                    + "curso LIKE '"+buscar+"%' OR "
                    + "endereco LIKE '"+buscar+"%' OR "
                    + "telefone LIKE '"+buscar+"%' OR "
                    + "sexo LIKE '"+buscar+"%' OR "
                    + "RA LIKE '"+buscar+"%')";
        }
        
        String dados[] = new String[6];
        
        try {
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                dados[0] = rs.getString("registro");
                dados[1] = rs.getString("nome");
                dados[2] = rs.getString("materia");
                dados[3] = rs.getString("endereco");
                dados[4] = rs.getString("telefone");
                dados[5] = rs.getString("sexo");
                modelo.addRow(dados);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Funcoes_Professor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String extrairIDMax(){
        String sql = "SELECT MAX(id)AS valor FROM professores";
        int id = 0;
        try {
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if(rs.next()){
                id = rs.getInt(1);
            }
            
            if(id == 0){
                id = 1;
            }else{
                id = id + 1;
            }

            return String.valueOf(id);
        } catch (SQLException ex) {
            return null;
            //Logger.getLogger(Funcoes_Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
