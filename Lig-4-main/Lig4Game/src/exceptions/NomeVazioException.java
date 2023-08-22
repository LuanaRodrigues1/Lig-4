package exceptions;

public class NomeVazioException extends Exception {
    public NomeVazioException() {
        super("O nome do jogador não pode estar vazio.");
    }
}