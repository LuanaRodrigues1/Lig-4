package personalizar;

import java.awt.Dimension;
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
import javax.swing.JPanel;

import interfaceGrafica.ElementosVisuais;

public class EscolherNumeroJogadores extends JFrame {
    public EscolherNumeroJogadores() {	
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
        imagemPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 100, 0));
        
        setSize(900, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
		
        JButton Jogador = new JButton("1 Jogador");
        JButton Jogadores = new JButton("2 Jogadores");
        
        ElementosVisuais.personalizarBotao(Jogador);
        ElementosVisuais.personalizarBotao(Jogadores);
        
        Jogador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EscolherModoJogo(1);
                dispose();
            }
        });  
        
        Jogadores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new EscolherModoJogo(2);
                dispose();
            }
        });
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        ElementosVisuais.configurarGrid(gbc, 10, 100, 10, 100);
        
        add(imagemPanel, gbc);   

        gbc.gridy++;
        add(Jogador, gbc);

        gbc.gridy++;
        add(Jogadores, gbc);
        
        setPreferredSize(new Dimension(900, 900));
        pack(); 
        setVisible(true);
    }
}
