package br.com.fiap.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.bo.EditoraBO;
import br.com.fiap.entity.Editora;

public class TesteEditora {

	private static EntityManagerFactory f = null;

	public static void main(String[] args) {

		f = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager m = f.createEntityManager();

		Editora e = new Editora(0, "52.591.594/0001-56", "Editora FIAP", "Av. Paulista");

		if (f.isOpen() && m.isOpen()) {
			try {

				// cadastro : Pre/Post messages
				EditoraBO.cadastrar(e, m);

				// busca
				e = EditoraBO.buscar(1, m);
				if (e != null) {
					System.out.println(e);
				}
				// alteração
				e.setNome("Teste");
				EditoraBO.alterar(e, m);
				System.out.println(e);

				// remoção
				EditoraBO.remover(1, m);

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
