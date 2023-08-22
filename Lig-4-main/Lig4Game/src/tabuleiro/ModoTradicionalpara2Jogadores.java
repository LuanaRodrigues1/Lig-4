package tabuleiro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import exceptions.AtributoValorInvalidoException;
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

	@Override
	public void posicionarFicha(int coluna) throws AtributoValorInvalidoException {
		
	}
}
