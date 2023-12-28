package br.com.alura.banheiro;

public class Banheiro {
	
	private boolean ehSujo =  true;
	
	public void fazNumero1() {
		
		//Recupera o nome da thread.
		String nome = Thread.currentThread().getName(); 
		
		System.out.println(nome + " batendo na porta");
		
		//Sincroniza��o para evitar o acesso ao recurso ao mesmo tempo (chave do banheiro).
		synchronized(this) {
		
			System.out.println(nome + " entrando no banheiro");
			
			while (ehSujo) {
				esperaLaFora(nome);
			}
			
			System.out.println(nome + " fazendo coisa r�pida");
			
			dormeUmPouco(5000);
			
			this.ehSujo = true;
			
			System.out.println(nome + " dando descarga");
			System.out.println(nome + " lavando a m�o");
			System.out.println(nome + " saindo do banheiro");
		
		}
		
	}
	
	public void limpa() {
		
		//Recupera o nome da thread.
				String nome = Thread.currentThread().getName(); 
				
				System.out.println(nome + " batendo na porta");
				
				//Sincroniza��o para evitar o acesso ao recurso ao mesmo tempo (chave do banheiro).
				synchronized(this) {
				
					System.out.println(nome + " entrando no banheiro");
					
					if(!ehSujo) {
						System.out.println(nome + ", n�o est� sujo, vou sair ");
						return;
					}
					
					System.out.println(nome + " limpando banheiro");
					this.ehSujo = false;
					
					dormeUmPouco(13000);
					
					this.notifyAll();
					
					System.out.println(nome + " saindo do banheiro");
					
				}		
		
	
	}

	private void esperaLaFora(String nome) {
		System.out.println(nome + " banheiro sujo	");
		try {
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    public void fazNumero2() {
    	
    	//Recupera o nome da thread.
    	String nome = Thread.currentThread().getName(); 
    	
    	System.out.println(nome + " batendo na porta");
    	
    	//Chave mutex = this abaixo.
    	synchronized(this) {
    	
	    	System.out.println(nome + " entrando no banheiro");
	    	
            while (ehSujo) {
				esperaLaFora(nome);
			}
	    	
			System.out.println(nome + " fazendo coisa demorada");
			
			dormeUmPouco(10000);
			
			this.ehSujo = true;
			
			System.out.println(nome + " dando descarga");
			System.out.println(nome + " lavando a m�o");
			System.out.println(nome + " saindo do banheiro");
		
    	}
	}

	private void dormeUmPouco(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
