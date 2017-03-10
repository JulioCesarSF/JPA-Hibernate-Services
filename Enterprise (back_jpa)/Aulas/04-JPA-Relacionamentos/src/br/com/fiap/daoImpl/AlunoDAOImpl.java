package br.com.fiap.daoImpl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.AlunoDAO;
import br.com.fiap.entity.Aluno;

public class AlunoDAOImpl extends GenericDAOImpl<Aluno, Integer> implements AlunoDAO {

	public AlunoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
