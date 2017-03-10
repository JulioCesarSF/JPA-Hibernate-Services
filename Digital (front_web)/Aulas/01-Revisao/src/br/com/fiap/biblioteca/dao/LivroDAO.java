package br.com.fiap.biblioteca.dao;

import java.util.List;

import br.com.fiap.biblioteca.bean.Livro;

public interface LivroDAO {	
	void cadastrar(Livro livro);
	void deletar(long id);
	void alterar(Livro livro);
	Livro procurar(long id);	
	List<Livro> procurar(String titutlo);
}
