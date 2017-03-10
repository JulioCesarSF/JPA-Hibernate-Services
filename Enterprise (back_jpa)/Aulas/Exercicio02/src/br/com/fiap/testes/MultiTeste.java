package br.com.fiap.testes;

import javax.persistence.EntityManagerFactory;

import br.com.fiap.singleton.EMFactory;

public class MultiTeste implements Runnable {

	private static EntityManagerFactory ef = null;

	private static Thread t = null;

	public static void main(String[] args) {
		ef = EMFactory.getInst();
		if (ef.isOpen()) {
			t = new Thread(new MultiTeste());
			t.start();			
		}
	}

	//as vezes fica preso por causa do session do hibernate que não é threadsafe.
	@Override
	public void run() {
		try {
			new Thread(new TesteAutorDAO(ef)).start();;
			new Thread(new TesteEditoraDAO(ef)).start();
			new Thread(new TesteEmprestimoDAO(ef)).start();
			new Thread(new TesteExemplarDAO(ef)).start();
			new Thread(new TesteLivroDAO(ef)).start();
			new Thread(new TesteUsuarioDAO(ef)).start();
			
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ef.isOpen()) {
				System.out.println("close ef");
				ef.close();
			}			
		}

	}

}
