package br.com.fiap.testes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.TimeDAO;
import br.com.fiap.daoImpl.TimeDAOImpl;
import br.com.fiap.entity.Campeonato;
import br.com.fiap.entity.Jogador;
import br.com.fiap.entity.Tecnico;
import br.com.fiap.entity.Time;
import br.com.fiap.singleton.EMSingleton;

public class Teste {

	public static EntityManagerFactory ef;
	public static EntityManager em;

	public static void main(String[] args) {
		ef = EMSingleton.getInst();
		em = ef.createEntityManager();
		try {
			TimeDAO dao = new TimeDAOImpl(em);

			Time t = new Time(0, "Time Juliao", 
					new GregorianCalendar(2017, Calendar.MARCH, 10), 1,
					new Tecnico(0, "Juliao"));
			
			List<Jogador> jogadores = new ArrayList<>();
			jogadores.add(new Jogador(0, "Julio", t));
			jogadores.add(new Jogador(0, "Julio1", t));
			jogadores.add(new Jogador(0, "Julio2", t));			
			t.setJogadores(jogadores);
			
			List<Campeonato> campeonatos = new ArrayList<>();
			campeonatos.add(new Campeonato(0, "Paulista"));
			campeonatos.add(new Campeonato(0, "Carioca"));			
			t.setCampeonatos(campeonatos);		
			
			dao.cadastrar(t);
			
			dao.salvar();
			
			System.out.println("Cadastrado!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em.isOpen()) {
				em.close();
			}
			if (ef.isOpen()) {
				ef.close();
			}
		}

	}

}
