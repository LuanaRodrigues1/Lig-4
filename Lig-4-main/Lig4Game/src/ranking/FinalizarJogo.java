package ranking;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import interfaceGrafica.ElementosVisuais;
import jogador.Bot;
import jogador.Jogador;
import personalizar.EscolherNumeroJogadores;
import personalizar.PersonalizarJogadores;
import tabuleiro.Lig4Turbo;
import tabuleiro.Lig4TurboMaluco;
import tabuleiro.ModoTradicionalpara2Jogadores;


public class FinalizarJogo extends JFrame {
    public FinalizarJogo(Jogador jogador1, Jogador jogador2, Bot bot) {	        
        setLayout(new GridBagLayout());
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon imagemLig4 = new ImageIcon(getClass().getResource("/images/trofeu.jpg"));
        JLabel labelLig4 = new JLabel(imagemLig4);
        JPanel imagemPanel = new JPanel();
        imagemPanel.add(labelLig4);
        imagemPanel.setOpaque(false);         
        imagemPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        String resultado;
        
        if (jogador2 == null) {
        	resultado = verificarPontuacao(jogador1, bot);
        } else {
        	resultado = verificarPontuacao(jogador1, jogador2);
        }
        
		JLabel vencedorLabel = new JLabel(resultado);
        
        Font fonteTexto = new Font("Norwester", Font.BOLD, 24);
        vencedorLabel.setFont(fonteTexto);
        
        JButton ranking = new JButton("Ranking");
        JButton jogarNovamente = new JButton("Jogar novamente");

        ElementosVisuais.personalizarBotao(jogarNovamente);
        ElementosVisuais.personalizarBotao(ranking);

        jogarNovamente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PersonalizarJogadores.getModoDeJogo() == "Tradicional") {
                	new ModoTradicionalpara2Jogadores(jogador1, jogador2);
                } else if (PersonalizarJogadores.getModoDeJogo() == "Turbo") {
                	new Lig4Turbo(jogador1, jogador2);
                } else {
                	new Lig4TurboMaluco(jogador1, jogador2);
                }
                
                dispose();
            }
        });

        ranking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Ranking();
                dispose();
            }
        });
        
        GridBagConstraints gbc = new GridBagConstraints();
        ElementosVisuais.configurarGrid(gbc, 10, 100, 30, 100);

        gbc.gridy = 0; 
        add(imagemPanel, gbc);
        
        gbc.gridy++; 
        add(vencedorLabel, gbc);
        
        gbc.gridy++; 
        add(ranking, gbc);
        
        gbc.gridy++; 
        add(jogarNovamente, gbc);

        setPreferredSize(new Dimension(400, 500));
        pack(); 
        setVisible(true);
    }
    
    public String verificarPontuacao(Jogador jogador1, Jogador jogador2) {
        if (jogador1.getPontos() > jogador2.getPontos()) {
        	ArquivoCsv.adicionarDados(jogador1.getNome(), jogador1.getPontos());
            return jogador1.getNome() + " venceu!";   
        } else if (jogador2.getPontos() > jogador1.getPontos()) {
        	ArquivoCsv.adicionarDados(jogador2.getNome(), jogador2.getPontos());
            return jogador2.getNome() + " venceu!";
        } else {
            return "O jogo terminou em empate!";
        }
    }

    public String verificarPontuacao(Jogador jogador1, Bot bot) {
        if (jogador1.getPontos() > bot.getPontos()) {
        	ArquivoCsv.adicionarDados(jogador1.getNome(), jogador1.getPontos());
            return jogador1.getNome() + " venceu!";
        } else if (bot.getPontos() > jogador1.getPontos()) {
            return "O bot venceu!";
        } else {
            return "O jogo terminou em empate!";
        }
    }
}
