package br.com.fiap.bo;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EditoraDAO;
import br.com.fiap.entity.Editora;

public class EditoraBO {

	public static void cadastrar(Editora entity, EntityManager m) throws Exception{
		new EditoraDAO(m).cadastrar(entity);
	}
	public static Editora buscar(long cd, EntityManager m){
		return new EditoraDAO(m).buscar(cd);
	}
	
	public static void remover(long cd, EntityManager m) throws Exception{
		new EditoraDAO(m).remover(cd);
	}
	
	public static void alterar(Editora entity, EntityManager m) throws Exception{
		new EditoraDAO(m).alterar(entity);
	}
}
