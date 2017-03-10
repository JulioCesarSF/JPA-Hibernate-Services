package br.com.fiap.teste;

import org.tempuri.CalcPrecoPrazoWSStub;
import org.tempuri.CalcPrecoPrazoWSStub.ArrayOfCServico;
import org.tempuri.CalcPrecoPrazoWSStub.CServico;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazo;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazoResponse;

public class TesteCorreio {
	
	public static void main(String[] args) {
		try {
			CalcPrecoPrazoWSStub bo = new CalcPrecoPrazoWSStub();
			
			CalcPrazo c = new CalcPrazo();
			c.setNCdServico("40010");
			c.setSCepDestino("01414000");
			c.setSCepOrigem("18603400");
			CalcPrazoResponse resp = bo.calcPrazo(c);
			
			ArrayOfCServico a = resp.getCalcPrazoResult().getServicos();
			
			for (CServico s: a.getCServico()) {
				System.out.println("Código: " + s.getCodigo());
				System.out.println("Entrega domiciliar: " + s.getEntregaDomiciliar());
				System.out.println("Entrega sábado: " + s.getEntregaSabado());
				System.out.println("Prazo: " + s.getPrazoEntrega());
			}			
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}

}
