package br.com.fiap.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.GrupoDAO;
import br.com.fiap.daoImpl.GrupoDAOImpl;
import br.com.fiap.entity.Grupo;
import br.com.fiap.entity.Projeto;
import br.com.fiap.exceptions.ErroCodigoException;
import br.com.fiap.singleton.EMSingleton;

public class TesteBuscarGrupo {
	private static EntityManagerFactory ef;
	private static EntityManager em;

	public static void main(String[] args) {

		ef = EMSingleton.getInst();
		em = ef.createEntityManager();

		GrupoDAO dao = new GrupoDAOImpl(em);

		try {
			Grupo g = dao.buscar(1);
			Projeto p = g.getProjeto();

			System.out.println(g);
			System.out.println(p);
		} catch (ErroCodigoException e) {
			e.printStackTrace();
		} finally {
			if(em.getTransaction().isActive())
				em.close();
			if (ef.isOpen())
				ef.close();
		}

	}
}
