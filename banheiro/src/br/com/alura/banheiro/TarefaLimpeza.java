package br.com.alura.banheiro;

public class TarefaLimpeza implements Runnable {
	
	private Banheiro banheiro;

	@Override
	public void run() {
		banheiro.limpa();
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public TarefaLimpeza(Banheiro banheiro) {
		this.banheiro = banheiro;
	}

}
