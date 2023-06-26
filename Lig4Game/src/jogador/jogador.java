package jogador;

public class jogador {
    private String nome;
    private String cor;
    private int pontos;
    private String categoria;  

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
        return this.pontos;
        this.setCategoria();
    }
    
    public void setPontos(int p) {
        this.pontos = p;
    }

    public void getCategoria() {
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

    public Jogador(String n, String c, int p) {
        this.setNome(n);
        this.setCor(c);
        this.setPontos(p);
    }

    jogador j1 = new jogador("Flávio", "Amarelo", 1);
    j1.status();

    jogador j2 = new jogador("Luana", "Verde", 2);
    j2.status();
}
