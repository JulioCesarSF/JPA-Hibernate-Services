package br.com.fiap.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.impl.UsuarioDAOImpl;
import br.com.fiap.entity.Usuario;
import br.com.fiap.exceptions.CodigoInvalidoException;
import br.com.fiap.exceptions.CommitErrorException;
import br.com.fiap.singleton.EMFactory;

public class TesteUsuarioDAO implements Runnable {

	private static EntityManagerFactory ef = null;
	private static EntityManager em = null;

	private static UsuarioDAOImpl uDAO = null;

	public TesteUsuarioDAO(EntityManagerFactory ef) {
		TesteUsuarioDAO.ef = ef;
	}

	@Override
	public void run() {

		ef = EMFactory.getInst();
		em = ef.createEntityManager();

		uDAO = new UsuarioDAOImpl(em);

		Usuario u = new Usuario(0, "JuliaoRox", "Julio", "Cyborg", "111.111.111-00");

		uDAO.cadastrar(u);
		salvar();

		// buscar
		Usuario u2 = uDAO.buscar(1);
		System.out.println(u2);

		// alterar
		u2.setSobrenome("Master Race");
		uDAO.alterar(u2);
		salvar();

		// remover
		try {
			uDAO.excluir(u2.getId());
			salvar();
		} catch (CodigoInvalidoException e) {
			e.printStackTrace();
		}

		close();

	}

	public static void salvar() {
		try {
			uDAO.salvar();
		} catch (CommitErrorException e) {
			e.printStackTrace();
		}
	}

	public static void close() {
		if (em.getTransaction().isActive() || em.isOpen()) {
			em.close();
		}
	}

}
