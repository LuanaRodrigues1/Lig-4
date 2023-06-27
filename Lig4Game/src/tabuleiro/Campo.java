package tabuleiro;

public class Campo {
    private String ficha;

    // construtor para cada ficha começar com valor 0
    public Campo(){
        this.ficha = "0";
    }

    public String getFicha(){
        return this.ficha;
    }
    
    public void setFicha(String JogadorCor) {
    	this.ficha = JogadorCor;
    }
    
    public boolean verificarCampo() {
    	if (this.ficha == "0") {
    		return false;
    	} else {
    		return true;
    	}
    }
}