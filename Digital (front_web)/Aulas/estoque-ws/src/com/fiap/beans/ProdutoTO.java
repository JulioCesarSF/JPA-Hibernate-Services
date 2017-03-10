package com.fiap.beans;

import java.io.Serializable;
import java.text.NumberFormat;

@SuppressWarnings("serial")
public class ProdutoTO implements Serializable {
	
	private String nome;
	private int codigo;
	private double valor;
	private int quantidade;
	
	public ProdutoTO(){}
	
	public ProdutoTO(String nome, int codigo, double valor, int quantidade) {		
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.valor = valor;
		this.quantidade = quantidade;
	}
	
	@Override
	public String toString() {
		NumberFormat nF = NumberFormat.getCurrencyInstance();
		return "Código: " + this.codigo + "\tNome: " 
				+ this.nome + "\nQuantidade: " + this.quantidade + "\tValor: " + nF.format(this.valor);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getValor() {
		return valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}
