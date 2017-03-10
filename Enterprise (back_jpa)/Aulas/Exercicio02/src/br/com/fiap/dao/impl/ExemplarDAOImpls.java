package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.entity.Exemplar;

public class ExemplarDAOImpls extends GenericDAOImpl<Exemplar, Integer> implements GenericDAO<Exemplar, Integer> {

	public ExemplarDAOImpls(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
