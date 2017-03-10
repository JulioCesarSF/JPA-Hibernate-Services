package br.com.fiap.daoImpl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.TecnicoDAO;
import br.com.fiap.entity.Tecnico;

public class TecnicoDAOImpl extends GenericDAOImpl<Tecnico, Integer> implements TecnicoDAO{

	public TecnicoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
