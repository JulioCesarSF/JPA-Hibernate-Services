package br.com.fiap.testes;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.impl.AutorDAOImpl;
import br.com.fiap.entity.Autor;
import br.com.fiap.entity.enums.Sexo;
import br.com.fiap.exceptions.CodigoInvalidoException;
import br.com.fiap.exceptions.CommitErrorException;
import br.com.fiap.singleton.EMFactory;

public class TesteAutorDAO implements Runnable {

	private static EntityManagerFactory ef = null;
	private static EntityManager em = null;

	private static AutorDAOImpl aDAO = null;
	

	public TesteAutorDAO(EntityManagerFactory ef) {
		TesteAutorDAO.ef = ef;
	}

	@Override
	public void run() {

		ef = EMFactory.getInst();
		em = ef.createEntityManager();

		aDAO = new AutorDAOImpl(em);

		Autor a = new Autor(0, "Julião", Sexo.MASCULINO, "Schin", new GregorianCalendar(2017, Calendar.OCTOBER, 1987));// cadastrar
		aDAO.cadastrar(a);
		salvar();

		// buscar
		Autor a2 = aDAO.buscar(1);
		System.out.println(a2);

		// alterar
		a2.setSobrenome("Master Race");
		aDAO.alterar(a2);
		salvar();

		// remover
		try {
			aDAO.excluir(a2.getId());
			salvar();
		} catch (CodigoInvalidoException e) {
			e.printStackTrace();
		}

		close();

	}

	public static void salvar() {
		try {
			aDAO.salvar();
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
