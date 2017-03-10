package br.com.fiap.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.StringJoiner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * ISBN não é sequencia pois é um número próprio de cada livro.
 * 
 * 
 */

@Entity
@Table(name = "T_LIVRO")
public class Livro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private long isbn;

	@Column(name = "titulo", nullable = false, length = 200)
	private String titulo;

	private double preco;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_lancamento", updatable = false)
	private Calendar dataLancamento;

	@Lob
	private byte[] capa;

	public Livro() {
	}

	public Livro(long isbn, String titulo, double preco, Calendar dataLancamento, byte[] capa) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.preco = preco;
		this.dataLancamento = dataLancamento;
		this.capa = capa;
	}

	@PrePersist
	public void cadastro() {
		System.out.println("->Efetuando cadastro [" + getClass().getName() + "]\n");
	}

	@PostPersist
	public void cadastroFeito() {
		System.out.println("->Cadastrado com sucesso!");
	}
	
	@PreRemove
	public void remover(){
		System.out.println("->Removendo cadastro [" + getClass().getName() + "]\n");
	}
	
	@PostRemove
	public void removerFeito(){
		System.out.println("->Removido com sucesso!");
	}
	
	@PreUpdate
	public void alterar(){
		System.out.println("->Efetuando alteração [" + getClass().getName() + "]\n");
	}
	
	@PostUpdate
	public void alterarFeito(){
		System.out.println("->Alterado com sucesso!");
	}

	@Override
	public String toString() {
		DateFormat dF = DateFormat.getDateInstance();
		return new StringJoiner("\n").add("ISBN: " + String.valueOf(this.isbn)).add("Título: " + this.titulo)
				.add("Preço: " + String.valueOf(this.preco))
				.add("Data Lançamento: " + dF.format(this.dataLancamento.getTime())).toString();
	}

	public long getIsbn() {
		return isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public double getPreco() {
		return preco;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public byte[] getCapa() {
		return capa;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public void setCapa(byte[] capa) {
		this.capa = capa;
	}

}
