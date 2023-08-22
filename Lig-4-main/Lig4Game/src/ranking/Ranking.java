package ranking;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import interfaceGrafica.ElementosVisuais;
import personalizar.EscolherNumeroJogadores;
import personalizar.Menu;

public class Ranking extends JFrame {
    public Ranking() {
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

        JTable tabela = null;
		try {
			tabela = ArquivoCsv.criarTabela();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

        JScrollPane painelTabela = new JScrollPane(tabela);
        
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        add(imagemPanel, gbc);

        gbc.gridy = 1;
        add(painelTabela, gbc);

        JButton voltar = new JButton("Voltar");
        ElementosVisuais.personalizarBotao(voltar);

        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Menu();
                dispose();
            }
        });  
        
        gbc.insets = new Insets(30, 0, 0, 0);
        gbc.gridy = 2;
        add(voltar, gbc);

        setPreferredSize(new Dimension(900, 900));
        pack(); 
        setVisible(true);
    }

}
