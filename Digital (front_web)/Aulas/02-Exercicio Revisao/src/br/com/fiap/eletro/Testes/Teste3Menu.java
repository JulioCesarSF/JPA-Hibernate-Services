package br.com.fiap.eletro.Testes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.fiap.eletro.beans.Tablet;

public class Teste3Menu {
	public static void main(String[] args) {		
		
		Scanner t = new Scanner(System.in);		
		List<Tablet> lista = new ArrayList<>();		
		int opcao = 0;
		do{
			opcao = menu(t);
			switch (opcao) {
			case 1:
				lista.add(cadastrar(t));				
				break;

			case 2:
				System.out.println("\nListando Tablets\n");
				lista.forEach(System.out::println);				
				break;

			case 0:
				t.close();
				System.out.println("Fim");
				break;	
			}
		}while(opcao != 0);
	}

	public static int menu(Scanner t) {
		System.out.println("======= MENU =======");
		System.out.println("1-Cadastrar Tablet");
		System.out.println("2-Listar tablets");
		System.out.println("0-Sair");
		System.out.println("====================");
		System.out.print("Opção:");	
		
		return t.nextInt();
	}

	public static Tablet cadastrar(Scanner t) {		
		Tablet tablet = new Tablet();		
		System.out.println("Digite o codigo");
		tablet.setCodigo(t.nextLong());
		System.out.println("Digite o nome do produto");
		tablet.setTitulo(t.next() + t.nextLine());
		System.out.println("Digite o preço");
		tablet.setPreco(t.nextDouble());
		System.out.println("Digite o modelo");
		tablet.setModelo(t.next() + t.nextLine());
		System.out.println("Digite a marca");
		tablet.setMarca(t.next() + t.nextLine());
		System.out.println("Digite o sistema");
		tablet.setOs(t.next() + t.nextLine());
		System.out.println("Tem internet 3g");
		tablet.setInternet3g(t.nextBoolean());
		return tablet;
	}

}
