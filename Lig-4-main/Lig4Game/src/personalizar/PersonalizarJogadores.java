package personalizar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import exceptions.NomeBotException;
import exceptions.NomeLongoException;
import exceptions.NomeVazioException;
import interfaceGrafica.ElementosVisuais;
import jogador.Jogador;
import tabuleiro.Lig4Turbo;
import tabuleiro.Lig4TurboMaluco;
import tabuleiro.ModoTradicionalpara2Jogadores;

public class PersonalizarJogadores extends JFrame {
	private static String modoDeJogo;
	
    public static String getModoDeJogo() {
        return modoDeJogo;
    }
	
    public PersonalizarJogadores(String modoDeJogo, int numeroDeJogadores) {
    	this.modoDeJogo = modoDeJogo;
    	
        setContentPane(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/images/fundo.jpg"));
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        });
        
        setLayout(new GridBagLayout());
        
        ImageIcon imagemLig4 = new ImageIcon(getClass().getResource("/images/LIG-4-transformed.png"));
        JLabel labelLig4 = new JLabel(imagemLig4);
        JPanel imagemPanel = new JPanel();
        imagemPanel.add(labelLig4);
        imagemPanel.setOpaque(false);
        imagemPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        
        setSize(900, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JLabel pergunta1 = new JLabel("Qual o nome do jogador 1?");
        JTextField inputNameJogador1 = new JTextField(20);

        JLabel pergunta2 = new JLabel("Qual o nome do jogador 2?");
        JTextField inputNameJogador2 = new JTextField(20);
        
        Font fonteTexto = new Font("Norwester", Font.BOLD, 18);
        pergunta1.setFont(fonteTexto);
        inputNameJogador1.setFont(fonteTexto);
        pergunta2.setFont(fonteTexto);
        inputNameJogador2.setFont(fonteTexto);

        JButton continuar = new JButton("Continuar");
        ElementosVisuais.personalizarBotao(continuar);
        
        continuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
                	String nameJogador1 = inputNameJogador1.getText();
                	
                    Jogador jogador1 = null;
                    Jogador jogador2 = null;
    				
                    jogador1 = new Jogador(nameJogador1, 0, Color.BLACK);
                    
                    if(numeroDeJogadores == 2) {
                        String nameJogador2 = inputNameJogador2.getText();
        				
                        jogador2 = new Jogador(nameJogador2, 0, Color.BLUE);
                        
                	    if (nameJogador1.length() > 20 || nameJogador2.length() > 20) {
                	        throw new NomeLongoException();
                	    }
                	    
                	    if (nameJogador1.equalsIgnoreCase("bot") || nameJogador2.equalsIgnoreCase("bot")) {
                	        throw new NomeBotException();
                	    }
                	    
                	    if (nameJogador1.trim().isEmpty() || nameJogador2.trim().isEmpty()) {
                	        throw new NomeVazioException();
                	    }
                    }
            	    
            	    if (nameJogador1.length() > 20) {
            	        throw new NomeLongoException();
            	    }
            	    
            	    if (nameJogador1.equalsIgnoreCase("bot")) {
            	        throw new NomeBotException();
            	    }
            	    
            	    if (nameJogador1.trim().isEmpty()) {
            	        throw new NomeVazioException();
            	    }
            	    
                    if ("Tradicional".equals(modoDeJogo)) {
                    	new ModoTradicionalpara2Jogadores(jogador1, jogador2);
                    } else if ("Turbo".equals(modoDeJogo)) {
                    	new Lig4Turbo(jogador1, jogador2);
                    } else {
                    	new Lig4TurboMaluco(jogador1, jogador2);
                    }

            	} catch (NomeLongoException e1) {
            	    JOptionPane.showMessageDialog(PersonalizarJogadores.this, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            	} catch (NomeBotException e1) {
            	    JOptionPane.showMessageDialog(PersonalizarJogadores.this, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            	} catch (NomeVazioException e1) {
            	    JOptionPane.showMessageDialog(PersonalizarJogadores.this, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            	}
                dispose();
            }
        });
        
        GridBagConstraints gbc = new GridBagConstraints();
        ElementosVisuais.configurarGrid(gbc, 10, 100, 30, 100);
        
        add(imagemPanel, gbc); 

        gbc.gridy++; 
        add(pergunta1, gbc);
        gbc.gridy++; 
        add(inputNameJogador1, gbc);

        if(numeroDeJogadores == 2) {
            gbc.gridy++; 
            add(pergunta2, gbc);
            gbc.gridy++; 
            add(inputNameJogador2, gbc);	
        }
        
        gbc.gridy++; 
        add(continuar, gbc);

        setPreferredSize(new Dimension(900, 900));
        pack(); 
        setVisible(true);
    }
    
    
}
