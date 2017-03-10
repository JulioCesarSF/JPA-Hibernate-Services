package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="TB_PRATO")
@SequenceGenerator(name="sqPrato", sequenceName="SQ_PRATO", allocationSize=1)
public class Prato implements Serializable {
	
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CD_PRATO")
	@GeneratedValue(generator="sqPrato", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="NM_NOME", nullable=false)
	private String nome;
	
	@Column(name="DS_DESCRICAO")
	private String descricao;
	
	@Column(name="VL_PRECO", nullable=false)
	private float preco;

	public Prato() {
		super();
	}

	public Prato(int codigo, String nome, String descricao, float preco) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public float getPreco() {
		return preco;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
}
