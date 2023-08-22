package exceptions;

public class NomeBotException extends Exception {
    public NomeBotException() {
        super("O nome do jogador não pode ser 'bot'.");
    }
}

