package personalizar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import interfaceGrafica.ElementosVisuais;
import ranking.ArquivoCsv;
import ranking.Ranking;

public class Menu extends JFrame {   
    public Menu() {
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

        JButton jogar = new JButton("Jogar");
        JButton ranking = new JButton("Ranking");
        JButton sair = new JButton("Sair");

        ElementosVisuais.personalizarBotao(jogar);
        ElementosVisuais.personalizarBotao(ranking);
        ElementosVisuais.personalizarBotao(sair);

        jogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EscolherNumeroJogadores();
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

        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();

        ElementosVisuais.configurarGrid(gbc, 10, 100, 10, 100);

        add(imagemPanel, gbc);

        gbc.gridy++;
        add(jogar, gbc);

        gbc.gridy++;
        add(ranking, gbc);

        gbc.gridy++;
        add(sair, gbc);

        setPreferredSize(new Dimension(900, 900));
        pack(); 
        setVisible(true);
    }

    public static void main(String[] args) {
        new Menu();
    }
}


