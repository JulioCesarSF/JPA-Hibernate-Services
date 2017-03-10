package br.com.fiap.eletro.beans;

import java.io.Serializable;

public class Produto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long codigo;
	private String titulo;
	private double preco;
	public Produto(){}
	
	public Produto(long codigo, String titulo, double preco) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.preco = preco;
	}
	
	public long getCodigo() {
		return codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public double getPreco() {
		return preco;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
}
