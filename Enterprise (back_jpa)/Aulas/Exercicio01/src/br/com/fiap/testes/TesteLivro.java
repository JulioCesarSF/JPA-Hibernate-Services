package br.com.fiap.testes;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.bo.LivroBO;
import br.com.fiap.entity.Livro;

public class TesteLivro {

	private static EntityManagerFactory f = null;

	public static void main(String[] args) {

		f = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager m = f.createEntityManager();

		Livro l = new Livro(1, "Livro Teste", 99.99, new GregorianCalendar(2016, Calendar.FEBRUARY, 17), new byte[1]);

		if (f.isOpen() && m.isOpen()) {
			try {

				// cadastro : Pre/Post messages
				LivroBO.cadastrar(l, m);

				// busca
				l = LivroBO.buscar(1, m);
				if (l != null) {
					System.out.println(l);
				}
				// alteração
				l.setTitulo("Teste");
				LivroBO.alterar(l, m);
				System.out.println(l);

				// remoção
				LivroBO.remover(1, m);

			} catch (Exception e1) {
				m.getTransaction().rollback();
				e1.printStackTrace();
			} finally {
				try {
					m.close();
					f.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}

}
