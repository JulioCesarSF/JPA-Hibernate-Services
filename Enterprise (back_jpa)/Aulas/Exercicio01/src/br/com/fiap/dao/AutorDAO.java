package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Autor;

public class AutorDAO implements InterfaceDAO<Autor> {

	EntityManager m = null;

	public AutorDAO() {
	}

	public AutorDAO(EntityManager m) {
		this.m = m;
	}

	@Override
	public void cadastrar(Autor entity) throws Exception {
		if(entity == null)
			return;
		m.getTransaction().begin();
		m.persist(entity);		
		m.getTransaction().commit();
	}

	@Override
	public Autor buscar(long cd) {
		return m.find(Autor.class, cd);
	}

	@Override
	public void remover(long cd) throws Exception {		
		Autor entity = m.find(Autor.class, cd);
		if(entity != null){
			m.getTransaction().begin();
			m.remove(entity);			
			m.getTransaction().commit();
		}		
	}

	@Override
	public void alterar(Autor entity) throws Exception {
		if(entity == null)
			return;
		m.getTransaction().begin();
		m.merge(entity);		
		m.getTransaction().commit();
	}

}
