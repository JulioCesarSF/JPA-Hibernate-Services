package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.JogoDAO;
import br.com.fiap.entity.Jogo;
import br.com.fiap.exception.CodigoInvalidoException;
import br.com.fiap.exception.CommitErrorException;

public class JogoDAOImpl extends GenericDAOImpl<Jogo, Integer> implements JogoDAO {

	public JogoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
}
