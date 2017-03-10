package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFactory {
	
	private static EntityManagerFactory ef;
	
	private EMFactory(){}
	
	public static EntityManagerFactory getInst(){
		if(ef == null){
			//System.out.println("ef null");
			ef = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		}
		//System.out.println("ef not null");
		return ef;
	}

}
