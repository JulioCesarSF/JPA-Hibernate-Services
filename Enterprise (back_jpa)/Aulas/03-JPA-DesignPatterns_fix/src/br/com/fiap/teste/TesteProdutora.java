package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.impl.ProdutoraDAOImpl;
import br.com.fiap.entity.Produtora;
import br.com.fiap.exception.CommitErrorException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class TesteProdutora {
	
	static EntityManagerFactory ef = null;
	static EntityManager em = null;
	static ProdutoraDAOImpl dao;
	
	public static void main(String[] args) {
		
		ef = EntityManagerFactorySingleton.getInstance();
		em = ef.createEntityManager();
		
		dao = new ProdutoraDAOImpl(em);
		dao.cadastrar(new Produtora(0, "Blizzard"));
		
		try {
			dao.salvar();
		} catch (CommitErrorException e) {			
			e.printStackTrace();
		}finally {
			
			Produtora p = dao.buscar(1);
			
			System.out.println(p);
			
			if(em.getTransaction().isActive()){
				em.close();
			}
			
			if(ef.isOpen()){
				ef.close();
			}
		}		
	}
}
