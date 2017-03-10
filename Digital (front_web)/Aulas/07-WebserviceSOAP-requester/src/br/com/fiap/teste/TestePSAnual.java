package br.com.fiap.teste;

import br.com.fiap.bo.CursoBOStub;
import br.com.fiap.bo.CursoBOStub.CalcularPSAnual;
import br.com.fiap.bo.CursoBOStub.CalcularPSAnualResponse;

public class TestePSAnual {
	
	public static void main(String[] args) {
		try {
			CursoBOStub bo = new CursoBOStub();
			CalcularPSAnual valores = new CalcularPSAnual();
			valores.setAm(10);	
			valores.setMedia(4);
			valores.setNac(8);
			CalcularPSAnualResponse resp = bo.calcularPSAnual(valores);
			System.out.println("Nota: " + resp.get_return());
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

}
