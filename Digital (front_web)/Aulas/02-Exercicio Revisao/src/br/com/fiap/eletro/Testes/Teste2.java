package br.com.fiap.eletro.Testes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.eletro.beans.Livro;

public class Teste2 {

	public static void main(String[] args) {
		List<Livro> lista = new ArrayList<>();
		
		lista.add(new Livro("J�lio", "Editora Foda", Calendar.getInstance()));
		lista.add(new Livro("J�lio2", "Editora Foda2", Calendar.getInstance()));
		lista.add(new Livro("J�lio3", "Editora Foda3", Calendar.getInstance()));
		
		lista.forEach(System.out::println);
		
	}

}
