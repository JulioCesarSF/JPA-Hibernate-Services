package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TB_TECNICO")
@SequenceGenerator(allocationSize = 1, name = "sqTecnico", sequenceName = "SQ_TECNICO")
public class Tecnico implements Serializable {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CD_TIME")
	@GeneratedValue(generator = "sqTecnico", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "NM_TECNICO")
	private String nome;

	@OneToOne(mappedBy = "tecnico", cascade = CascadeType.PERSIST)
	private Time time;

	public Tecnico() {
	}

	public Tecnico(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
