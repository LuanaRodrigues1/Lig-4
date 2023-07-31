package tabuleiro;

import java.util.Random;

public class Lig4TurboMaluco extends Tabuleiro {
    private int nivelMaluco;

    public Lig4TurboMaluco(int quantidadeLinha, int quantidadeColuna, int nivelMaluco) {
        super(quantidadeLinha, quantidadeColuna);
        this.nivelMaluco = nivelMaluco;
    }

    @Override
    public void posicionarFicha(String JogadorCor, int coluna) {
        if (verificarCampo()) {
            super.posicionarFicha(JogadorCor, coluna);
            mudarCor(int quantidadeLinha, int quantidadeColuna, String cor);
        }
    }

    private void mudarCor(int quantidadeLinha, int quantidadeColuna, String cor) {
        int[][] direcao = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };
        Random random = new Random();

        for (int[] dir : direcao) {
            int newLinha = Linha + dir[0];
            int newColuna = coluna + dir[1];

            if (verificarCampo() && random.nextInt(100) < nivelMaluco) {
                super.posicionarFicha(newLinha, newColuna, new jogador(cor));
            }
        }
    }
}
