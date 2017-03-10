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
import javax.persistence.Transient;

@Entity
@Table(name = "T_EMPRESTIMO")
@SequenceGenerator(allocationSize = 1, name = "sqEmprestimo", sequenceName = "SQ_EMPRESTIMO")
public class Emprestimo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Transient
	private final String NOME_CLASSE = "Emprestimo";

	public Emprestimo() {
	}

	public Emprestimo(int id, Calendar dataEmprestimo, Calendar dataRetorno) {
		this.id = id;
		this.dataEmprestimo = dataEmprestimo;
		this.dataRetorno = dataRetorno;
	}

	@Id
	@Column(name = "CD_EMPRESTIMO")
	@GeneratedValue(generator = "sqEmprestimo", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "DT_EMPRESTIMO", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar dataEmprestimo;

	@Column(name = "DT_RETORNO", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar dataRetorno;

	@Override
	public String toString() {
		DateFormat dF = DateFormat.getDateInstance();
		return new StringJoiner(", ", "[ ", " ]").add(String.valueOf(this.id))
				.add(dF.format(this.dataEmprestimo.getTime())).add(dF.format(this.dataRetorno.getTime())).toString();
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

	public Calendar getDataEmprestimo() {
		return dataEmprestimo;
	}

	public Calendar getDataRetorno() {
		return dataRetorno;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDataEmprestimo(Calendar dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public void setDataRetorno(Calendar dataRetorno) {
		this.dataRetorno = dataRetorno;
	}
}
