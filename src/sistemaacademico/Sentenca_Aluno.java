/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaacademico;

/**
 *
 * @author PICHAU
 */
public class Sentenca_Aluno extends Pessoa{
    
    public static String LISTAR = "SELECT * FROM alunos";
    public static String REGISTRAR = "INSERT INTO alunos("
            + "RA,"
            + "nome,"
            + "curso,"
            + "endereco,"
            + "telefone,"
            + "sexo) "
            + "VALUES(?,?,?,?,?,?)";
    public static String ATUALIZAR = "UPDATE alunos SET "
            + "nome = ?,"
            + "curso = ?,"
            + "endereco = ?,"
            + "telefone = ?,"
            + "sexo = ? "
            + "WHERE RA = ?";
    public static String ELIMINAR = "DELETE FROM alunos WHERE RA = ?";
    public static String ELIMINAR_TODOS = "TRUNCATE TABLE alunos";
    
    private String RA;
    private String curso;

    public String getRA() {
        return RA;
    }

    public void setRA(String RA) {
        this.RA = RA;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    
    
    
}
