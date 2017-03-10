package br.com.fiap.daoImpl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.exceptions.ErroCodigoException;
import br.com.fiap.exceptions.ErroCommitExcetion;

public class GenericDAOImpl<T, K> implements GenericDAO<T, K>{
	
	private EntityManager em;
	@SuppressWarnings("unchecked")
	private Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
			.getActualTypeArguments()[0];

	public GenericDAOImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void cadastrar(T entity) {
		em.persist(entity);		
	}

	@Override
	public void alterar(T entity) {
		em.merge(entity);
	}

	@Override
	public T buscar(K id) throws ErroCodigoException {		
		return em.find(clazz, id);
	}

	@Override
	public void remover(K id) throws ErroCodigoException {
		em.remove(buscar(id));		
	}

	@Override
	public void salvar() throws ErroCommitExcetion {
		em.getTransaction().begin();
		em.getTransaction().commit();	
		System.out.println("Commitou");
		if(em.getTransaction().isActive()){
			em.close();
		}
	}

}
