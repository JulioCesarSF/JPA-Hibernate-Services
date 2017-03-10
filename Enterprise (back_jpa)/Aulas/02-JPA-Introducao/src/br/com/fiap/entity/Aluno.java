package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="TB_ALUNO")
@SequenceGenerator(name="seqAluno", sequenceName="SQ_ALUNO", allocationSize=1)
public class Aluno implements Serializable {
	
	
	public Aluno(){}	

	public Aluno(int rm, String nome, String cpg, Calendar dataNascimento, Sexo sexo, boolean bolsista, byte[] foto,
			int idade, int senhaAtendimento) {
		super();
		this.rm = rm;
		this.nome = nome;
		this.cpg = cpg;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.bolsista = bolsista;
		this.foto = foto;
		this.idade = idade;
		this.senhaAtendimento = senhaAtendimento;
	}

	

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqAluno")
	private int rm;
	
	@Column(name="NM_ALUNO", nullable=false, length=200)
	private String nome;
	
	private String cpg;
	
	@Column(name="DT_NASCIMENTO")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	
	private Sexo sexo;
	
	private boolean bolsista;
	
	@Lob
	private byte[] foto;
	
	@Transient
	private int idade;
	
	@Transient
	private int senhaAtendimento;
	
	@PrePersist //executa antes da operacao de cadastro
	public void log(){
		System.out.println("Cadastrando um aluno");
	}

	public int getRm() {
		return rm;
	}

	public String getNome() {
		return nome;
	}

	public String getCpg() {
		return cpg;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public boolean isBolsista() {
		return bolsista;
	}

	public byte[] getFoto() {
		return foto;
	}

	public int getIdade() {
		return idade;
	}

	public int getSenhaAtendimento() {
		return senhaAtendimento;
	}

	public void setRm(int rm) {
		this.rm = rm;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpg(String cpg) {
		this.cpg = cpg;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public void setBolsista(boolean bolsista) {
		this.bolsista = bolsista;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void setSenhaAtendimento(int senhaAtendimento) {
		this.senhaAtendimento = senhaAtendimento;
	}
	
	
}
