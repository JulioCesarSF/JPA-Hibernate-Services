package br.com.fiap.config;

import java.io.IOException;
import java.util.Properties;

public class PropertySingleton {
	
	private static Properties p;
	private static final String ARQ = "/config.properties";
	
	//construtor privado
	private PropertySingleton(){}

	public static Properties getInstance() {
		if (p == null) {
			try {
				//instanciar o prop
				p = new Properties();
				//Carregar as informações do arquivo de propriedades.
				p.load(PropertySingleton.class.getResourceAsStream(ARQ));						
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return p;
	}
}