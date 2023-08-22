package interfaceGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ElementosVisuais {
	public static void criarJanela(JFrame janela, String titulo) {
		janela.setSize(900, 900);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setTitle(titulo);
		janela.setLocationRelativeTo(null);
		janela.setResizable(false);
	}
	
	public static void modificarFonteTexto(JLabel texto) {
		Font font = new Font(texto.getFont().getName(), Font.BOLD, 50);
		texto.setFont(font);
	}
	
	public static void centralizarTexto(JLabel texto) {
		Font font = new Font(texto.getFont().getName(), Font.BOLD, 50);
		texto.setFont(font);
	}
	
	public static void configurarGrid(GridBagConstraints gbc, int m1, int m2, int m3, int m4) {
        gbc.insets = new Insets(m1, m2, m3, m4); // Define margens
        gbc.fill = GridBagConstraints.HORIZONTAL; // Preenchimento horizontal
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER; // Centraliza
	}
	
	public static void personalizarBotao(JButton botao) {
        Font novaFonte = new Font("Norwester", Font.BOLD, 24);
        Color novaCorFonte = Color.WHITE;
        Color backgroundColorBotao = new Color(0, 34, 31);
        
        botao.setFont(novaFonte);
        botao.setForeground(novaCorFonte);
        botao.setBackground(backgroundColorBotao);
        botao.setFocusPainted(false);   
	}
}
