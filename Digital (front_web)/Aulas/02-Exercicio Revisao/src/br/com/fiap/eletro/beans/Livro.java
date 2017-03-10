package br.com.fiap.eletro.beans;

import java.util.Calendar;

public class Livro extends Produto {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String autor, editora;
	private Calendar data_lancamento;

	public Livro() {
		super();

	}

	public Livro(long codigo, String titulo, double preco) {
		super(codigo, titulo, preco);
	}

	public Livro(String autor, String editora, Calendar data_lancamento) {
		super();
		this.autor = autor;
		this.editora = editora;
		this.data_lancamento = data_lancamento;
	}

	public String getAutor() {
		return autor;
	}

	public String getEditora() {
		return editora;
	}

	public Calendar getData_lancamento() {
		return data_lancamento;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public void setData_lancamento(Calendar data_lancamento) {
		this.data_lancamento = data_lancamento;
	}

	/*
	 * SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
	 * fmt.format(data_lancamento);
	 */

	@Override
	public String toString() {
		return "Autor:" + getAutor() + "\nEditora:" + getEditora() + "\nData:" + getData_lancamento().getTime()
				+ "\nCódigo:" + getCodigo() + "\nTitulo:" + getTitulo() + "\nPreço:" + getPreco();
	}

}
