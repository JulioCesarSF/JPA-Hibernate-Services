package br.com.fiap.testes;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.impl.LivroDAOImpl;
import br.com.fiap.entity.Livro;
import br.com.fiap.exceptions.CodigoInvalidoException;
import br.com.fiap.exceptions.CommitErrorException;
import br.com.fiap.singleton.EMFactory;

public class TesteLivroDAO implements Runnable {

	private static EntityManagerFactory ef = null;
	private static EntityManager em = null;

	private static LivroDAOImpl lDAO = null;

	public TesteLivroDAO(EntityManagerFactory ef) {
		TesteLivroDAO.ef = ef;
	}

	@Override
	public void run() {

		ef = EMFactory.getInst();
		em = ef.createEntityManager();

		lDAO = new LivroDAOImpl(em);

		Livro l = new Livro(0, "Livro Java Julião", 99, new GregorianCalendar(2017, Calendar.FEBRUARY, 24),
				new byte[1]);

		// cadastrar
		lDAO.cadastrar(l);
		salvar();

		// buscar
		Livro l2 = lDAO.buscar(1);
		System.out.println(l2);

		// alterar
		l2.setPreco(199);
		lDAO.alterar(l2);
		salvar();

		// remover
		try {
			lDAO.excluir(l2.getIsbn());
			salvar();
		} catch (CodigoInvalidoException e) {
			e.printStackTrace();
		}

		close();

	}

	public static void salvar() {
		try {
			lDAO.salvar();
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
