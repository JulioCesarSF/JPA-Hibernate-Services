package br.com.fiap.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Aluno;

public class TesteBusca {
	
	public static void main(String[] args) {
		 EntityManagerFactory fac = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		 EntityManager em = fac.createEntityManager();
		 
		 Aluno aluno = em.find(Aluno.class, 1);
		 
		 System.out.println(aluno.getNome());
		 
		 em.close();
		 fac.close();
		 
	}

}
