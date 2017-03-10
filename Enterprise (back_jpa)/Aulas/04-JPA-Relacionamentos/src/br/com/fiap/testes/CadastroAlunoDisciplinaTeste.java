package br.com.fiap.testes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.AlunoDAO;
import br.com.fiap.dao.DisciplinaDAO;
import br.com.fiap.daoImpl.AlunoDAOImpl;
import br.com.fiap.daoImpl.DisciplinaDAOImpl;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Disciplina;
import br.com.fiap.singleton.EMSingleton;

public class CadastroAlunoDisciplinaTeste {

	public static EntityManagerFactory ef;
	public static EntityManager em;

	public static void main(String[] args) {
		// cadastrar alunos e disciplinas
		ef = EMSingleton.getInst();
		em = ef.createEntityManager();

		try {
			
			AlunoDAO aDao = new AlunoDAOImpl(em);			
			List<Disciplina> disciplinas = new ArrayList<>();
			disciplinas.add(new Disciplina(0, "EAD", 80, "Ta foda"));
			disciplinas.add(new Disciplina(0, "EAD2", 10, "Ta foda2"));
			disciplinas.add(new Disciplina(0, "EAD3", 50, "Ta foda3"));
			Aluno aluno = new Aluno(0, "Aluno com disciplina");
			aluno.setDisciplinas(disciplinas);
			aDao.cadastrar(aluno);			
			aDao.salvar();			
			
			DisciplinaDAO dDao = new DisciplinaDAOImpl(em);
			List<Aluno> alunos = new ArrayList<>();
			alunos.add(new Aluno(0, "Aluno para Disciplina"));
			alunos.add(new Aluno(0, "Aluno para Disciplina2"));
			alunos.add(new Aluno(0, "Aluno para Disciplina2"));	
			Disciplina d = new Disciplina(0, "Aluno para Disciplina Teste", 90, "teste disc->aluno");
			d.setAlunos(alunos);
			dDao.cadastrar(d);
			dDao.salvar();			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em.isOpen()) {
				System.out.println("Fechando em");
				em.close();
			}
			if (ef.isOpen()) {
				System.out.println("Fechando ef");
				ef.close();
			}
		}

	}

}
