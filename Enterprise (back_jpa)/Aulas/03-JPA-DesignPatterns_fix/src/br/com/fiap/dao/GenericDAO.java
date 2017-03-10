package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.exception.CodigoInvalidoException;
import br.com.fiap.exception.CommitErrorException;

public interface GenericDAO<T, K> {

	void cadastrar(T entity);

	void atualizar(T entity);

	T buscar(K cd);

	void excluir(K cd) throws CodigoInvalidoException;
	
	void salvar() throws CommitErrorException;
	
	EntityManager getEm();
}
