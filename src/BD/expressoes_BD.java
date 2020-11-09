/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

/**
 *
 * @author leofe_qbel5qv
 */
public class expressoes_BD {
    public static String LISTAR_ALUNOS  = "SELECT * FROM alunos";
    public static String INSERIR_ALUNOS = "INSERT INTO alunos (RA,nome,curso,endereco,telefone,sexo) VALUES (?,?,?,?,?,?)";
    public static String EXCLUIR_ALUNOS = "DELETE FROM alunos WHERE RA = ?";
    public static String UPDATE_ALUNOS  = "UPDATE alunos SET RA = ?,nome = ?,curso = ?,endereco = ?,telefone = ?,sexo = ? WHERE RA = ?";
    
    public static String LISTAR_PROFESSORES  = "SELECT * FROM professores";
    public static String INSERIR_PROFESSORES = "INSERT INTO professores (registro,nome,curso,endereco,telefone,sexo) VALUES (?,?,?,?,?,?)";
    public static String EXCLUIR_PROFESSORES = "DELETE FROM professores WHERE registro = ?";
    public static String UPDATE_PROFESSORES  = "UPDATE professores SET registro = ?,nome = ?,curso = ?,endereco = ?,telefone = ?,sexo = ? WHERE registro = ?";
}
