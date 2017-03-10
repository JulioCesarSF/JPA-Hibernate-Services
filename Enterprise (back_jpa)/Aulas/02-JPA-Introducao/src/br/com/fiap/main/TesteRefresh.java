package br.com.fiap.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Aluno;

public class TesteRefresh {

	public static void main(String[] args) {
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fac.createEntityManager();
		
		Aluno a = em.find(Aluno.class, 1);		
		System.out.println("Nome: " + a.getNome());		
		a.setNome("teste");
		System.out.println(a.getNome());
		em.refresh(a);		
		System.out.println(a.getNome());
		
		em.close();
		fac.close();
	}

}
