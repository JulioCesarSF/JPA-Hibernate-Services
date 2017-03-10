package br.com.fiap.eletro.Testes;

import br.com.fiap.eletro.beans.Livro;
import br.com.fiap.eletro.beans.Tablet;

public class Teste1 {

	public static void main(String[] args) {
		Tablet t = new Tablet(1, "Tablet", 999, "Modelo 1", "Marca X", "1.0", true);	
		Livro l = new Livro(1, "Livro J", 999);
		
		
		/*new GregorianCalendar(2001, 1, 1);*/
		
		System.out.println(t.toString());
		System.out.println("Garantia:" + t.calcular());
		System.out.println();
		System.out.println(l.toString());
	}

}
