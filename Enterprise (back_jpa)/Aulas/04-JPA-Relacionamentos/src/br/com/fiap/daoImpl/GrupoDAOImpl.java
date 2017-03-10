package br.com.fiap.daoImpl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GrupoDAO;
import br.com.fiap.entity.Grupo;

public class GrupoDAOImpl extends GenericDAOImpl<Grupo, Integer> implements GrupoDAO {

	public GrupoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
