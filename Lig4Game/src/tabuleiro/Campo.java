package tabuleiro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import excepitions.AtributoValorInvalidoException;

public class Campo extends JPanel {
    public static final int TAMANHO_QUADRADO = 50;
    private boolean ficha = false; 
    private Color corJogador;
    
    public Campo() {
    	// vai criar a dimensão 
        setPreferredSize(new Dimension(TAMANHO_QUADRADO, TAMANHO_QUADRADO));
        
        // coloca borda no quadrado
        Border borda = BorderFactory.createLineBorder(Color.BLACK);
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
            int tamanhoFicha = 30; 
            int x = (TAMANHO_QUADRADO - tamanhoFicha) / 2;
            int y = (TAMANHO_QUADRADO - tamanhoFicha) / 2;
            g.fillOval(x, y, tamanhoFicha, tamanhoFicha);
        }
    }   
    
    // get e set
    
    public void setCorJogador(Color corJogador) throws AtributoValorInvalidoException {
    	if (corJogador == null) {
    		throw new AtributoValorInvalidoException("A cor não pode ser nula");
    	}
    	this.corJogador = corJogador;
    }
    
    public Color getCorJogador() {	
    	return corJogador;
    }
}