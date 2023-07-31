package tabuleiro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import excepitions.AtributoValorInvalidoException;
import jogador.Jogador;

public class Lig4Turbo extends Tabuleiro {
    public Lig4Turbo(Jogador jogador1, Jogador jogador2) {
        super(jogador1, jogador2);
    }

    @Override
    public void posicionarFicha(int coluna) throws AtributoValorInvalidoException {
        int linha = QUANTIDADE_LINHAS - 1;
        boolean local = tabuleiro[linha][coluna].verificarCampo();
        
        if (!local) {
            super.posicionarFicha(coluna);
            mudarCor(linha, coluna, obterCorJogadorAtual());
        } else {
        	while (local && linha >= 0) {
        		local = tabuleiro[linha][coluna].verificarCampo();
        		
        		if (!local) {
                    super.posicionarFicha(coluna);
                    mudarCor(linha, coluna, obterCorJogadorAtual());
                }
        		
        		linha--;
        	}
        }
    }

    private void mudarCor(int linha, int coluna, Color cor) throws AtributoValorInvalidoException {
        int[][] direcao = { { 0, 1 }, { 0, -1 } };

        for (int[] dir : direcao) {
            int novaLinha = linha + dir[0];
            int novaColuna = coluna + dir[1];

            if (verificarCampo(novaLinha, novaColuna) && getCorFicha(novaLinha, novaColuna) != cor) {
                tabuleiro[novaLinha][novaColuna].setCorJogador(cor);
                novaLinha += dir[0];
                novaColuna += dir[1];
            }
        }
    }

    private Color obterCorJogadorAtual() {
        if (rodada % 2 == 0) {
            return Color.BLACK;
        } else {
            return Color.BLUE;
        }
    }

    private boolean verificarCampo(int linha, int coluna) {
        return linha >= 0 && linha < QUANTIDADE_LINHAS && coluna >= 0 && coluna < QUANTIDADE_COLUNAS;
    }

    private Color getCorFicha(int linha, int coluna) {
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
