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
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_AUTOR")
@SequenceGenerator(name = "sqAutor", sequenceName = "SQ_AUTOR", allocationSize = 1)
public class Autor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "sqAutor", strategy = GenerationType.SEQUENCE)
	private long id;

	@Column(name = "nome", nullable = false, length = 300)
	private String nome;

	@Column(name = "sexo", nullable = false)
	private Sexo sexo;

	@Column(name = "sobrenome", nullable = false, length = 300)
	private String sobrenome;

	@Column(name = "dt_nascimento")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;

	public Autor() {
	}

	public Autor(long id, String nome, Sexo sexo, String sobrenome, Calendar dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
	}

	@PrePersist
	public void cadastro() {
		System.out.println("\n->Efetuando cadastro [" + getClass().getName() + "]\n");
	}

	@PostPersist
	public void cadastroFeito() {
		System.out.println("->Cadastrado com sucesso!");
	}
	
	@PreRemove
	public void remover(){
		System.out.println("\n->Removendo cadastro [" + getClass().getName() + "]\n");
	}
	
	@PostRemove
	public void removerFeito(){
		System.out.println("->Removido com sucesso!");
	}
	
	@PreUpdate
	public void alterar(){
		System.out.println("\n->Efetuando alteração [" + getClass().getName() + "]\n");
	}
	
	@PostUpdate
	public void alterarFeito(){
		System.out.println("->Alterado com sucesso!");
	}

	@Override
	public String toString() {
		DateFormat dF = DateFormat.getDateInstance();
		return new StringJoiner("\n").add("Id: " + this.id).add("Nome: " + this.nome).add("Sobrenome: " + this.sobrenome)
				.add("Sexo: " + this.sexo).add("Data Nascimento: " + dF.format(this.dataNascimento.getTime()))
				.toString();
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
