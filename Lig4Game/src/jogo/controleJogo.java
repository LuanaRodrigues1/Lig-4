package jogo;

import tabuleiro.Tabuleiro;

public class controleJogo{	
	private int rodadaAtual;
	private boolean statusJogo;
	
	public controleJogo(int RodadaAtual, boolean statusJogo) {
		this.statusJogo = statusJogo;
		this.rodadaAtual = RodadaAtual;
	}
	
	public void setRodadaAtual(int RodadaAtual) {
		this.rodadaAtual = RodadaAtual;
	}
	
	public int getRodadaAtual() {
		return this.rodadaAtual;
	}
	
	public boolean getStatusJogo() {
		return this.statusJogo;
	}
	
	public void alternarJogador(Tabuleiro tabuleiro, int coluna, String cor1, String cor2) {
        if(this.rodadaAtual % 2 == 0) {
        	tabuleiro.posicionarFicha(cor1, coluna-1);
        } else {
        	tabuleiro.posicionarFicha(cor2, coluna-1);
        }
	}
	
	public void iniciarJogo() {
		this.statusJogo = true;
	}
	
	public void pararJogo() {
		this.statusJogo = false;
	}
	
	public void finalizarJogo(Tabuleiro tabuleiro) {
		int maxRodadas = tabuleiro.nMaximoRodadas(); 
		
        if (this.rodadaAtual == maxRodadas) {
        	this.statusJogo = false;
        	
        }
	}
}