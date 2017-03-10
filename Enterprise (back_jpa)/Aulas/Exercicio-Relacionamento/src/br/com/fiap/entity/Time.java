package br.com.fiap.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "TB_TIME")
@SequenceGenerator(allocationSize = 1, name = "sqTime", sequenceName = "SQ_TIME")
public class Time implements Serializable {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CD_TIME")
	@GeneratedValue(generator = "sqTime", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "NM_TIME")
	private String nome;

	@Column(name = "DT_FUNDACAO")
	@Temporal(TemporalType.DATE)
	private Calendar dataFundacao;

	@Column(name = "NR_TITULO")
	private int nrTitulo;

	// mapear time->tecnico 1-1
	@OneToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "TB_TIME_TB_TECNICO_FK", nullable = false)
	private Tecnico tecnico;

	// mapear time->jogadores 1-n
	@OneToMany(mappedBy = "time", cascade = CascadeType.PERSIST)
	List<Jogador> jogadores = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "TB_TIME_CAMPEONATO", 
	joinColumns = { @JoinColumn(name = "CD_CAMPEONATO") }, 
	inverseJoinColumns = { @JoinColumn(name = "CD_TIMEv2") })
	List<Campeonato> campeonatos;

	public Time() {
	}

	public Time(int id, String nome, Calendar dataFundacao, int nrTitulo, Tecnico tecnico) {
		this.id = id;
		this.nome = nome;
		this.dataFundacao = dataFundacao;
		this.nrTitulo = nrTitulo;
		this.tecnico = tecnico;
	}

	public List<Campeonato> getCampeonatos() {
		return campeonatos;
	}

	public void setCampeonatos(List<Campeonato> campeonatos) {
		this.campeonatos = campeonatos;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Calendar getDataFundacao() {
		return dataFundacao;
	}

	public int getNrTitulo() {
		return nrTitulo;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDataFundacao(Calendar dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public void setNrTitulo(int nrTitulo) {
		this.nrTitulo = nrTitulo;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

}
