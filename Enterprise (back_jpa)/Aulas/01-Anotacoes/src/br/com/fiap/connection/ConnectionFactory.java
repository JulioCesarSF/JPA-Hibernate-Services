package br.com.fiap.connection;

import br.com.fiap.annotation.Banco;

@Banco(usuario="julio", senha="1234")
public class ConnectionFactory {
	
	@Banco(usuario="Fiap", senha="1234")
	public void conectarOracle(){}
	
	@Banco(usuario="admin", senha="1234")
	public void conectarMySql(){}
	
	//vai usar o @Banco julio, 1234
	public void conectarDefault(){}

}
