package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.entity.Autor;

public class AutorDAOImpl extends GenericDAOImpl<Autor, Integer> implements GenericDAO<Autor, Integer> {

	public AutorDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
