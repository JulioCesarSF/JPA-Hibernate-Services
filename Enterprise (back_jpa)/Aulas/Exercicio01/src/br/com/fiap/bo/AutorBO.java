package br.com.fiap.bo;

import javax.persistence.EntityManager;

import br.com.fiap.dao.AutorDAO;
import br.com.fiap.entity.Autor;

public abstract class AutorBO {

	public static void cadastrar(Autor entity, EntityManager m) throws Exception{
		new AutorDAO(m).cadastrar(entity);
	}
	public static Autor buscar(long cd, EntityManager m) {
		return new AutorDAO(m).buscar(cd);
	}
	
	public static void remover(long cd, EntityManager m) throws Exception{
		new AutorDAO(m).remover(cd);
	}
	
	public static void alterar(Autor entity, EntityManager m) throws Exception{
		new AutorDAO(m).alterar(entity);
	}	
}
