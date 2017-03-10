package br.com.fiap.testes;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.impl.ExemplarDAOImpls;
import br.com.fiap.entity.Exemplar;
import br.com.fiap.entity.enums.Status;
import br.com.fiap.exceptions.CodigoInvalidoException;
import br.com.fiap.exceptions.CommitErrorException;
import br.com.fiap.singleton.EMFactory;

public class TesteExemplarDAO implements Runnable {

	private static EntityManagerFactory ef = null;
	private static EntityManager em;

	private static ExemplarDAOImpls eDAO = null;

	public TesteExemplarDAO(EntityManagerFactory ef) {
		TesteExemplarDAO.ef = ef;
	}

	@Override
	public void run() {

		ef = EMFactory.getInst();
		em = ef.createEntityManager();

		eDAO = new ExemplarDAOImpls(em);

		Exemplar ex = new Exemplar(0, new GregorianCalendar(2017, Calendar.FEBRUARY, 25), Status.DISPONIVEL);

		// cadastrar
		eDAO.cadastrar(ex);
		salvar();

		// buscar
		Exemplar ex2 = eDAO.buscar(1);
		System.out.println(ex2);

		// alterar
		ex2.setSituacao(Status.MANUTENCAO);
		eDAO.alterar(ex2);
		salvar();

		// remover
		try {
			eDAO.excluir(ex2.getId());
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
