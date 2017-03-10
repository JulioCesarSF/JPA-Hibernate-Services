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

import br.com.fiap.entity.enums.Status;

@Entity
@Table(name = "T_EXEMPLAR")
@SequenceGenerator(name = "sqExemplar", sequenceName = "SQ_EXEMPLAR", allocationSize = 1)
public class Exemplar implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Transient
	private final String NOME_CLASSE = "Exemplar";

	public Exemplar() {
	}

	public Exemplar(int id, Calendar dataAquisicao, Status situacao) {
		this.id = id;
		this.dataAquisicao = dataAquisicao;
		this.situacao = situacao;
	}

	@Id
	@Column(name = "CD_EXEMPLAR")
	@GeneratedValue(generator = "sqExemplar", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "DT_ARQUISICAO")
	@Temporal(TemporalType.DATE)
	private Calendar dataAquisicao;

	@Column(name = "DS_SITUACAO", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private Status situacao;

	@Override
	public String toString() {
		DateFormat dF = DateFormat.getDateInstance();
		return new StringJoiner(", ", "[ ", " ]").add(String.valueOf(this.id))
				.add(dF.format(this.dataAquisicao.getTime())).add(String.valueOf(this.situacao)).toString();
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

	public Calendar getDataAquisicao() {
		return dataAquisicao;
	}

	public Status getSituacao() {
		return situacao;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDataAquisicao(Calendar dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	public void setSituacao(Status situacao) {
		this.situacao = situacao;
	}

}
