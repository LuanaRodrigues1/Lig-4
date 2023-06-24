package tabuleiro;

public class Tabuleiro {
	private int quantLinha = 7;
	private int quantColuna = 7;
	private Campo[][] tabuleiro = new Campo[quantLinha][quantColuna];  
	
	// Criei esse construtor para ele adicionar uma ficha 0 a cada posição assim que é criado um new tabuleiro
    public Tabuleiro() {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                tabuleiro[i][j] = new Campo();
            }
        }
    }
	
    // metodo para montar um tabuleiro no console
    public void mostrarTabuleiro() {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
            	System.out.printf("|%d", tabuleiro[i][j].getFicha());
            }
            
            System.out.println("|");
        }
        System.out.println();
    }
    
    public void posicionarFicha(int jogador, int coluna) {
    	// criei uma variavel que guarde a quantidade de linhas presentes no tabuleiro
    	int linha = this.quantLinha - 1;
    	
    	// primeira verificação do campo para saber se está ocupado (true) ou não (false)
    	boolean local = tabuleiro[linha][coluna].verificarCampo();;
    	
    	
		if (local == false) {
			// se a primeira linha estiver livre
			tabuleiro[linha][coluna].mudarFicha(jogador);
		} else {
			// se a primeira linha não estiver livre
	    	while(local && linha >= 0) {
	    		// aqui ele irá verificar até encontrar uma linha livre respeitando o tamanho do tabuleiro
	    		local = tabuleiro[linha][coluna].verificarCampo();
	    		
	    		if (local == false) {
	    			tabuleiro[linha][coluna].mudarFicha(jogador);
	    		}
	    		
	    		linha--;
	    	}
		}
    }
    
    /*
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro();
        
        tabuleiro.posicionarFicha(1, 2);
        tabuleiro.posicionarFicha(2, 2);
        tabuleiro.posicionarFicha(1, 2);
        tabuleiro.posicionarFicha(2, 2);
        tabuleiro.posicionarFicha(1, 2);
        tabuleiro.posicionarFicha(1, 2);
        tabuleiro.posicionarFicha(1, 2);
        tabuleiro.posicionarFicha(1, 2);
        tabuleiro.posicionarFicha(1, 2);
        tabuleiro.posicionarFicha(1, 2);
        tabuleiro.posicionarFicha(1, 2);
        tabuleiro.posicionarFicha(2, 3);
        tabuleiro.posicionarFicha(2, 3);
        tabuleiro.posicionarFicha(1, 5);
        tabuleiro.posicionarFicha(2, 5);
        
        tabuleiro.mostrarTabuleiro();
    }
    */
}