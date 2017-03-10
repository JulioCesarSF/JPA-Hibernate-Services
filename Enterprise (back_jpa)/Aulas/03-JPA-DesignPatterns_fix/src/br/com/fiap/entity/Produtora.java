package br.com.fiap.entity;

import java.util.StringJoiner;

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
@Table(name = "TB_PRODUTORA")
@SequenceGenerator(name = "sqProdutora", sequenceName = "SQ_PRODUTORA", allocationSize = 1)
public class Produtora {

	@Id
	@Column(name = "CD_PRODUTORA")
	@GeneratedValue(generator = "sqProdutora", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name = "NM_PRODUTORA", nullable = false)
	private String nome;

	public Produtora() {
	}

	public Produtora(int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return new StringJoiner(",", "[", "]").add("" + this.codigo).add(this.nome).toString();
	}

	@PrePersist
	public void adicionando() {
		System.out.println("\nAdicionando [" + this.getClass().getName() + "]\n");
	}

	@PostPersist
	public void adicionado() {
		System.out.println("\nAdicionado com sucesso.\n");
	}

	@PreUpdate
	public void atualizando() {
		System.out.println("\nAtualizando [" + this.getClass().getName() + "]\n");
	}

	@PostUpdate
	public void atualizado() {
		System.out.println("\nAtualizado com sucesso.\n");
	}

	@PreRemove
	public void removendo() {
		System.out.println("\nRemovendo [" + this.getClass().getName() + "]\n");
	}

	@PostRemove
	public void removido() {
		System.out.println("\nRemovido com sucesso.\n");
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
