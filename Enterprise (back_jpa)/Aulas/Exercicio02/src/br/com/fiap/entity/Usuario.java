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
@Table(name = "T_USUARIO")
@SequenceGenerator(allocationSize = 1, name = "sqUsuario", sequenceName = "SQ_USUARIO")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Transient
	private final String NOME_CLASSE = "Usuario";

	public Usuario() {
	}

	public Usuario(int id, String nomeUsuario, String nome, String sobrenome, String cpf) {
		this.id = id;
		this.nomeUsuario = nomeUsuario;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
	}

	@Id
	@Column(name = "CD_USUARIO")
	@GeneratedValue(generator = "sqUsuario", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "NM_NOME_USUARIO", nullable = false)
	private String nomeUsuario;

	@Column(name = "NM_NOME", nullable = false, length = 300)
	private String nome;

	@Column(name = "DS_SOBRENOME", length = 300)
	private String sobrenome;

	@Column(name = "NR_CPF", nullable = false, length = 20)
	private String cpf;

	@Override
	public String toString() {
		return new StringJoiner(", ", "[ ", " ]").add(String.valueOf(this.id)).add(this.nomeUsuario).add(this.nome)
				.add(this.sobrenome).add(this.cpf).toString();
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

	public String getNOME_CLASSE() {
		return NOME_CLASSE;
	}

	public int getId() {
		return id;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
