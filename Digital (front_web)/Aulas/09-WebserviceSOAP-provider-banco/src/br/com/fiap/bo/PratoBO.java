package br.com.fiap.bo;

import javax.persistence.EntityManager;

import org.apache.axis2.AxisFault;

import br.com.fiap.dao.PratoDAO;
import br.com.fiap.dao.impl.PratoDAOImpl;
import br.com.fiap.entity.Prato;
import br.com.fiap.exception.CommitErrorException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class PratoBO {
	 
	public void cadastrar(Prato entity) throws AxisFault{
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		PratoDAO dao = new PratoDAOImpl(em);
		dao.cadastrar(entity);
		try {
			dao.commit();
		} catch (CommitErrorException e) {		
			e.printStackTrace();
			throw new AxisFault("Erro");
		}finally {
			em.close();
		}
	}
	
	public Prato buscar(int id) throws AxisFault{
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		PratoDAO dao = new PratoDAOImpl(em);
		Prato p = null;		
		try {
			p = dao.buscar(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AxisFault("Erro");
		}finally {
			em.close();
		}		
		return p;
	}

}
