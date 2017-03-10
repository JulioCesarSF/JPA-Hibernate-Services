package br.com.fiap.main;

import java.lang.reflect.Method;

import br.com.fiap.annotation.Banco;
import br.com.fiap.annotation.Tabela;
import br.com.fiap.beans.Aluno;
import br.com.fiap.connection.ConnectionFactory;

public class Teste {

	public static void main(String[] args) {
		// Recuperar a anota��o da classe de conex�o

		// API de Reflection
		// Recuperar a estrtura da clase tentar recuperar a anota��o dela
		Banco anotacao = ConnectionFactory.class.getAnnotation(Banco.class);
		System.out.println("Usu�rio: " + anotacao.usuario());
		System.out.println("Senha: " + anotacao.senha());

		// Recuperar anotacao de m�todo
		Method[] m = ConnectionFactory.class.getDeclaredMethods();
		for (Method mm : m) {
			System.out.println("Usu�rio: " + mm.getAnnotation(Banco.class).usuario() + " Senha: "
					+ mm.getAnnotation(Banco.class).senha());
		}

		System.out.println("SELECT * FROM " + Aluno.class.getAnnotation(Tabela.class).nome());
	}

}
