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
public class Sentenca_Professor extends Pessoa{
    
    public static String LISTAR = "SELECT * FROM professores";
    public static String REGISTRAR = "INSERT INTO professores("
            + "registro,"
            + "nome,"
            + "materia,"
            + "endereco,"
            + "telefone,"
            + "sexo) "
            + "VALUES(?,?,?,?,?,?)";
    public static String ATUALIZAR = "UPDATE professores SET "
            + "nome = ?,"
            + "materia = ?,"
            + "endereco = ?,"
            + "telefone = ?,"
            + "sexo = ? "
            + "WHERE registro = ?";
    public static String ELIMINAR = "DELETE FROM professores WHERE id = ?";
    public static String ELIMINAR_TODOS = "TRUNCATE TABLE professores";
    
    private String registro;
    private String materia;

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    
    
    
}
