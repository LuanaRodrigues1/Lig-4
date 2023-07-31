package personalizar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import interfaceGrafica.ElementosVisuais;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscolherModoJogo extends JFrame{
	public EscolherModoJogo(){
		setSize(900, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
	    JPanel panel = new JPanel(new GridBagLayout());
	    
	    JLabel titulo = new JLabel("Conect 4");
		
	    JButton tradicional = new JButton("Tradicional");
	    tradicional.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PersonalizarJogadores("Tradicional");
                dispose();
            }
        });
	    
	    JButton turbo = new JButton("Turbo");
	    turbo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PersonalizarJogadores("Turbo");
                dispose();
            }
        });
	    
	    JButton turboMaluco = new JButton("Turbo Maluco");
	    turboMaluco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PersonalizarJogadores("Turbo Maluco");
                dispose();
            }
        });
	    
	    GridBagConstraints gbc = new GridBagConstraints();
	    
	    ElementosVisuais.modificarFonteTexto(titulo);
	    ElementosVisuais.configurarGrid(gbc);
	    
	    panel.add(titulo, gbc);
	    titulo.setHorizontalAlignment(JLabel.CENTER);

	    gbc.gridy = 1;
	    panel.add(tradicional, gbc);

	    gbc.gridy = 2;
	    panel.add(turbo, gbc);

	    gbc.gridy = 3;
	    panel.add(turboMaluco, gbc);
	    
	    getContentPane().add(panel);
	    
	    setVisible(true);
	}

}
