package br.com.fiap.teste;

import br.com.fiap.bo.CursoBOStub;
import br.com.fiap.bo.CursoBOStub.CalcularMedia;
import br.com.fiap.bo.CursoBOStub.CalcularMediaResponse;

public class CursoTeste {

	public static void main(String[] args) {

		try {
			CursoBOStub bo = new CursoBOStub();
			CalcularMedia valores = new CalcularMedia();
			valores.setNac(8);
			valores.setAm(7);
			valores.setPs(9);
			CalcularMediaResponse resp = bo.calcularMedia(valores);
			float nota = resp.get_return();
			System.out.println("Média:" + nota);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
