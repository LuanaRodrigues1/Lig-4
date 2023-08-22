package exceptions;

public class ColunaInvalidaExcepition extends Exception{
    public ColunaInvalidaExcepition() {
        super("A coluna escolhida é inválida");
    }
}
