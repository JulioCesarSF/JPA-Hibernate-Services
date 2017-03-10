package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="TB_CURSO")
@SequenceGenerator(name="seqCurso", sequenceName="SQ_CURSO", allocationSize=1)
public class Curso implements Serializable{
	
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="seqCurso", strategy=GenerationType.SEQUENCE)
	@Column(name="CD_CURSO", nullable=false)
	private int id;
	
	@Column(name="NM_CURSO", nullable=false)
	private String nomeCurso;
	
	@Column(name="NR_HORA")
	private int nHora;
	
	@Column(name="VL_PRECO", nullable=false)
	private double valor;
	
	@Column(name="DS_CURSO")
	private String descricao;
	
	@Column(name="DT_INICIO")
	@Temporal(TemporalType.DATE)
	private Calendar dataInicio;
	
	@Column(name="DS_TIPO")
	private TipoCurso tipoCurso;

	public int getId() {
		return id;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public int getnHora() {
		return nHora;
	}

	public double getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public TipoCurso getTipoGraducao() {
		return tipoCurso;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public void setnHora(int nHora) {
		this.nHora = nHora;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public void setTipoGraducao(TipoCurso tipoGraducao) {
		this.tipoCurso = tipoGraducao;
	}
	
	

}
