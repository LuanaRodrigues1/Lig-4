package jogador;

public class jogador {
    private String nome;
    private String cor;
    private int pontos;  

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
        return this.cor;
    }
    
    public void setPontos(int p) {
        this.pontos = p;
    }

    public void status() {
        System.out.println("JOGADOR");
        System.out.println("Nome:" + this.nome);
        System.out.println("Cor:" + this.cor);
        System.out.println("Pontos:" + this.pontos);
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
