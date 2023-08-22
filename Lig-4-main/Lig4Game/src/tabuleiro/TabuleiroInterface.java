package tabuleiro;

import javax.swing.JPanel;

import exceptions.AtributoValorInvalidoException;
import jogador.Bot;
import jogador.Jogador;

public interface TabuleiroInterface {
    static final int QUANTIDADE_LINHAS = 7;
    static final int QUANTIDADE_COLUNAS = 7;
    static final int LIMITE_DE_RODADAS = 49;
    
    // Criar estrutura de tabuleiro
    public abstract void montarTabuleiro();
    public abstract void posicionarFicha(int coluna, Jogador jogador1, Jogador jogador2) throws AtributoValorInvalidoException;
    public abstract void posicionarFicha(int coluna, Jogador jogador1, Bot bot) throws AtributoValorInvalidoException;
    public abstract JPanel criarEscolherColuna();
    public abstract void moverBolinha(int novaPosicao) throws AtributoValorInvalidoException;
    
    // Sistema de vericação de vencedor
    public abstract void definirVencedor();
    public abstract boolean verificarGanhador(int linha, int coluna);
	
	
}
