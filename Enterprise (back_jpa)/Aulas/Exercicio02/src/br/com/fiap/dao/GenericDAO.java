package br.com.fiap.dao;

import br.com.fiap.exceptions.CodigoInvalidoException;
import br.com.fiap.exceptions.CommitErrorException;

public interface GenericDAO<T, K> {

	void cadastrar(T entity);
	void alterar(T entity);
	T buscar(K key);
	void excluir(K key) throws CodigoInvalidoException;
	void salvar() throws CommitErrorException;
	
}
