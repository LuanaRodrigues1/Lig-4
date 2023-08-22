package tabuleiro;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.Random;

import exceptions.AtributoValorInvalidoException;
import jogador.Bot;
import jogador.Jogador;

public class Lig4TurboMaluco extends Tabuleiro {
    private int nivelMaluco = 15;
    
    public Lig4TurboMaluco(Jogador jogador1, Jogador jogador2) {
        super(jogador1, jogador2);
    }

    @Override
    public void posicionarFicha(int coluna, Jogador jogador1, Jogador jogador2) throws AtributoValorInvalidoException {
        int linha = 6;
        Campo[][] tabuleiro = getTabuleiro();
        
        boolean local = tabuleiro[linha][coluna].verificarCampo(); 
        
        if (!local) {
        	mudarCor(linha, coluna, obterCorJogadorAtual());
            super.posicionarFicha(coluna, jogador1, jogador2);
        } else {
        	while (local && linha >= 0) {
        		local = tabuleiro[linha][coluna].verificarCampo();
        		
        		if (!local) {
        			mudarCor(linha, coluna, obterCorJogadorAtual());
                    super.posicionarFicha(coluna, jogador1, jogador2);
                }
        		
        		linha--;
        	}
        }
    }
    
    @Override
    public void posicionarFicha(int coluna, Jogador jogador1, Bot bot) throws AtributoValorInvalidoException {
        int linha = 6;
        Campo[][] tabuleiro = getTabuleiro();
        
        boolean local = tabuleiro[linha][coluna].verificarCampo();
        
        if (!local) {
        	mudarCor(linha, coluna, obterCorJogadorAtual());
            super.posicionarFicha(coluna, jogador1, bot);
        } else {
        	while (local && linha >= 0) {
        		local = tabuleiro[linha][coluna].verificarCampo();
        		
        		if (!local) {
        			mudarCor(linha, coluna, obterCorJogadorAtual());
                    super.posicionarFicha(coluna, jogador1, bot);
                }
        		
        		linha--;
        	}
        }
    }

    private Point encontrarPosicaoVaziaFichaVazia(int linha, int coluna, Jogador jogador) {
        Campo[][] tabuleiro = getTabuleiro();
        
        int[] possibilidadesDirecaoLinha = { 1, -1, 0 };
        int[] possibilidadesDirecaoColuna = { -1, 0, 1 };
        
        Random random = new Random();
        
        for (int i = 0; i < possibilidadesDirecaoLinha.length; i++) {
            int novaLinha = linha + possibilidadesDirecaoLinha[i];
            int novaColuna = coluna + possibilidadesDirecaoColuna[random.nextInt(3)];
            
            if (novaLinha >= 0 && novaLinha < 7 && novaColuna >= 0 && novaColuna < 7 &&
                tabuleiro[novaLinha][novaColuna].verificarCampo() && getCorFicha(linha, novaColuna) != jogador.getCorFicha()) {
                return new Point(novaLinha, novaColuna);
            }
        }
        
        return null; 
    }

    private void mudarCor(int linha, int coluna, Jogador jogador) throws AtributoValorInvalidoException {
        Campo[][] tabuleiro = getTabuleiro();
        
        Point novaPosicao = encontrarPosicaoVaziaFichaVazia(linha, coluna, jogador);
        Random random = new Random();
        
        nivelMaluco += 5;
        
        if (novaPosicao != null && random.nextInt(120) < nivelMaluco) {
            tabuleiro[novaPosicao.x][novaPosicao.y].setCorJogador(jogador);
        }
    }
    
    
    private Jogador obterCorJogadorAtual() {
        if (getRodada() % 2 == 0) {
            return getJogador1();
        } else {
        	if (getJogador2() == null) {
        		return getBot();
        	} else {
        		return getJogador2();
        	}
        }
    }

    private Color getCorFicha(int linha, int coluna) {
    	Campo[][] tabuleiro = getTabuleiro();
    	
        Campo ficha = tabuleiro[linha][coluna];
        return ficha == null ? null : ficha.getCorJogador();
    }

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void posicionarFicha(int coluna) throws AtributoValorInvalidoException {}
}

