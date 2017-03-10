package br.com.fiap.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.StringJoiner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import javax.persistence.Transient;

import br.com.fiap.entity.enums.Sexo;

@Entity
@Table(name = "T_AUTOR")
@SequenceGenerator(name = "sqAutor", sequenceName = "SQ_AUTOR", allocationSize = 1)
public class Autor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Transient
	private final String NOME_CLASSE = "Autor";

	public Autor() {
	}

	public Autor(int id, String nome, Sexo sexo, String sobrenome, Calendar dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
	}

	@Id
	@Column(name = "CD_AUTOR")
	@GeneratedValue(generator = "sqAutor", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "NM_NOME", nullable = false, length = 300)
	private String nome;

	@Column(name = "DS_SEXO", nullable = false)
	@Enumerated(value = EnumType.ORDINAL)
	private Sexo sexo;

	@Column(name = "DS_SOBRENOME", nullable = false, length = 300)
	private String sobrenome;

	@Column(name = "DT_NASCIMENTO", nullable = false)
	@Temporal(value = TemporalType.DATE)
	private Calendar dataNascimento;

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

	@Override
	public String toString() {
		DateFormat dF = DateFormat.getDateInstance();
		return new StringJoiner(", ", "[ ", " ]").add(String.valueOf(this.id)).add(this.nome)
				.add(String.valueOf(this.sexo)).add(this.sobrenome).add(dF.format(this.dataNascimento.getTime())).toString();
	}

	public String getNOME_CLASSE() {
		return NOME_CLASSE;
	}

	public int getId() {
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

	public void setId(int id) {
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
