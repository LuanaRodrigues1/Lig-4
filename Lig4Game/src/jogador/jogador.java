package jogador;

public class jogador {
    private String nome;
    private String cor;
    private int pontos;
    private String categoria;  
    
    public jogador(String n, String c, int p) {
        this.setNome(n);
        this.setCor(c);
        this.setPontos(p);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String n) {
        this.nome = n;
    }

    public String getCor() {
        return this.cor;
    }
    
    public void setCor(String c) {
        this.cor = c;
    }

    public int getPontos() {
    	this.setCategoria();
        return this.pontos;
    }
    
    public void setPontos(int p) {
        this.pontos = p;
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
