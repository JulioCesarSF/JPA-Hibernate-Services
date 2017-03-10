package br.com.fiap.Main;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.fiap.config.PropertySingleton;

public class Main {
	
	private static Logger log = LoggerFactory.getLogger(Main.class); 

	public static void main(String[] args) {
		log.trace("Lendo as informa��es do sistema");
		
		Properties p = PropertySingleton.getInstance();
		
		log.debug("Exibindo o nome e vers�o da aplica��o");
		System.out.println("Aplica��o: " + p.getProperty("application_name") 
				+ " " + p.getProperty("versao"));

	}

}
