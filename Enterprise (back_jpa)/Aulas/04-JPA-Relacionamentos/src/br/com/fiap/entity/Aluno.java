package br.com.fiap.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TB_ALUNO")
@SequenceGenerator(allocationSize = 1, name = "sqAluno", sequenceName = "SQ_ALUNO")
public class Aluno implements Serializable {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CD_RM_ALUNO")
	@GeneratedValue(generator = "sqAluno", strategy = GenerationType.SEQUENCE)
	private int rm;

	@Column(name = "NM_ALUNO", nullable = false)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="FK_ALUNO_GRUPO")
	private Grupo grupoAM;
	
	@ManyToMany(mappedBy="alunos", cascade=CascadeType.PERSIST)
	private List<Disciplina> disciplinas;	
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public Grupo getGrupoAM() {
		return grupoAM;
	}

	public void setGrupoAM(Grupo grupoAM) {
		this.grupoAM = grupoAM;
	}	

	public Aluno() {
	}

	public Aluno(int rm, String nome) {
		this.rm = rm;
		this.nome = nome;
	}

	public Aluno(int rm, String nome, Grupo grupoAM) {
		this.rm = rm;
		this.nome = nome;
		this.grupoAM = grupoAM;
	}

	public int getRm() {
		return rm;
	}

	public String getNome() {
		return nome;
	}

	public void setRm(int rm) {
		this.rm = rm;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
