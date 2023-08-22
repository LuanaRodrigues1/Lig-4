package exceptions;

public class NomeLongoException extends Exception {
    public NomeLongoException() {
        super("O nome do jogador não pode ter mais de 20 caracteres.");
    }
}
