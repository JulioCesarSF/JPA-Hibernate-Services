package br.com.fiap.testes;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.impl.EmprestimoDAOImpl;
import br.com.fiap.entity.Emprestimo;
import br.com.fiap.exceptions.CodigoInvalidoException;
import br.com.fiap.exceptions.CommitErrorException;
import br.com.fiap.singleton.EMFactory;

public class TesteEmprestimoDAO implements Runnable {

	private static EntityManagerFactory ef = null;
	private static EntityManager em = null;

	private static EmprestimoDAOImpl eDAO = null;

	public TesteEmprestimoDAO(EntityManagerFactory ef) {
		TesteEmprestimoDAO.ef = ef;
	}

	@Override
	public void run() {

		ef = EMFactory.getInst();
		em = ef.createEntityManager();

		eDAO = new EmprestimoDAOImpl(em);

		Emprestimo e1 = new Emprestimo(0, new GregorianCalendar(2017, Calendar.FEBRUARY, 24),
				new GregorianCalendar(2017, Calendar.FEBRUARY, 25));

		eDAO.cadastrar(e1);
		salvar();

		// buscar
		Emprestimo e2 = eDAO.buscar(1);
		System.out.println(e2);

		// alterar
		e2.setDataRetorno(new GregorianCalendar(2017, Calendar.FEBRUARY, 26));
		eDAO.alterar(e2);
		salvar();

		// remover
		try {
			eDAO.excluir(e2.getId());
			salvar();
		} catch (CodigoInvalidoException e) {
			e.printStackTrace();
		}

		close();

	}

	public static void salvar() {
		try {
			eDAO.salvar();
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
