package tabuleiro;

import javax.swing.*;
import javax.swing.border.*;
import interfaceGrafica.ElementosVisuais;
import jogador.Jogador;
import java.awt.*;
import javax.swing.border.Border;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import excepitions.AtributoValorInvalidoException;


public abstract class Tabuleiro extends JFrame implements KeyListener, TabuleiroInterface {
	// Atributos para o próprio tabuleiro
    protected Campo[][] tabuleiro = new Campo[QUANTIDADE_LINHAS][QUANTIDADE_COLUNAS];

    // Atributos para o sistema de verificação
    protected int posicaoBolinha = 1;
    protected Color corBolinha = Color.BLUE;
    
    // Atributos para intercalar jogadores
    protected int rodada = 0;
    private Jogador jogador1;
    private Jogador jogador2;
    
    // Construtor
    public Tabuleiro(Jogador jogador1, Jogador jogador2) {
    	// definir os jogadores da rodada
    	this.jogador1 = jogador1;
    	this.jogador2 = jogador2;
    	
        montarTabuleiro();
        addKeyListener(this);
    }

    @Override
    public void montarTabuleiro() {
        setSize(900, 900);
        setTitle("Tabuleiro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel painelExterno = new JPanel();
        painelExterno.setBorder(new EmptyBorder(100, 300, 100, 300));

        JPanel painelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel labelTitulo = new JLabel("Conect 4");
        ElementosVisuais.modificarFonteTexto(labelTitulo); // Opcional: caso tenha essa classe para modificar a fonte
        painelTitulo.setBorder(new EmptyBorder(0, 0, 40, 0));
        painelTitulo.add(labelTitulo);

        painelExterno.add(painelTitulo);
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

        setVisible(true);
    }

    @Override
    public void posicionarFicha(int coluna) throws AtributoValorInvalidoException {
        int linha = QUANTIDADE_LINHAS - 1;
        boolean local = tabuleiro[linha][coluna].verificarCampo();
        
        if (!local) {
            tabuleiro[linha][coluna].adicionarFicha();
            if(rodada%2==0) {
            	tabuleiro[linha][coluna].setCorJogador(Color.BLACK);
            	setCorBolinha(Color.BLUE);

            } else {
            	tabuleiro[linha][coluna].setCorJogador(Color.BLUE);
            	setCorBolinha(Color.BLACK);
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
                    	tabuleiro[linha][coluna].setCorJogador(Color.BLACK);
                    	setCorBolinha(Color.BLUE);

                    } else {
                    	tabuleiro[linha][coluna].setCorJogador(Color.BLUE);
                    	setCorBolinha(Color.BLACK);
                    }
                 
                    if (verificarGanhador(linha, coluna)) {
                        definirVencedor();
                        return;
                    }
                }

                linha--;
            }
        }
    }
    
    @Override
    public void definirVencedor() {
        if (rodada % 2 == 0) {
            JOptionPane.showMessageDialog(this, jogador1.getNome() + " venceu!");
        } else {
            JOptionPane.showMessageDialog(this, jogador2.getNome() + " venceu!");
        } 
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
            static final int NUMERO_QUADRADOS_LINHA = 7;
            static final int TAMANHO_QUADRADO = 50;
            static final int TAMANHO_BOLINHA = 30;
       
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < NUMERO_QUADRADOS_LINHA; i++) {
                    int x = i * TAMANHO_QUADRADO;
                    int y = 0;
                    g.setColor(Color.BLACK);
                    Border borda = BorderFactory.createLineBorder(Color.BLACK);
                    setBorder(borda);
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
                    try {
						posicionarFicha(posicaoBolinha - 1);
					} catch (AtributoValorInvalidoException e1) {
						e1.printStackTrace();
					} 
                }
            }
        });

        // Esse método retornará o panel feito para adicionarmos na janela
        return escolherColunaPanel;
    }


    
    // get e set
    
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
    
    public void setCorBolinha(Color corBolinha) throws AtributoValorInvalidoException {
    	if (corBolinha == null) {
    		throw new AtributoValorInvalidoException("A cor não pode ser nula");
    	}
        this.corBolinha = corBolinha;
        repaint();
    }
    
    public Jogador getJogador1() {
        return jogador1;
    }

    public void setJogador1(Jogador jogador1) throws AtributoValorInvalidoException {
    	if (jogador1 == null) {
    		throw new AtributoValorInvalidoException("Não existe jogador");
    	}
        this.jogador1 = jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }

    public void setJogador2(Jogador jogador2) throws AtributoValorInvalidoException {
    	if (jogador2 == null) {
    		throw new AtributoValorInvalidoException("Não existe jogador");
    	}
        this.jogador2 = jogador2;
    }
}


