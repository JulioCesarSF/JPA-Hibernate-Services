package br.com.fiap.testes;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.bo.AutorBO;
import br.com.fiap.entity.Autor;
import br.com.fiap.entity.Sexo;

public class TesteAutor {

	private static EntityManagerFactory f = null;

	public static void main(String[] args) {
		f = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager m = f.createEntityManager();

		Autor a = new Autor(0, "Júlio", Sexo.MASCULINO, "César", new GregorianCalendar(2017, Calendar.FEBRUARY, 17));

		if (f.isOpen() && m.isOpen()) {
			try {
				// cadastro : Pre/Post messages
				AutorBO.cadastrar(a, m);

				// busca
				a = AutorBO.buscar(1, m);
				if (a != null) {
					System.out.println(a);
				}
				// alteração
				a.setNome("Teste");
				AutorBO.alterar(a, m);
				System.out.println(a);

				// remoção
				AutorBO.remover(1, m);

			} catch (Exception e) {
				m.getTransaction().rollback();
				e.printStackTrace();
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
