package br.com.fiap.teste;

import br.com.fiap.bo.PratoBOStub;
import br.com.fiap.bo.PratoBOStub.Cadastrar;
import br.com.fiap.bo.PratoBOStub.Prato;

public class TesteCadastro {
	
	/*
	 * 1- Instanciar o stub
	 * 2- Instanciar a classe que possui o mesmo nome do metodo
	 * 3- Chamar o método do stub
	 * 4- Recuperar  response
	 */

	public static void main(String[] args) {
		
		try {
			PratoBOStub stub = new PratoBOStub();
			//valores para o webservice
			Cadastrar params = new Cadastrar();
			Prato prato = new Prato();
			prato.setDescricao("Feijoada completa");
			prato.setNome("Feijoada");
			prato.setPreco(30);
			params.setEntity(prato);
			
			stub.cadastrar(params);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

}
