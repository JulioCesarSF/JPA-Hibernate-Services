package br.com.fiap.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.StringJoiner;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "TB_PROJETO_AM")
@SequenceGenerator(name = "sqProjeto", sequenceName = "SQ_PROJETO", allocationSize = 1)
public class Projeto implements Serializable {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CD_PROJETO")
	@GeneratedValue(generator = "sqProjeto", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "DS_TEMA", nullable = false, length = 100)
	private String tema;

	@Column(name = "DS_OBJETIVO")
	private String objetivo;

	@Column(name = "DT_INICIO", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar dataInicio;

	@Column(name = "DT_TERMINO")
	@Temporal(TemporalType.DATE)
	private Calendar dataTermino;

	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "FK_PROJETO_GRUPO", nullable = false)
	private Grupo grupoAM;

	public Projeto() {
	}

	public Projeto(int id, String tema, String objetivo, Calendar dataInicio, Calendar dataTermino) {
		this.id = id;
		this.tema = tema;
		this.objetivo = objetivo;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
	}

	public Projeto(int id, String tema, String objetivo, Calendar dataInicio, Calendar dataTermino, Grupo grupoAM) {
		this.id = id;
		this.tema = tema;
		this.objetivo = objetivo;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.grupoAM = grupoAM;
	}

	@Override
	public String toString() {
		DateFormat dF = DateFormat.getDateInstance();
		return new StringJoiner(", ", "[ ", " ]")
				.add(String.valueOf(this.id))
				.add(this.tema)
				.add(this.objetivo)
				.add(dF.format(this.dataInicio.getTime()))
				.add(dF.format(this.dataTermino.getTime())).toString();
	}

	public Grupo getGrupoAM() {
		return grupoAM;
	}

	public void setGrupoAM(Grupo grupoAM) {
		this.grupoAM = grupoAM;
	}

	public int getId() {
		return id;
	}

	public String getTema() {
		return tema;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public Calendar getDataTermino() {
		return dataTermino;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public void setDataTermino(Calendar dataTermino) {
		this.dataTermino = dataTermino;
	}

}
