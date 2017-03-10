package br.com.fiap.biblioteca.bean;

import java.io.Serializable;

public class Livro implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String titulo;
	
	public Livro(){}
	
	public Livro(long id, String titulo) {
		this.id = id;
		this.titulo = titulo;
	}
	public long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
