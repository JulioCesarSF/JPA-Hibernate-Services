package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TB_JOGADOR")
@SequenceGenerator(allocationSize = 1, name = "sqJogador", sequenceName = "SQ_JOGADOR")
public class Jogador implements Serializable {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CD_JOGADOR")
	@GeneratedValue(generator = "sqJogador", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "NM_JOGADOR")
	private String nome;

	@ManyToOne
	@JoinColumn(name = "CD_TIME")
	private Time time;

	public Jogador() {
	}

	public Jogador(int id, String nome, Time time) {
		this.id = id;
		this.nome = nome;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Time getTime() {
		return time;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTime(Time time) {
		this.time = time;
	}

}
