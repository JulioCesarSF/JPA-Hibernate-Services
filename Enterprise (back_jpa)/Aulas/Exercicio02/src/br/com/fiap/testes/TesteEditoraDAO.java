package br.com.fiap.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.impl.EditoraDAOImpl;
import br.com.fiap.entity.Editora;
import br.com.fiap.exceptions.CodigoInvalidoException;
import br.com.fiap.exceptions.CommitErrorException;
import br.com.fiap.singleton.EMFactory;

public class TesteEditoraDAO implements Runnable {

	private static EntityManagerFactory ef = null;
	private static EntityManager em = null;

	private static EditoraDAOImpl edtDAO = null;

	public TesteEditoraDAO(EntityManagerFactory ef) {
		TesteEditoraDAO.ef = ef;
	}

	@Override
	public void run() {

		ef = EMFactory.getInst();
		em = ef.createEntityManager();

		edtDAO = new EditoraDAOImpl(em);

		Editora edt = new Editora(0, "33.245.603/0001-02", "Editora Julião", "R Haddock Lobo");

		// cadastrar
		edtDAO.cadastrar(edt);
		salvar();

		// buscar
		Editora edt2 = edtDAO.buscar(1);
		System.out.println(edt2);

		// alterar
		edt2.setEndereco("Av. Paulista");
		edtDAO.alterar(edt2);
		salvar();

		// remover
		try {
			edtDAO.excluir(edt2.getId());
			salvar();
		} catch (CodigoInvalidoException e) {
			e.printStackTrace();
		}

		close();

	}

	public static void salvar() {
		try {
			edtDAO.salvar();
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
