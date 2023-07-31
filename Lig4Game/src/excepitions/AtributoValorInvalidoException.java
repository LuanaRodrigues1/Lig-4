package excepitions;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AtributoValorInvalidoException extends Exception {
	
    public AtributoValorInvalidoException(String mensagem) {
    	super(mensagem);
    }
}
