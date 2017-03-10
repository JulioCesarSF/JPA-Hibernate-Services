package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.entity.Editora;

public class EditoraDAOImpl extends GenericDAOImpl<Editora, Integer> implements GenericDAO<Editora, Integer> {

	public EditoraDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
