package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.exceptions.CodigoInvalidoException;
import br.com.fiap.exceptions.CommitErrorException;

public class GenericDAOImpl<T, K> implements GenericDAO<T, K> {

	private EntityManager em;
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		this.clazz = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
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
	public T buscar(K key) {		
		return em.find(clazz, key);
	}

	@Override
	public void excluir(K key) throws CodigoInvalidoException {
		em.remove(buscar(key));		
	}

	@Override
	public void salvar() throws CommitErrorException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			if(em.getTransaction().isActive()){
				em.getTransaction().rollback();
			}
			e.printStackTrace();
			throw new CommitErrorException("Erro no commit");
		}		
	}

}
