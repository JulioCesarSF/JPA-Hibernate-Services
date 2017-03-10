package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.entity.Emprestimo;

public class EmprestimoDAOImpl extends GenericDAOImpl<Emprestimo, Integer> implements GenericDAO<Emprestimo, Integer> {

	public EmprestimoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
