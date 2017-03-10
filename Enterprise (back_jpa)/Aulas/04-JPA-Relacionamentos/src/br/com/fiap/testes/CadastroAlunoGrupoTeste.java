package br.com.fiap.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.GrupoDAO;
import br.com.fiap.daoImpl.GrupoDAOImpl;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Grupo;
import br.com.fiap.singleton.EMSingleton;

public class CadastroAlunoGrupoTeste {
	
	public static EntityManagerFactory ef;
	public static EntityManager em;
	
	public static void main(String[] args) {
		
		ef = EMSingleton.getInst();
		em = ef.createEntityManager();
		
		GrupoDAO dao = new GrupoDAOImpl(em);
		
		try {
			Grupo g = new Grupo(0, "Grupo Teste");
			g.addAluno(new Aluno(0, "Aluno Teste 1", g));
			g.addAluno(new Aluno(0, "Aluno Teste 1", g));
			g.addAluno(new Aluno(0, "Aluno Teste 1", g));
			
			dao.cadastrar(g);
			
			dao.salvar();
			System.out.println("Cadastrado!");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro:\t:" + e.getMessage());
		}finally {
			if(em.isOpen()){
				System.out.println("Fechando em");
				em.close();
			}
			if(ef.isOpen()){
				System.out.println("Fechando ef");
				ef.close();
			}
		}
		
		
	}

}
