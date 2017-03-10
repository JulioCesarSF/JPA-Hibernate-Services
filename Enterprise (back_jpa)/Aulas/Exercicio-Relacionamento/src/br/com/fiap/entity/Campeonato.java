package br.com.fiap.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TB_CAMPEONATO")
@SequenceGenerator(allocationSize = 1, name = "sqCampeonato", sequenceName = "SQ_CAMPEONATO")
public class Campeonato implements Serializable {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CD_CAMPEONATO")
	@GeneratedValue(generator = "sqCampeonato", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "NM_CAMPEONATO")
	private String nome;

	@ManyToMany(mappedBy = "campeonatos", cascade = CascadeType.PERSIST)
	private List<Time> times;

	public Campeonato() {
	}

	public Campeonato(int id, String nome) {
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
