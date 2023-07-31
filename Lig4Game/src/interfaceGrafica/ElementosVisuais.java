package interfaceGrafica;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ElementosVisuais {
	public static void criarJanela(JFrame janela, int largura, int altura, String titulo) {
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
	
	public static void configurarGrid(GridBagConstraints gbc) {
        gbc.insets = new Insets(10, 100, 10, 100); // Define margens
        gbc.fill = GridBagConstraints.HORIZONTAL; // Preenchimento horizontal
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0; // Expande horizontalmente
        gbc.anchor = GridBagConstraints.CENTER; // Centraliza
	}
}
