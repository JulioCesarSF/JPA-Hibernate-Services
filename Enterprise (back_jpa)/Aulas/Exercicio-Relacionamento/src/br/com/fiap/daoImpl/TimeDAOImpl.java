package br.com.fiap.daoImpl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.TimeDAO;
import br.com.fiap.entity.Time;

public class TimeDAOImpl extends GenericDAOImpl<Time, Integer> implements TimeDAO {

	public TimeDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
