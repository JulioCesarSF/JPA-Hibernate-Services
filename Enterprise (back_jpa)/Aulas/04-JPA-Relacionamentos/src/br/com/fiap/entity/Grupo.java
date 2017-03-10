package br.com.fiap.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TB_GRUPO_AM")
@SequenceGenerator(name = "sqGrupo", sequenceName = "SQ_GRUPO_AM", allocationSize = 1)
public class Grupo implements Serializable {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CD_GRUPO")
	@GeneratedValue(generator = "sqGrupo", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "NM_GRUPO", nullable = false, length = 150)
	private String nome;

	@OneToOne(mappedBy = "grupoAM", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	// mapear relacionamento já existente
	// pelo mappedB (passa o nome do atributo no parametro)
	// fetch lazy: divide os selects..
	private Projeto projeto;

	@OneToMany(mappedBy = "grupoAM", cascade = CascadeType.PERSIST)
	private List<Aluno> alunos = new ArrayList<>();

	// Método para adicionar alunos
	public void addAluno(Aluno aluno) {
		// add aluno na lista
		this.alunos.add(aluno);
		// setar o grupo do aluno
		aluno.setGrupoAM(this);
	}

	public Grupo() {
	}

	public Grupo(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", "[ ", " ]").add(String.valueOf(this.id)).add(this.nome).toString();
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

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
}
