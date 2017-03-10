package br.com.fiap.testes;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.bo.AutorBO;
import br.com.fiap.bo.EditoraBO;
import br.com.fiap.bo.LivroBO;
import br.com.fiap.entity.Autor;
import br.com.fiap.entity.Editora;
import br.com.fiap.entity.Livro;
import br.com.fiap.entity.Sexo;

/*
 * Cadastro de Autor/Editora e Livro
 * 
 * Nos testes individuais tem todos os métodos do DAO
 */

public class TestePersistenciaTodos {

	public static void main(String[] args) {
		EntityManagerFactory f = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");

		if (f.isOpen()) {
			EntityManager m = f.createEntityManager();
			if (m.isOpen()) {
				try {
					cadastrarAutores(m);
					cadastrarEditoras(m);
					cadastrarLivros(m);
				} catch (Exception e) {
					m.getTransaction().rollback();
					e.printStackTrace();					
				} finally {
					m.close();
				}

			}
			f.close();
		}
	}

	private static void cadastrarLivros(EntityManager m) throws Exception {
		LivroBO.cadastrar(
				new Livro(0, "Livro FIAP", 99.99, new GregorianCalendar(2017, Calendar.FEBRUARY, 17), new byte[1]), m);
		LivroBO.cadastrar(
				new Livro(1, "Livro Teste", 199.99, new GregorianCalendar(2017, Calendar.FEBRUARY, 17), new byte[1]),
				m);
		LivroBO.cadastrar(
				new Livro(2, "Livro Julião", 999.99, new GregorianCalendar(2017, Calendar.FEBRUARY, 17), new byte[1]),
				m);
	}

	private static void cadastrarEditoras(EntityManager m) throws Exception {
		EditoraBO.cadastrar(new Editora(0, "91.961.676/0001-05", "Editora FIAP", "Av. Paulista"), m);
		EditoraBO.cadastrar(new Editora(0, "52.212.533/0001-30", "Editora Juliao", "R. Haddock Lobo"), m);
		EditoraBO.cadastrar(new Editora(0, "75.061.232/0001-59", "Editora Teste", "Al. Teste"), m);
	}

	private static void cadastrarAutores(EntityManager m) throws Exception {
		AutorBO.cadastrar(
				new Autor(0, "Julio", Sexo.MASCULINO, "César", new GregorianCalendar(2017, Calendar.FEBRUARY, 17)), m);
		AutorBO.cadastrar(
				new Autor(0, "Maria", Sexo.FEMININO, "Zinha", new GregorianCalendar(2017, Calendar.FEBRUARY, 17)), m);
		AutorBO.cadastrar(
				new Autor(0, "Teste", Sexo.OUTROS, "Teste", new GregorianCalendar(2017, Calendar.FEBRUARY, 17)), m);
	}

}
