package br.com.fiap.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.StringJoiner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
//import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "T_LIVRO")
@SequenceGenerator(name = "sqLivro", sequenceName = "SQ_LIVRO", allocationSize = 1)
public class Livro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Transient
	private final String NOME_CLASSE = "Livro";

	public Livro() {
	}

	public Livro(int isbn, String titulo, double preco, Calendar dataLancamento, byte[] capa) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.preco = preco;
		this.dataLancamento = dataLancamento;
		this.capa = capa;
	}

	@Id
	@Column(name = "CD_ISBN", nullable = false)
	@GeneratedValue(generator = "sqLivro", strategy = GenerationType.SEQUENCE)
	private int isbn;

	@Column(name = "NM_TITULO", nullable = false, length = 200)
	private String titulo;

	@Column(name = "VL_PRECO")
	private double preco;

	@Column(name = "DT_LANCAMENTO")
	@Temporal(TemporalType.DATE)
	private Calendar dataLancamento;

	@Lob
	@Column(name = "BL_CAPA")
	private byte[] capa;
	
	@Override
	public String toString() {
		DateFormat dF = DateFormat.getDateInstance();
		return new StringJoiner(", ", "[ ", " ]").add(String.valueOf(this.isbn)).add(this.titulo)
				.add(String.valueOf(this.preco)).add(dF.format(this.dataLancamento.getTime())).toString();
	}

	@PrePersist
	private void prePersist() {
		System.out.println("(+)Adicionando " + NOME_CLASSE);
	}

	@PostPersist
	private void postPersist() {
		System.out.println(NOME_CLASSE + " adicionado.");
	}
	
	@PreRemove
	private void preRemove(){
		System.out.println("(-)Removendo " + NOME_CLASSE);
	}
	
	@PostRemove
	private void postRemove(){
		System.out.println(NOME_CLASSE + " removido.");
	}
	
	@PreUpdate
	private void preUpdate(){
		System.out.println("(!)Atualizando " + NOME_CLASSE);
	}
	
	@PostUpdate
	private void postUpdate(){
		System.out.println(NOME_CLASSE + " atualizado.");
	}

	public int getIsbn() {
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

	public String getNOME_CLASSE() {
		return NOME_CLASSE;
	}

	public void setIsbn(int isbn) {
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
