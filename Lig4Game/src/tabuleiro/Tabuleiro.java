package tabuleiro;

public class Tabuleiro {
	Campo[][] lig4 = new Campo[7][7];  
	
    public Tabuleiro() {
        for (int i = 0; i < lig4.length; i++) {
            for (int j = 0; j < lig4[i].length; j++) {
                lig4[i][j] = new Campo();
            }
        }
    }
	
    public void mostrarTabuleiro() {
        for (int i = 0; i < lig4.length; i++) {
            for (int j = 0; j < lig4[i].length; j++) {
            	System.out.printf("|%d", lig4[i][j].getFicha());
            }
            
            System.out.println("|");
        }
        System.out.println();
    }
    
    public void posicionarFicha(int linha, int coluna) {
    	lig4[linha][coluna].mudarFicha(2);
    }
    
   
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.mostrarTabuleiro();
        
        tabuleiro.posicionarFicha(3, 2);
        tabuleiro.mostrarTabuleiro();
    }
	
}