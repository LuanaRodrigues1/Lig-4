package personalizar;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import excepitions.AtributoValorInvalidoException;
import interfaceGrafica.ElementosVisuais;
import jogador.Jogador;
import tabuleiro.Lig4Turbo;
import tabuleiro.ModoTradicionalpara2Jogadores;

public class PersonalizarJogadores extends JFrame {
	private String modoDeJogo;
	
    public PersonalizarJogadores(String modoDeJogo) {
    	this.modoDeJogo = modoDeJogo;
    	
        setSize(900, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new GridBagLayout());

        JLabel titulo = new JLabel("Conect 4");

        JLabel pergunta1 = new JLabel("Qual o nome do jogador 1?");
        JTextField inputNameJogador1 = new JTextField(20);

        JLabel pergunta2 = new JLabel("Qual o nome do jogador 2?");
        JTextField inputNameJogador2 = new JTextField(20);

        JButton continuar = new JButton("Continuar");

        continuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String nameJogador1 = inputNameJogador1.getText();
            	
                Jogador jogador1 = null;
                Jogador jogador2 = null;
				
                try {
					jogador1 = new Jogador(nameJogador1, 0);
				} catch (AtributoValorInvalidoException e1) {
					e1.printStackTrace();
				}
                
                String nameJogador2 = inputNameJogador2.getText();
				
                try {
					jogador2 = new Jogador(nameJogador2, 0);
				} catch (AtributoValorInvalidoException e1) {
					e1.printStackTrace();
				}
                
                if (modoDeJogo == "Tradicional") {
                	new ModoTradicionalpara2Jogadores(jogador1, jogador2);
                } else if (modoDeJogo == "Turbo") {
                	new Lig4Turbo(jogador1, jogador2);
                } 
                
                dispose();
            }
        });
        
        GridBagConstraints gbc = new GridBagConstraints();
        ElementosVisuais.modificarFonteTexto(titulo);
        ElementosVisuais.configurarGrid(gbc);

        panel.add(titulo, gbc);
        titulo.setHorizontalAlignment(JLabel.CENTER);

        gbc.gridy = 1; // Define a próxima linha para os componentes seguintes
        panel.add(pergunta1, gbc);
        gbc.gridy++; // Incrementa o valor para o próximo componente ficar embaixo
        panel.add(inputNameJogador1, gbc);

        gbc.gridy++; // Incrementa o valor para o próximo componente ficar embaixo
        panel.add(pergunta2, gbc);
        gbc.gridy++; // Incrementa o valor para o próximo componente ficar embaixo
        panel.add(inputNameJogador2, gbc);

        gbc.gridy++; // Incrementa o valor para o próximo componente ficar embaixo
        panel.add(continuar, gbc);

        getContentPane().add(panel);

        setVisible(true);
    }
}
