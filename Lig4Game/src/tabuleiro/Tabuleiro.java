package tabuleiro;

public class Tabuleiro {
	private int quantidadeLinha = 7;
	private int quantidadeColuna = 7;
	private Campo[][] tabuleiro = new Campo[quantidadeLinha][quantidadeColuna];  
	
	// Criei esse construtor para ele adicionar uma ficha 0 a cada posição assim que é criado um new tabuleiro
    public Tabuleiro() {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                tabuleiro[i][j] = new Campo();
            }
        }
    }
    
    public int nMaximoRodadas() {
    	return quantidadeLinha * quantidadeColuna;
    }
	
    // metodo para montar um tabuleiro no console
    public void mostrarTabuleiro() {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
            	System.out.printf("|%s", tabuleiro[i][j].getFicha());
            }
            
            System.out.println("|");
        }
        System.out.println();
    }
    
    public void posicionarFicha(String JogadorCor, int coluna) {
    	// criei uma variavel que guarde a quantidade de linhas presentes no tabuleiro
    	int linha = this.quantidadeLinha - 1;
    	
    	// primeira verificação do campo para saber se está ocupado (true) ou não (false)
    	boolean local = tabuleiro[linha][coluna].verificarCampo();;
    	
    	
		if (!local) {
			// se a primeira linha estiver livre
			tabuleiro[linha][coluna].setFicha(JogadorCor);
		} else {
			// se a primeira linha não estiver livre
	    	while(local && linha >= 0) {
	    		// aqui ele irá verificar até encontrar uma linha livre respeitando o tamanho do tabuleiro
	    		local = tabuleiro[linha][coluna].verificarCampo();
	    		
	    		if (!local) {
	    			tabuleiro[linha][coluna].setFicha(JogadorCor);
	    		}
	    		
	    		linha--;
	    	}
		}
    }
}