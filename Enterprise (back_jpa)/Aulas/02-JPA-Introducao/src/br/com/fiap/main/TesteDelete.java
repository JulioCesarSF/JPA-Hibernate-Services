package br.com.fiap.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Aluno;

public class TesteDelete {
	
	public static void main(String[] args) {
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fac.createEntityManager();
		
		Aluno a = em.find(Aluno.class, 1);
		
		em.remove(a);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fac.close();
	}

}
