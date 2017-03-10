package br.com.fiap.dao;

import br.com.fiap.exceptions.ErroCodigoException;
import br.com.fiap.exceptions.ErroCommitExcetion;

public interface GenericDAO<T, K> {
	void cadastrar(T entity);
	void alterar(T entity);
	T buscar(K id) throws ErroCodigoException;
	void remover(K id) throws ErroCodigoException;
	
	void salvar() throws ErroCommitExcetion;
}
