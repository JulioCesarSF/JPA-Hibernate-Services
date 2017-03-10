package br.com.fiap.entity;

import java.io.Serializable;
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
import javax.persistence.Transient;

@Entity
@Table(name = "T_EDITORA")
@SequenceGenerator(name = "sqEditora", sequenceName = "SQ_EDITORA", allocationSize = 1)
public class Editora implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Transient
	private final String NOME_CLASSE = "Editora";

	public Editora() {
	}

	public Editora(int id, String cnpj, String nome, String endereco) {
		this.id = id;
		this.cnpj = cnpj;
		this.nome = nome;
		this.endereco = endereco;
	}

	@Id
	@Column(name = "CD_EDITORA")
	@GeneratedValue(generator = "sqEditora", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "NR_CNPJ", nullable = false, length = 100)
	private String cnpj;

	@Column(name = "NM_NOME", nullable = false, length = 300)
	private String nome;

	@Column(name = "DS_ENDERECO", length = 400)
	private String endereco;

	@Override
	public String toString() {
		return new StringJoiner(", ", "[ ", " ]").add(String.valueOf(this.id)).add(this.cnpj).add(this.nome)
				.add(this.endereco).toString();
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
	private void preRemove() {
		System.out.println("(-)Removendo " + NOME_CLASSE);
	}

	@PostRemove
	private void postRemove() {
		System.out.println(NOME_CLASSE + " removido.");
	}

	@PreUpdate
	private void preUpdate() {
		System.out.println("(!)Atualizando " + NOME_CLASSE);
	}

	@PostUpdate
	private void postUpdate() {
		System.out.println(NOME_CLASSE + " atualizado.");
	}

	public int getId() {
		return id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getNOME_CLASSE() {
		return NOME_CLASSE;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
