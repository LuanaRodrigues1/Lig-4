package jogo;

import tabuleiro.Tabuleiro;

import java.util.Scanner;

import jogador.jogador;

public class Jogo {	
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro();
        jogador jogador1 = new jogador("Luana", "L", 0); 
        jogador jogador2 = new jogador("Flávio", "F", 0); 
        controleJogo controlador = new controleJogo(1, true);
        
        String cor1 = jogador1.getCor();
        String cor2 = jogador2.getCor();
        int rodadaAtual = controlador.getRodadaAtual();
        
        Scanner InputColuna = new Scanner(System.in);
   
        while (controlador.getStatusJogo()) {
        	System.out.println(rodadaAtual);
            System.out.print("Digite a coluna: ");
            int coluna = InputColuna.nextInt();
            
            controlador.alternarJogador(tabuleiro, coluna, cor1, cor2);
            
            tabuleiro.mostrarTabuleiro();
            
            controlador.setRodadaAtual(rodadaAtual++);
            
            controlador.finalizarJogo(tabuleiro);
        }
        
        InputColuna.close();  
    }
}