package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.impl.JogoDAOImpl;
import br.com.fiap.entity.Jogo;
import br.com.fiap.exception.CommitErrorException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Teste {

	static EntityManagerFactory ef = null;

	public static void main(String[] args) {

		ef = EntityManagerFactorySingleton.getInstance();
		EntityManager em = ef.createEntityManager();
		JogoDAOImpl dao = new JogoDAOImpl(em);

		dao.cadastrar(new Jogo(0, "Uncharted", 99.90, "Ação"));

		Jogo j = dao.buscar(1);

		if (j != null) {
			j.setGenero("Aventura");
			dao.atualizar(j);
		}

		try {
			dao.salvar();
		} catch (CommitErrorException e) {
			e.printStackTrace();
		} finally {

			try {
				// dao.excluir(1);
				dao.salvar();
			} catch (CommitErrorException e) {
				e.printStackTrace();
			}

			if (em.isOpen()) {
				em.close();
			}
			if (ef.isOpen()) {
				ef.close();
			}

		}

	}

}
