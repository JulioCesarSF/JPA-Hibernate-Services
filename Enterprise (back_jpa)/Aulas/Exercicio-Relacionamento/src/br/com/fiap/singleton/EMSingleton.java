package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMSingleton {

	private static EntityManagerFactory ef;

	private EMSingleton() {
	}

	public static EntityManagerFactory getInst() {
		if (ef == null) {
			ef = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		}
		return ef;
	}

}
