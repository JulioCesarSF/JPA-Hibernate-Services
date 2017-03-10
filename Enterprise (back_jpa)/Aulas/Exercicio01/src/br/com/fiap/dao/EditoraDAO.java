package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Editora;

public class EditoraDAO implements InterfaceDAO<Editora> {

	EntityManager m = null;
	
	public EditoraDAO(){}
	
	public EditoraDAO(EntityManager m){
		this.m = m;
	}

	@Override
	public void cadastrar(Editora entity) throws Exception {
		if(entity == null)
			return;
		m.getTransaction().begin();
		m.persist(entity);		
		m.getTransaction().commit();
	}

	@Override
	public Editora buscar(long cd) {
		return m.find(Editora.class, cd);	
	}

	@Override
	public void remover(long cd) throws Exception {
		Editora entity = m.find(Editora.class, cd);
		if(entity != null){
			m.getTransaction().begin();
			m.remove(entity);			
			m.getTransaction().commit();
		}			
	}

	@Override
	public void alterar(Editora entity) throws Exception {
		if(entity == null)
			return;
		m.getTransaction().begin();
		m.merge(entity);		
		m.getTransaction().commit();
	}	
}
