package br.com.fiap.testes;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.GrupoDAO;
import br.com.fiap.dao.ProjetoDAO;
import br.com.fiap.daoImpl.GrupoDAOImpl;
import br.com.fiap.daoImpl.ProjetoDAOImpl;
import br.com.fiap.entity.Grupo;
import br.com.fiap.entity.Projeto;
import br.com.fiap.singleton.EMSingleton;

public class Teste1 {

	private static EntityManagerFactory ef;
	private static EntityManager em;

	public static void main(String[] args) {

		ef = EMSingleton.getInst();
		em = ef.createEntityManager();

		GrupoDAO daoG = new GrupoDAOImpl(em);
		ProjetoDAO dao = new ProjetoDAOImpl(em);

		try {
			daoG.cadastrar(new Grupo(0, "GDC"));

			dao.cadastrar(new Projeto(0, "GenericDAO", "Fodao", new GregorianCalendar(2017, Calendar.MARCH, 3),
					new GregorianCalendar(2017, Calendar.MARCH, 4), daoG.buscar(1)));

			dao.salvar();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ef.isOpen()) {
				ef.close();
			}
		}

	}

}
