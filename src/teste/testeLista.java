/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;
import java.util.Iterator;
import sistemaacademico.Aluno;
import java.util.LinkedList;
/**
 *
 * @author leofe_qbel5qv
 */
public class testeLista {
    public static void main(String[] args) {
		LinkedList li = new LinkedList();
		Aluno a;
		
		for(int i = 0;i<100;i++) {
			a = new Aluno();
			a.setNome(i+"");
			li.add(a);
		}
		Iterator it;
                it = li.iterator();
                
                while(it.hasNext()){
                    a = (Aluno) it.next();
                }
                /*
		for(int i = 0; i<100; i++) {
			a = (Aluno)li.get(i);
			System.out.println(a.getNome());
		}
                */
		
	}
}
