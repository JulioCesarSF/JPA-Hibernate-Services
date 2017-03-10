package br.com.fiap.dao;

public interface InterfaceDAO<E> {
	
	void cadastrar(E entity) throws Exception;
	E buscar(long cd);
	void remover(long cd) throws Exception;
	void alterar(E entity) throws Exception;
	
}
