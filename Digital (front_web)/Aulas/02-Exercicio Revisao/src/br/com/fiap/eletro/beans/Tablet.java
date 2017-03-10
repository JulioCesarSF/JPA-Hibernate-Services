package br.com.fiap.eletro.beans;

import br.com.fiap.eletro.inter.Eletronico;

public class Tablet extends Produto implements Eletronico{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String modelo, marca, os;
	private boolean internet3g;
	
	public Tablet(){}
	
	public Tablet(long codigo, String titulo, double preco) {
		super(codigo, titulo, preco);		
	}
	
	@Override
	public String toString() {
		return "Modelo:" + getModelo() + "\nMarca:" + getMarca() + "\nOS:"+getOs() + "\n3G:" + isInternet3g();
	}
	
	public Tablet(long codigo, String titulo, double preco, String modelo, String marca, String os, boolean internet3g) {
		super(codigo, titulo, preco);	
		this.modelo = modelo;
		this.marca = marca;
		this.os = os;
		this.internet3g = internet3g;
	}
	
	public Tablet(String modelo, String marca, String os, boolean internet3g) {
		this.modelo = modelo;
		this.marca = marca;
		this.os = os;
		this.internet3g = internet3g;
	}
	public String getModelo() {
		return modelo;
	}
	public String getMarca() {
		return marca;
	}
	public String getOs() {
		return os;
	}
	public boolean isInternet3g() {
		return internet3g;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public void setInternet3g(boolean internet3g) {
		this.internet3g = internet3g;
	}

	@Override
	public double calcular() {
		return this.getPreco() * 0.05;		
	}
	
	
}
