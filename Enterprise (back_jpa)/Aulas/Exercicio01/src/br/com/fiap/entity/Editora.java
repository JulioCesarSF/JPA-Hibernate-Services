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

@Entity
@Table(name = "T_EDITORA")
@SequenceGenerator(name = "sqEditora", sequenceName = "SQ_EDITORA", allocationSize = 1)
public class Editora implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sqEditora")
	private long id;

	@Column(name = "cnpj", nullable = false, length = 100)
	private String cnpj;

	@Column(name = "nome", nullable = false, length = 300)
	private String nome;

	private String endereco;

	public Editora() {
	}

	public Editora(long id, String cnpj, String nome, String endereco) {
		this.id = id;
		this.cnpj = cnpj;
		this.nome = nome;
		this.endereco = endereco;
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
	public void remover() {
		System.out.println("->Removendo cadastro [" + getClass().getName() + "]\n");
	}

	@PostRemove
	public void removerFeito() {
		System.out.println("->Removido com sucesso!");
	}

	@PreUpdate
	public void alterar() {
		System.out.println("->Efetuando alteração [" + getClass().getName() + "]\n");
	}

	@PostUpdate
	public void alterarFeito() {
		System.out.println("->Alterado com sucesso!");
	}
	
	@Override
	public String toString() {
		return new StringJoiner("\n").add("Id: " + this.id).add("CNPJ: " + this.cnpj).add("Nome: " + this.nome)
				.add("Endereço: " + this.endereco).toString();
	}

	public long getId() {
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

	public void setId(long id) {
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
