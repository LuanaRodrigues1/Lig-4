package personalizar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import interfaceGrafica.ElementosVisuais;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Graphics;

public class EscolherModoJogo extends JFrame{
	public EscolherModoJogo(int numeroDeJogadores){		
        setContentPane(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/images/fundo.jpg"));
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        });
		
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
        
        setLayout(new GridBagLayout());
		
	    JButton tradicional = new JButton("Tradicional");
	    JButton turbo = new JButton("Turbo");
	    JButton turboMaluco = new JButton("Turbo Maluco");
	    
	    ElementosVisuais.personalizarBotao(tradicional);
	    ElementosVisuais.personalizarBotao(turbo);
	    ElementosVisuais.personalizarBotao(turboMaluco);  
	    
	    tradicional.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PersonalizarJogadores("Tradicional", numeroDeJogadores);
                dispose();
            }
        });
	    
	    turbo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PersonalizarJogadores("Turbo", numeroDeJogadores);
                dispose();
            }
        });
	    
	    turboMaluco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PersonalizarJogadores("Turbo Maluco", numeroDeJogadores);
                dispose();
            }
        });
	    
	    GridBagConstraints gbc = new GridBagConstraints();
	    
	    ElementosVisuais.configurarGrid(gbc, 10, 1000, 10, 1000);

	    add(imagemPanel, gbc); 
	    
	    gbc.gridy++;
	    add(tradicional, gbc);

	    gbc.gridy++;
	    add(turbo, gbc);

	    gbc.gridy++;
	    add(turboMaluco, gbc);
	    
        setPreferredSize(new Dimension(900, 900));
        pack(); 
        setVisible(true);
	}

}
