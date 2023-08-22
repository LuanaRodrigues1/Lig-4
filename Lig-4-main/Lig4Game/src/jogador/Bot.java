package jogador;

import java.awt.Color;
import java.util.Random;

public class Bot extends Jogador{
    public Bot(String nome, int pontos, Color cor){
		super(nome, pontos, cor);
	}
    
    public int escolherColuna() {
        Random random = new Random();
        int coluna = random.nextInt(7);
        
        return coluna;
    }
}


















