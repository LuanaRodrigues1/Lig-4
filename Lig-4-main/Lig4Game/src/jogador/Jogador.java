package jogador;

import java.awt.Color;

import exceptions.AtributoValorInvalidoException;

public class Jogador {
    private String nome;
    private int pontuacao;
    private Color corFicha;
    
    public Jogador(String nome, int pontos, Color cor) {
        try {
			this.setNome(nome);
		} catch (AtributoValorInvalidoException e) {
			System.err.println(e.getMessage());
		}
        try {
			this.setPontos(pontos);
		} catch (AtributoValorInvalidoException e) {
			System.err.println(e.getMessage());		
		}
        try {
			this.setCorFicha(cor);
		} catch (AtributoValorInvalidoException e) {
			System.err.println(e.getMessage());	
		}
    }
    
    public Color getCorFicha() {
        return corFicha;
    }
    
	public String getNome() {
		return nome;
	}
	
    public int getPontos() {
        return this.pontuacao;
    }
    
    public void setNome(String nome) throws AtributoValorInvalidoException {
        if (nome == null) {
            throw new AtributoValorInvalidoException("Nome não pode ser nulo.");
        }
        this.nome = nome;
    }

    public void setPontos(int pontuacao) throws AtributoValorInvalidoException {
        if (pontuacao < 0) {
            throw new AtributoValorInvalidoException("Pontos não podem ser um valor abaixo de 0.");
        }
        this.pontuacao = pontuacao;
    }
    
    public void setCorFicha(Color corFicha) throws AtributoValorInvalidoException {
        if (corFicha == null) {
            throw new AtributoValorInvalidoException("");
        }
        this.corFicha = corFicha;
    }
}
