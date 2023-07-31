package jogador;

import java.awt.Color;

import excepitions.AtributoValorInvalidoException;

public class Jogador {
    private String nome;
    private Color cor;
    private int pontos;
    private String categoria;  
    
    public Jogador(String nome, int pontos) throws AtributoValorInvalidoException {
        this.setNome(nome);
        this.setPontos(pontos);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) throws AtributoValorInvalidoException {
        if (nome == null) {
            throw new AtributoValorInvalidoException("Nome não pode ser nulo.");
        }
        this.nome = nome;
    }

    public Color getCor() {
    	
        return this.cor;
    }
    
    public void setCor(Color cor) throws AtributoValorInvalidoException {
        if (cor == null) {
            throw new AtributoValorInvalidoException("Cor não pode ser nulo.");
        }
        this.cor = cor;
    }

    public void setPontos(int pontos) throws AtributoValorInvalidoException {
        if (pontos < 0) {
            throw new AtributoValorInvalidoException("Pontos não podem ser um valor abaixo de 0.");
        }
        this.pontos = pontos;
    }

    public String getCategoria() {
        return this.categoria;
    }

    private void setCategoria() {
        if (this.pontos <= 5) {
            this.categoria = "iniciante";
        } else if (this.pontos <= 15) {
            this.categoria = "mediano";
        } else {
            this.categoria = "avançado";
        }
    }

    public void status() {
        System.out.println("JOGADOR");
        System.out.println("Nome:" + this.nome);
        System.out.println("Cor:" + this.cor);
        System.out.println("Pontos:" + this.pontos);
        System.out.println(this.categoria);
    }
}
