package personalizar;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaceGrafica.ElementosVisuais;

public class Menu extends JFrame {   
	public Menu() {
		setSize(900, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
        JPanel panel = new JPanel(new GridBagLayout());
        
        JLabel titulo = new JLabel("Conect 4");
		
        JButton jogar = new JButton("jogar");
        
        jogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EscolherModoJogo();
                dispose();
            }
        });
        
        JButton ranking = new JButton("ranking");
        JButton sair = new JButton("sair");
        
        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        ElementosVisuais.modificarFonteTexto(titulo);
        ElementosVisuais.configurarGrid(gbc);
        
        panel.add(titulo, gbc);
        titulo.setHorizontalAlignment(JLabel.CENTER);

        gbc.gridy = 1;
        panel.add(jogar, gbc);

        gbc.gridy = 2;
        panel.add(ranking, gbc);

        gbc.gridy = 3;
        panel.add(sair, gbc);
        
        getContentPane().add(panel);
        
        setVisible(true);
    }
	
	public static void main(String[] args) {
		new Menu();
	}
}


