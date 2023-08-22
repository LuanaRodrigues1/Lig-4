package tabuleiro;

import java.awt.event.KeyEvent;
import jogador.Jogador;

public class ModoTradicionalpara2Jogadores extends Tabuleiro {	

	public ModoTradicionalpara2Jogadores(Jogador jogador1, Jogador jogador2) {
        super(jogador1, jogador2);     
    }

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}
}