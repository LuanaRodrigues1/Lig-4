package tabuleiro;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Random;
import exceptions.AtributoValorInvalidoException;
import jogador.Bot;
import jogador.Jogador;

public class Lig4Turbo extends Tabuleiro {
    public Lig4Turbo(Jogador jogador1, Jogador jogador2) {
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

    private void mudarCor(int linha, int coluna, Jogador jogador) throws AtributoValorInvalidoException {
    	Campo[][] tabuleiro = getTabuleiro();
    	
        int[] possibilidadesDirecao = { 1, -1 };
        
        Random random = new Random();
        int numAleatorio = random.nextInt(2);
        
        int novaColuna = coluna + possibilidadesDirecao[numAleatorio];
 
        if (novaColuna < 0 || novaColuna > 6) {
        	return;
        } else if (tabuleiro[linha][novaColuna].verificarCampo() && getCorFicha(linha, novaColuna) != jogador.getCorFicha()) {
            tabuleiro[linha][novaColuna].setCorJogador(jogador);
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
}
