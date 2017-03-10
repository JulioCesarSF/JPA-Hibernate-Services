package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_JOGO")
@SequenceGenerator(name="sqJogo", sequenceName="SQ_JOGO", allocationSize=1)
public class Jogo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CD_JOGO")
	@GeneratedValue(generator="sqJogo", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="DS_TITULO", nullable=false, length=100)
	private String titulo;
	
	@Column(name="VL_JOGO")
	private double preco;
	
	@Column(name="DS_GENERO")
	private String genero;
	
	@PrePersist
	public void adicionando(){
		System.out.println("\nAdicionando jogo [" + this.getClass().getName() + "]\n");
	}
	
	@PostPersist
	public void adicionado(){
		System.out.println("\nJogo adicionado com sucesso.\n");
	}
	
	@PreUpdate
	public void atualizando(){
		System.out.println("\nAtualizando jogo [" + this.getClass().getName() + "]\n");
	}	
	
	@PostUpdate
	public void atualizado(){
		System.out.println("\nJogo atualizado com sucesso.\n");
	}	
	
	@PreRemove
	public void removendo(){
		System.out.println("\nRemovendo jogo [" + this.getClass().getName() + "]\n");
	}
	
	@PostRemove
	public void removido(){
		System.out.println("\nJogo removido com sucesso.\n");
	}

	public Jogo() {
	}

	public Jogo(int codigo, String titulo, double preco, String genero) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.preco = preco;
		this.genero = genero;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public double getPreco() {
		return preco;
	}

	public String getGenero() {
		return genero;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
