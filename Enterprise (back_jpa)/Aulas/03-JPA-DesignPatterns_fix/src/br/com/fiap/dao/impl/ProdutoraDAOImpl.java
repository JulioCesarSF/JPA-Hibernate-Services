package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ProdutoraDAO;
import br.com.fiap.entity.Produtora;

public class ProdutoraDAOImpl extends GenericDAOImpl<Produtora, Integer> implements ProdutoraDAO {

	public ProdutoraDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
}
