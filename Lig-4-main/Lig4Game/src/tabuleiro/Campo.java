package tabuleiro;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import exceptions.AtributoValorInvalidoException;
import jogador.Bot;
import jogador.Jogador;

public class Campo extends JPanel {
    public static final int TAMANHO_QUADRADO = 70;
    private boolean ficha = false; 
    private Color corJogador;
    
    public Campo() {
    	Color borderColor = new Color(185, 161, 169);
    	Color backgroundColor = new Color(231, 231, 231);
    	
    	// vai criar a dimensão 
        setPreferredSize(new Dimension(TAMANHO_QUADRADO, TAMANHO_QUADRADO));
        setBackground(backgroundColor);
        // coloca borda no quadrado
        Border borda = BorderFactory.createLineBorder(borderColor);
        setBorder(borda);
    }

    public void adicionarFicha() {
    	ficha = true;
        repaint(); 
    }
    
    public boolean verificarCampo() {	
    	return ficha;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (ficha) {
            g.setColor(this.corJogador);
            int tamanhoFicha = 50; 
            int x = (TAMANHO_QUADRADO - tamanhoFicha) / 2;
            int y = (TAMANHO_QUADRADO - tamanhoFicha) / 2;
            g.fillOval(x, y, tamanhoFicha, tamanhoFicha);
        }
    }   
    
    // get e set
    
    public void setCorJogador(Jogador jogador) {
    	this.corJogador = jogador.getCorFicha();
    }
    
    public void setCorJogador(Bot bot) {
    	this.corJogador = bot.getCorFicha();
    }

    
    public Color getCorJogador() {	
    	return corJogador;
    }
}