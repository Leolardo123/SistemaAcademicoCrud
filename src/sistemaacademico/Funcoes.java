/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaacademico;

import javax.swing.JOptionPane;
import sistemaacademico.Aluno;
import sistemaacademico.Professor;

/**
 *
 * @author leofe_qbel5qv
 */
public class Funcoes {
    static String setSexoMenu(){
        int opt;
            String texto ="";
            do{
                opt =Integer.parseInt(JOptionPane.showInputDialog("Sexo: 1-)Masculino 2-)Feminino 3-)Outro"));
                switch(opt){
                    case 1:texto="Masculino";break;
                    case 2:texto="Feminino";break;
                    case 3:texto=JOptionPane.showInputDialog("Qual?");break;
                    default:JOptionPane.showMessageDialog(null,"Essa opção não existe!");
                    }
                return texto;
            }while(opt<1||opt<3);
    }
    public static Aluno[] maisAlunos(Aluno[] alist){
        Aluno NewAlist[] = new Aluno[alist.length*2];
        NewAlist = alist;//recebe os valores anteriores
        return NewAlist;
    }
    public static Professor[] maisProfessores(Professor[] plist){
        Professor NewPlist[] = new Professor[plist.length*2];
        NewPlist = plist;//recebe os valores anteriores
        return NewPlist;
    }
}
