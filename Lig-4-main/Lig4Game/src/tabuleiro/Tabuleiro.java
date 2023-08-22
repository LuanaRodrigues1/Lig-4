package tabuleiro;


import javax.swing.*;

import javax.swing.border.*;
import interfaceGrafica.ElementosVisuais;
import jogador.Bot;
import jogador.Jogador;
import personalizar.PersonalizarJogadores;
import ranking.ArquivoCsv;
import ranking.FinalizarJogo;
import java.awt.*;
import javax.swing.border.Border;

import exceptions.AtributoValorInvalidoException;
import exceptions.ColunaInvalidaExcepition;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


public abstract class Tabuleiro extends JFrame implements KeyListener, TabuleiroInterface {
	// Atributos para o próprio tabuleiro
    private Campo[][] tabuleiro = new Campo[QUANTIDADE_LINHAS][QUANTIDADE_COLUNAS];

    // Atributos para o sistema de verificação
    private int posicaoBolinha = 1;
    private Color corBolinha = Color.BLACK;
    
    // Atributos para intercalar jogadores
    private int rodada = 1;
    private Jogador jogador1 = null;
    private Jogador jogador2 = null;
    private Bot bot = new Bot("bot", 0, Color.ORANGE);
         
    // Construtor
    public Tabuleiro(Jogador jogador1, Jogador jogador2) {
    	this.jogador1 = jogador1;
    	this.jogador2 = jogador2;

        montarTabuleiro();
        addKeyListener(this);
    }

    @Override
    public void montarTabuleiro() {
        setContentPane(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/images/fundo.jpg"));
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        });
        
        setLayout(new GridBagLayout());
        
        setSize(900, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel painelExterno = new JPanel();
        painelExterno.setPreferredSize(new Dimension(500, 700));
        painelExterno.setOpaque(false);
        painelExterno.setBorder(new EmptyBorder(100, 300, 100, 300));
        painelExterno.add(criarEscolherColuna());

        JPanel painelTabuleiro = new JPanel(new GridLayout(QUANTIDADE_LINHAS, QUANTIDADE_COLUNAS));

        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                tabuleiro[i][j] = new Campo();
                painelTabuleiro.add(tabuleiro[i][j]);
            }
        }

        painelExterno.add(painelTabuleiro);

        add(painelExterno);

        setPreferredSize(new Dimension(900, 900));
        pack(); 
        setVisible(true);
    }

    public void posicionarFicha(int coluna, Jogador jogador1, Jogador jogador2) throws AtributoValorInvalidoException {
        int linha = 6;
        boolean local = tabuleiro[linha][coluna].verificarCampo();
        
        try {
        	if (coluna < 0 || coluna > 6) {
        		throw new ColunaInvalidaExcepition();
        	}
	        if (!local) {
	            tabuleiro[linha][coluna].adicionarFicha();
	            if(rodada%2==0) {
	            	tabuleiro[linha][coluna].setCorJogador(jogador1);
	            	setCorBolinha(jogador2);
	
	            } else {
	            	tabuleiro[linha][coluna].setCorJogador(jogador2);
	            	setCorBolinha(jogador1);
	            }
	            
	            if (verificarGanhador(linha, coluna)) {
	                definirVencedor();
	                return;
	            }
	        } else {
	            while (local && linha >= 0) {
	                local = tabuleiro[linha][coluna].verificarCampo();
	
	                if (!local) {
	                    tabuleiro[linha][coluna].adicionarFicha();
	                    if(rodada%2==0) {
	                    	tabuleiro[linha][coluna].setCorJogador(jogador1);
	                    	setCorBolinha(jogador2);
	
	                    } else {
	                    	tabuleiro[linha][coluna].setCorJogador(jogador2);
	                    	setCorBolinha(jogador1);
	                    }
	                 
	                    if (verificarGanhador(linha, coluna)) {
	                        definirVencedor();
	                        return;
	                    }
	                }
	
	                linha--;
	            }
	        }
        } catch (ColunaInvalidaExcepition e1) {
        	JOptionPane.showMessageDialog(Tabuleiro.this, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public void posicionarFicha(int coluna, Jogador jogador1, Bot bot) throws AtributoValorInvalidoException {
        int linha = 6;
        boolean local = tabuleiro[linha][coluna].verificarCampo();
        
        try {
        	if (coluna < 0 || coluna > 6) {
        		throw new ColunaInvalidaExcepition();
        	}
        	
	        if (!local) {
	            tabuleiro[linha][coluna].adicionarFicha();
	            if(rodada%2==0) {
	            	tabuleiro[linha][coluna].setCorJogador(jogador1);
	            	setCorBolinha(bot);
	
	            } else {
	            	tabuleiro[linha][coluna].setCorJogador(bot);
	            	setCorBolinha(jogador1);
	            }
	            
	            if (verificarGanhador(linha, coluna)) {
	                definirVencedor();
	                return;
	            }
	            
	        } else {
	            while (local && linha >= 0) {
	                local = tabuleiro[linha][coluna].verificarCampo();
	
	                if (!local) {
	                    tabuleiro[linha][coluna].adicionarFicha();
	                    if(rodada%2==0) {
	                    	tabuleiro[linha][coluna].setCorJogador(jogador1);
	                    	setCorBolinha(bot);
	
	                    } else {
	                    	tabuleiro[linha][coluna].setCorJogador(bot);
	                    	setCorBolinha(jogador1);
	                    }
	                 
	                    if (verificarGanhador(linha, coluna)) {
	                        definirVencedor();
	                        return;
	                    }
	                }
	
	                linha--;
	            }
	        }
        } catch (ColunaInvalidaExcepition e1) {
        	JOptionPane.showMessageDialog(Tabuleiro.this, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    @Override
    public void definirVencedor() {
    	try {
			this.jogador1.setPontos(0);
		} catch (AtributoValorInvalidoException e) {
			System.err.println(e.getMessage());	
		}
    	
        String modoDeJogo = PersonalizarJogadores.getModoDeJogo();
        int pontosPorVencedor;

		if ("Tradicional".equals(modoDeJogo)) {
			pontosPorVencedor = 1;
        } else if ("Turbo".equals(modoDeJogo)) {
        	pontosPorVencedor = 2;
        } else {
        	pontosPorVencedor = 3;
        }
    	
        if (rodada % 2 == 0) { 
        	try {
				this.jogador1.setPontos(this.jogador1.getPontos()+pontosPorVencedor);
			} catch (AtributoValorInvalidoException e) {
				System.err.println(e.getMessage());	
			}
		
        } else if (jogador2 == null) {
            try {
				bot.setPontos(bot.getPontos()+pontosPorVencedor);
			} catch (AtributoValorInvalidoException e) {
				System.err.println(e.getMessage());	
			}
        } else {
        	try {
    			this.jogador2.setPontos(0);
    		} catch (AtributoValorInvalidoException e) {
    			System.err.println(e.getMessage());	
    		}
        	
            try {
				jogador2.setPontos(jogador2.getPontos()+pontosPorVencedor);
			} catch (AtributoValorInvalidoException e) {
				System.err.println(e.getMessage());	
			}
        }

        
        FinalizarJogo telaVencedor = new FinalizarJogo(jogador1, jogador2, bot);
        telaVencedor.setVisible(true);
        dispose();
	
    }
    
    
    @Override
    public boolean verificarGanhador(int linha, int coluna) {
        Color corJogador = tabuleiro[linha][coluna].getCorJogador();
        
        // VERTICAL
        int contadorFichaVertical = 1;
        for (int i = linha + 1; i < QUANTIDADE_LINHAS; i++) {
            if (tabuleiro[i][coluna].getCorJogador() == corJogador) {
            	contadorFichaVertical++;
            } else {
                break;
            }
        }
        for (int i = linha - 1; i >= 0; i--) {
            if (tabuleiro[i][coluna].getCorJogador() == corJogador) {
            	contadorFichaVertical++;
            } else {
                break;
            }
        }

        // HORIZONTAL
        int contadorFichasHorizontal = 1;
        for (int j = coluna - 1; j >= 0; j--) {
            if (tabuleiro[linha][j].getCorJogador() == corJogador) {
            	contadorFichasHorizontal++;
            } else {
                break;
            }
        }
        for (int j = coluna + 1; j < QUANTIDADE_COLUNAS; j++) {
            if (tabuleiro[linha][j].getCorJogador() == corJogador) {
            	contadorFichasHorizontal++;
            } else {
                break;
            }
        }

        // DIAGONAL DIREITA
        int contadorFichasDiagonalDireita = 1;
        for (int i = linha - 1, j = coluna - 1; i >= 0 && j >= 0; i--, j--) {
            if (tabuleiro[i][j].getCorJogador() == corJogador) {
            	contadorFichasDiagonalDireita++;
            } else {
                break;
            }
        }
        for (int i = linha + 1, j = coluna + 1; i < QUANTIDADE_LINHAS && j < QUANTIDADE_COLUNAS; i++, j++) {
            if (tabuleiro[i][j].getCorJogador() == corJogador) {
            	contadorFichasDiagonalDireita++;
            } else {
                break;
            }
        }

        // DIAGONAL ESQUERDA
        int contadorFichasDiagonalEsquerda = 1;
        for (int i = linha - 1, j = coluna + 1; i >= 0 && j < QUANTIDADE_COLUNAS; i--, j++) {
            if (tabuleiro[i][j].getCorJogador() == corJogador) {
            	contadorFichasDiagonalEsquerda++;
            } else {
                break;
            }
        }
        for (int i = linha + 1, j = coluna - 1; i < QUANTIDADE_LINHAS && j >= 0; i++, j--) {
            if (tabuleiro[i][j].getCorJogador() == corJogador) {
            	contadorFichasDiagonalEsquerda++;
            } else {
                break;
            }
        }

        // VERIFICAR SE EXISTE UM VENCEDOR
        if (contadorFichaVertical >= 4 || contadorFichasHorizontal >= 4 || contadorFichasDiagonalDireita >= 4 || contadorFichasDiagonalEsquerda >= 4) {
            return true;
        }

        // Se não existir vencedor ele continuará o jogo normalmente
        return false;
    }
    
    // Sistema de escolher a coluna
    @Override
    public JPanel criarEscolherColuna() {
        JPanel escolherColunaPanel = new JPanel() {
            private static final int NUMERO_QUADRADOS_LINHA = 7;
            private static final int TAMANHO_QUADRADO = 70;
            private static final int TAMANHO_BOLINHA = 50;
            private Color backgroundColor = new Color(223, 222, 222);
            private Color borderColor = new Color(185, 161, 169);
       
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < NUMERO_QUADRADOS_LINHA; i++) {
                    int x = i * TAMANHO_QUADRADO;
                    int y = 0;
                    
                    g.setColor(Color.BLACK);
                    Border borda = BorderFactory.createLineBorder(borderColor);
                    setBorder(borda);
                    setBackground(backgroundColor);
                    
                    g.drawRect(x, y, TAMANHO_QUADRADO, TAMANHO_QUADRADO);
                    if (i == posicaoBolinha - 1) {
                        g.setColor(corBolinha);
                        g.fillOval(x + (TAMANHO_QUADRADO / 2) - (TAMANHO_BOLINHA / 2),
                                y + (TAMANHO_QUADRADO / 2) - (TAMANHO_BOLINHA / 2), TAMANHO_BOLINHA, TAMANHO_BOLINHA);
                    }
                }
            }
        };

        // aqui mexe na dimensão do quadrado
        escolherColunaPanel.setPreferredSize(new Dimension(Campo.TAMANHO_QUADRADO * QUANTIDADE_COLUNAS, Campo.TAMANHO_QUADRADO));
        
        escolherColunaPanel.setFocusable(true);
        
        // Sistema de cliques -> S - Bolinha para a direita, A - Bolinha para a esquerda, D -> Seria nosso "Enter"
        escolherColunaPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    try {
						moverBolinha(posicaoBolinha + 1);
					} catch (AtributoValorInvalidoException e1) {						
						e1.printStackTrace();
					}
                } else if (e.getKeyCode() == KeyEvent.VK_A) {
                    try {
						moverBolinha(posicaoBolinha - 1);
					} catch (AtributoValorInvalidoException e1) {
						e1.printStackTrace();
					}
                } else if (e.getKeyCode() == KeyEvent.VK_D) {
                	rodada++;
                	if (verificaQuantidadeRodadas(50)) {
                        FinalizarJogo telaVencedor = new FinalizarJogo(jogador1, jogador2, bot);
                        telaVencedor.setVisible(true);
                        dispose();
                	}
                    try {
                        if (jogador2 == null) {
                        	posicionarFicha(posicaoBolinha - 1, jogador1, bot);
                        	
                        	rodada++;
                        	if (verificaQuantidadeRodadas(50)) {
                                FinalizarJogo telaVencedor = new FinalizarJogo(jogador1, jogador2, bot);
                                telaVencedor.setVisible(true);
                                dispose();
                        	}
                        	
                            int coluna = bot.escolherColuna();
                            posicionarFicha(coluna, jogador1, bot);
                        } else {
                        	posicionarFicha(posicaoBolinha - 1, jogador1, jogador2);
                        }
                            
                    } catch (AtributoValorInvalidoException e1) {
                        e1.printStackTrace();
                    }
                } 
            }
        });

        return escolherColunaPanel;
    }
    
    public boolean verificaQuantidadeRodadas(int quantidadeDesejada) {
        return rodada >= quantidadeDesejada;
    }

    // get e set
    
    public Campo[][] getTabuleiro() {
        return tabuleiro;
    }

    public int getRodada() {
        return rodada;
    }

    public Bot getBot() {
        return bot;
    }
    
    public Jogador getJogador1() {
        return jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }
    
    public void setCorBolinha(Jogador jogador) {
        this.corBolinha = jogador.getCorFicha();
        repaint();
    }
    
    public void setCorBolinha(Bot bot) {
        this.corBolinha = bot.getCorFicha();
        repaint();
    }
    
    // é como se fosse um set, ele ficará mudando o valor da posição da bolinha
    @Override
    public void moverBolinha(int novaPosicao) throws AtributoValorInvalidoException {
        if (novaPosicao >= 1 && novaPosicao <= QUANTIDADE_LINHAS) {
            posicaoBolinha = novaPosicao;
            repaint();
        } else {
        	throw new AtributoValorInvalidoException("Essa posição não é válida");
        } 
    }
}


