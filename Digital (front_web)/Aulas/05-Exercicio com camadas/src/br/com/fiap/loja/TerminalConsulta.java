package br.com.fiap.loja;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.fiap.beans.ProdutoTO;
import br.com.fiap.config.PropertySingleton;
import br.com.fiap.estoque.EstoqueBO;

public class TerminalConsulta {

	private static EstoqueBO estoque = new EstoqueBO();

	public static Logger log = LoggerFactory.getLogger(TerminalConsulta.class);

	public static void main(String[] args) {

		try (Scanner t = new Scanner(System.in)) {

			log.warn("Inicio da aplica��o");
			
			init(estoque);

			Properties p = PropertySingleton.getInstance();
			SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

			System.out.println(p.getProperty("application_name") + " " + p.getProperty("versao") + "\t\t\t\t\t"
					+ fmt.format(Calendar.getInstance().getTime())
					+ "\n************************************************************");

			log.debug("Digita��o do c�digo do produto");
			System.out.print("Informe o c�digo do produto: ");
			int codigo = t.nextInt();

			ProdutoTO produto = estoque.consultarProduto(codigo);

			log.debug("Teste de condi��o do produto");
			if (produto != null) {
				log.debug("Produto v�lido");				
				System.out.println(produto);
			} else {
				log.debug("Produto inv�lido");
				log.error("Produto inv�lido/inexistente");
				System.out.println("Produto n�o encontrado!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		log.warn("Fim da aplica��o");
	}

	private static void init(EstoqueBO estoque) {
		ProdutoTO p = new ProdutoTO("Camiseta Masculina Manga Curta Branca.", 401, 123.12, 10);
		estoque.getLista().add(p);
		p = new ProdutoTO("Camiseta Feminina Manga Longa Rosa.", 402, 345.21, 20);
		estoque.getLista().add(p);
	}

}
