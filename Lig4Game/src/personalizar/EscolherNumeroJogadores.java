package personalizar;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaceGrafica.ElementosVisuais;

public class EscolherNumeroJogadores {
	public static void escolherNumeroJogadores() {
		JFrame numeroJogadores = new JFrame("Numero de Jogadores");
		numeroJogadores.setSize(900, 900);
		numeroJogadores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    JPanel panel = new JPanel(new GridBagLayout());
	    
	    JLabel titulo = new JLabel("Conect 4");
		
	    JButton n1 = new JButton("1 Jogador");
	    JButton n2 = new JButton("2 Jogadores");
	    
	    GridBagConstraints gbc = new GridBagConstraints();
	    
	    ElementosVisuais.modificarFonteTexto(titulo);
	    ElementosVisuais.configurarGrid(gbc);
	    
	    panel.add(titulo, gbc);
	    titulo.setHorizontalAlignment(JLabel.CENTER);

	    gbc.gridy = 1;
	    panel.add(n1, gbc);

	    gbc.gridy = 2;
	    panel.add(n2, gbc);
	    
	    numeroJogadores.getContentPane().add(panel);
	    
	    numeroJogadores.setVisible(true);
	}
}
