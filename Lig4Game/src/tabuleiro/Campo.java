package tabuleiro;

public class Campo {
    private int ficha;

    // construtor para cada ficha começar com valor 0
    public Campo(){
        this.ficha = 0;
    }

    public int getFicha(){
        return this.ficha;
    }
    
    public void mudarFicha(int jogador) {
    	if (this.ficha == 0) {
    		this.ficha = jogador;
    	} 
    }
    
}