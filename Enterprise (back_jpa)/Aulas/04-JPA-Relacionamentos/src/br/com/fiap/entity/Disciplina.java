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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="TB_DISCIPLINA")
@SequenceGenerator(allocationSize=1, name="sqDisciplina", sequenceName="SQ_DISCIPLINA")
public class Disciplina implements Serializable{
	
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="sqDisciplina", strategy=GenerationType.SEQUENCE)
	@Column(name="CD_DISCIPLINA")
	private int id;
	
	@Column(name="NM_DISCIPLINA", nullable=false, length=100)
	private String nome;
	
	@Column(name="NR_CARGA_HORARIA", nullable=false)	
	private int cargaHorario;
	
	@Column(name="DS_DESCRICAO")
	private String descricao;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="TB_DISCIPLINA_ALUNO",
	joinColumns={@JoinColumn(name="CD_ALUNO")}, 
	inverseJoinColumns={@JoinColumn(name="CD_DISCIPLINA")})
	private List<Aluno> alunos;

	public Disciplina() {
	}
	
	public Disciplina(int id, String nome, int cargaHorario, String descricao) {
		this.id = id;
		this.nome = nome;
		this.cargaHorario = cargaHorario;
		this.descricao = descricao;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getCargaHorario() {
		return cargaHorario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCargaHorario(int cargaHorario) {
		this.cargaHorario = cargaHorario;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
