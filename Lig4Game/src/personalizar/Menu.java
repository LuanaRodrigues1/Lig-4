package personalizar;

/*
import javax.swing.*;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;
*/

import java.util.Scanner;

public class Menu {
    public String perguntar(String pergunta) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(pergunta);
        String resposta = scanner.nextLine();
    	
        scanner.close();
        
    	return resposta;  	
    }
    
    public String personalizarUmJogador() {
    	String nome = perguntar("Qual é seu nome? ");
    	
    	return nome;
    }
    
    public String[] personalizarDoisJogadores() {
    	String[] arrayRespostas = new String[4];
    	
    	System.out.println("Jogador 1");
    	String nomeJogador1 = perguntar("Qual é seu nome? ");
        String corJogador1 = perguntar("Qual é a cor de sua ficha? ");
        
        System.out.println("Jogador 2");
        String nomeJogador2 = perguntar("Qual é seu nome? ");
        String corJogador2 = perguntar("Qual é a cor de sua ficha? ");
        
        arrayRespostas[0] = nomeJogador1;
        arrayRespostas[1] = corJogador1;
        arrayRespostas[2] = nomeJogador2;
        arrayRespostas[3] = corJogador2;
        
    	return arrayRespostas;
    }	
   
	public void menu() {
            Scanner scanner = new Scanner(System.in);
            int opcao;
            
            System.out.println("===== Menu =====");
            System.out.println("1. Opção 1");
            System.out.println("2. Opção 2");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    personalizarUmJogador();
                    break;
                case 2:
                   	personalizarDoisJogadores();
                    break;
                case 3:
                    System.out.println("Saindo do menu...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
           
            scanner.close();
    }
    
	/*
	 * Iniciando interface grafica
	 * 
    public static void main(String[] args) {
        // Cria uma nova janela
        JFrame frame = new JFrame("Minha Janela Swing");
        
        // Define o tamanho da janela
        frame.setSize(900, 900);
        
        // Define o comportamento ao fechar a janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Cria um rótulo para exibir o texto
        JLabel titulo = new JLabel("Conect 4");
        JPanel panel = new JPanel(new GridBagLayout());
        
        // Cria os botões
        JButton botao1 = new JButton("Botão 1");
        JButton botao2 = new JButton("Botão 2");
        JButton botao3 = new JButton("Botão 3");

        // Adiciona o painel à janela
        frame.getContentPane().add(panel);
        
        // Define a nova fonte com tamanho maior
        Font font = new Font(titulo.getFont().getName(), Font.BOLD, 24);
        titulo.setFont(font);
        
        // Centraliza o texto dentro do rótulo
        titulo.setHorizontalAlignment(JLabel.CENTER);
        
        panel.add(titulo);
        panel.add(botao1);
        panel.add(botao2);
        panel.add(botao3);
        
        // Adiciona o rótulo à janela
        frame.getContentPane().add(panel);
        
        // Exibe a janela
        frame.setVisible(true);
    }
   
	
	private static int selectedButtonIndex = 0;
	
    private static void handleSelectedButton() {
        System.out.println("Botão selecionado: " + (selectedButtonIndex + 1));
    }

    private static void updateButtonFocus(Component[] buttons) {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setFocusable(i == selectedButtonIndex);
        }
    }
    
    public static void main(String[] args) {
        // Cria uma nova janela
        JFrame frame = new JFrame("Minha Janela Swing");

        // Define o tamanho da janela
        frame.setSize(900, 900);

        // Define o comportamento ao fechar a janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Cria um painel com layout GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());

        JLabel titulo = new JLabel("Conect 4");

        // Cria os botões
        JButton botao1 = new JButton("Jogar");
        JButton botao2 = new JButton("Ranking");
        JButton botao3 = new JButton("Sair");

        Font font24Bold = new Font(titulo.getFont().getName(), Font.BOLD, 24);

        // Configura os parâmetros do GridBagLayout para centralizar e definir margens e preenchimento
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 100, 10, 100); // Define margens
        gbc.fill = GridBagConstraints.HORIZONTAL; // Preenchimento horizontal
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0; // Expande horizontalmente
        gbc.anchor = GridBagConstraints.CENTER; // Centraliza

        titulo.setFont(font24Bold);
        titulo.setHorizontalAlignment(JLabel.CENTER);

        panel.add(titulo, gbc);

        gbc.gridy = 1;
        panel.add(botao1, gbc);

        gbc.gridy = 2;
        panel.add(botao2, gbc);

        gbc.gridy = 3;
        panel.add(botao3, gbc);

        frame.setFocusable(true);
        frame.requestFocusInWindow();

        // Mapeia as teclas para ações
        InputMap inputMap = panel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "selectUp");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "selectDown");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "confirmSelection");

        // Mapeia as ações para os botões
        ActionMap actionMap = panel.getActionMap();
        actionMap.put("selectUp", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedButtonIndex > 0) {
                    selectedButtonIndex--;
                    updateButtonFocus(new JButton[]{botao1, botao2, botao3});
                }
            }
        });
        actionMap.put("selectDown", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedButtonIndex < 2) {
                    selectedButtonIndex++;
                    updateButtonFocus(new JButton[]{botao1, botao2, botao3});
                }
            }
        });
        actionMap.put("confirmSelection", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSelectedButton();
            }
        });

        // Define o foco inicial no primeiro botão
        botao1.setFocusable(true);
        botao2.setFocusable(false);
        botao3.setFocusable(false);

        // Adiciona o painel à janela
        frame.getContentPane().add(panel);

        // Exibe a janela
        frame.setVisible(true);
    }   
    */
}


