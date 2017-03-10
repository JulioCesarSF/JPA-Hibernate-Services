package br.com.fiap.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Sexo;

public class TesteCadastro {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = factory.createEntityManager();
		
		Aluno a = new Aluno();
		a.setNome("Juliao");
		a.setIdade(29);
		a.setBolsista(false);		
		a.setSexo(Sexo.MASCULINO);
		
		a.setDataNascimento(new GregorianCalendar(1987, Calendar.OCTOBER, 13));
		a.setCpg("123.123.123-00");
		a.setFoto(null);
		
		em.persist(a);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		System.out.println("Aluno cadastrado");
		
		em.close();
		factory.close();
	}

}
