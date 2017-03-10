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

			System.out.print("Informe o código do produto: ");
			int codigo = t.nextInt();

			String texto = new String("Produto não encontrado!");

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

			System.out.println("Descrição: " + texto);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
