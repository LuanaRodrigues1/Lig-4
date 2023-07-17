package tabuleiro;

public class Lig4Turbo extends Tabuleiro {
    public Lig4Turbo(int quantidadeLinha, int quantidadeColuna, Campo[][] tabuleiro) {
        super(quantidadeLinha, quantidadeColuna, tabuleiro);
    }

    @Override
    public void posicionarFicha(String JogadorCor, int coluna) {
        if (verificarCampo()) {
            super.posicionarFicha(JogadorCor, coluna);
            mudarCor(int quantidadeLinha, int quantidadeColuna, String cor);
        }
    }

    private void mudarCor(int quantidadeLinha, int quantidadeColuna, String cor) {
        int[][] direcao = { { 0, 1 }, { 0, -1 } };

        for (int[] dir : direcao) {
            int newLinha = linha + dir[0];
            int newColuna = coluna + dir[1];

            while (verificarCampo() && getFichaCor(newLinha, newColuna) != cor) {
                super.posicionarFicha(newLinha, newColuna, new jogador(cor));
                newLinha += dir[0];
                newColuna += dir[1];
            }
        }
    }

    private String getFichaCor(int quantidadeLinha, int quantidadeColuna) {
        Campo ficha = super.tabuleiro[quantidadeLinha][quantidadeColuna];
        return ficha == null ? "" : jogador.getCor();
    }

}
