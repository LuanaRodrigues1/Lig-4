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
    
    // isso provavelmente é um set (vou confirmar antes de mudar o nome)
    public void mudarFicha(int jogador) {
    	this.ficha = jogador;
    }
    
    public boolean verificarCampo() {
    	if (this.ficha == 0) {
    		return false;
    	} else {
    		return true;
    	}
    }
}