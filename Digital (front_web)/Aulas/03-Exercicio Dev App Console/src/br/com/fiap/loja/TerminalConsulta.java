package br.com.fiap.loja;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class TerminalConsulta {

	public static void main(String[] args) {
		try (Scanner t = new Scanner(System.in)) {
			SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
			
			System.out.println("FIAP\t\t\t\t\t\t" + fmt.format(Calendar.getInstance().getTime())
					+ "\n************************************************************");

			System.out.print("Informe o c�digo do produto: ");
			int codigo = t.nextInt();

			String texto = new String("Produto n�o encontrado!");

			switch (codigo) {
			case 401:
				texto = "Camiseta Masculina Manga Curta Branca.";
				break;

			case 402:
				texto = "Camiseta Feminina Manga Longa Rosa.";
				break;

			default:
				break;
			}

			System.out.println("Descri��o: " + texto);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
