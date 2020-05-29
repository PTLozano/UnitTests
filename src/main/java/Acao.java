import java.util.Random;
import java.util.Vector;

public class Acao {
    private String acao;

    private int quantidade;

    private float valorCompra;

    private boolean ordemExecutada;

    private float valorAtual;

    private int quantidadeAtual;

    private Vector<Acao> listaAcoes;

    public Acao(String acao) {
        Random gerador = new Random();
        this.acao = acao;
        this.valorAtual = gerador.nextInt(150);
        this.quantidadeAtual = gerador.nextInt(150) + 100;
    }

    public void geraListaAcoes(){
        String[] acoes = new String[4];
        acoes[0] = "VALE3";
        acoes[1] = "PETR4";
        acoes[2] = "MGLU3";
        acoes[3] = "VVAR3";

        listaAcoes = new Vector<Acao>();
        for (int i = 0; i < acoes.length; i++) {
            listaAcoes.add(new Acao(acoes[i]));
        }
    }

    public int getQuantidadeAtual() {
        return quantidadeAtual;
    }

    public float getValorAtual() {
        return valorAtual;
    }

    public int getQuantidadeCompra() {
        return quantidade;
    }

    public void setQuantidadeCompra(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(float valorCompra) {
        this.valorCompra = valorCompra;
    }

    public boolean ordemExecutada() {
        return ordemExecutada;
    }

    public boolean executarOrdem() {
        if(getQuantidadeAtual() >= getQuantidadeCompra() &&
            Float.compare(((float) (getValorAtual() * 1.15)), getValorCompra()) >= 0 &&
            Float.compare(((float) (getValorAtual() * 0.85)), getValorCompra()) <= 0) {
            this.quantidadeAtual -= getQuantidadeCompra();
            this.ordemExecutada = true;
        }
        else{
            this.ordemExecutada = false;
        }

        return ordemExecutada();
    }
}
