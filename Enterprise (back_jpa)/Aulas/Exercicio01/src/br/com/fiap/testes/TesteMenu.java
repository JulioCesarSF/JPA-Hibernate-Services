package br.com.fiap.testes;

import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.StringJoiner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.bo.LivroBO;
import br.com.fiap.entity.Autor;
import br.com.fiap.entity.Editora;
import br.com.fiap.entity.Livro;

/*
 * SOMENTE O MENU DO LIVRO COM CADASTRO, PESQUISA E REMOÇÃO FORAM IMPLEMENTADOS
 * Não implementei todos ... 
 */

public class TesteMenu {
	
	private static Scanner t;
	private static EntityManagerFactory f = null;
	
	public static void main(String[] args) throws Exception {
		
		t = new Scanner(System.in);
		
		f = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		if(f.isOpen()){
			
			EntityManager m = f.createEntityManager();
			
			if(m.isOpen()){
				
				int codigo = 99;
				int codigoB = 99;
				
				do{
					
					displayMenu();
					System.out.println("Opção:\t");
					codigo = t.nextInt();
					
					switch (codigo) {
					case 1:
						codigoB = displayOpcoes(t);
						operacao(m, t, codigo, codigoB);
						break;

					default:
						break;
					}
					
				}while(codigo != 0);
				
				
				m.close();
			}
			
			f.close();
			
		}
		
		t.close();
		
	}
	
	public static void displayMenu(){
		StringJoiner s = new StringJoiner("\n");
		s.add("1-Livro").add("2-Editora").add("3-Autor").add("0-Sair");
		System.out.println(s.toString());
	}
	
	public static int displayOpcoes(Scanner t){
		StringJoiner s = new StringJoiner("\n");
		s.add("1-Cadastrar").add("2-Remover").add("3-Pesquisar").add("4-Voltar");
		System.out.println(s.toString());
		System.out.println("Opção:\t");
		return t.nextInt();
	}
	
	public static int operacao(EntityManager m, Scanner t, int codigo, int codigoB) throws Exception{
		Livro l = null;
		Editora e = null;
		Autor a = null;
		long isbn = 0;
		
		if(codigo == 1){ //livro
			switch (codigoB) {
			case 1: //cadastrar
				l = new Livro();
				System.out.println("ISBN: ");
				l.setIsbn(t.nextLong());
				System.out.println("Título: ");
				l.setTitulo(t.next() + t.nextLine());
				System.out.println("Preço: ");
				l.setPreco(t.nextDouble());
				System.out.println("Data de lançamento: ");
				System.out.println("Dia: ");
				int dia = t.nextInt();
				System.out.println("Mes (numero)");
				int mes = t.nextInt();
				System.out.println("Ano: ");
				int ano = t.nextInt();
				l.setDataLancamento(new GregorianCalendar(ano, mes, dia));
				l.setCapa(new byte[1]);				
				LivroBO.cadastrar(l, m);
				break;
				
			case 2:
				System.out.println("Digite o ISBN: ");
				isbn = t.nextLong();
				
				l = LivroBO.buscar(isbn, m);
				if(l == null){
					System.out.println("Livro não encontrado!");
				}else{
					LivroBO.remover(isbn, m);
				}
				break;
				
			case 3:
				System.out.println("Digite o ISBN: ");
				isbn = t.nextLong();
				
				l = LivroBO.buscar(isbn, m);
				if(l == null){
					System.out.println("Livro não encontrado!");
				}else{
					System.out.println(l);
				}
				break;

			default:
				break;
			}
		}else
			return 4;
		
		
		return 0;
	}

}
