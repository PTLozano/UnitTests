import java.util.Random;

public class Acao {
    public enum Status {
        Efetuado,
        ProblemaNaQuantidade,
        ProblemaNoValor
    }

    private String acao;

    private Status statusAcao;

    private int quantidade;

    private float valorCompra;

    private float valorAtual;

    private int quantidadeAtual;

    private boolean acaoDisponivel;

    private String[] acoes = {
            "VALE3",
            "PETR4",
            "MGLU3",
            "VVAR3"
    };

    public Acao(String acao) {
        acaoDisponivel = verificaDisponibilidade(acao);
        if (acaoDisponivel) {
            this.acao = acao;
            setValorAtual();
            setQuantidadeAtual();
        }
    }

    private boolean verificaDisponibilidade(String acao) {
        for (String temp : acoes) {
            if (temp.equals(acao)) {
                return true;
            }
        }

        return false;
    }

    public boolean acaoEstaDisponivel() {
        return acaoDisponivel;
    }

    public int getQuantidadeAtual() {
        return quantidadeAtual;
    }

    private void setQuantidadeAtual() {
        Random gerador = new Random();
        this.quantidadeAtual = gerador.nextInt(150) + 100;
    }

    public float getValorAtual() {
        return valorAtual;
    }

    private void setValorAtual() {
        Random gerador = new Random();
        this.valorAtual = gerador.nextInt(150);
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

    public Status executarOrdem() {
        if (getQuantidadeAtual() >= getQuantidadeCompra()) {
            if (Float.compare(((float) (getValorAtual() * 1.15)), getValorCompra()) >= 0 &&
                    Float.compare(((float) (getValorAtual() * 0.85)), getValorCompra()) <= 0) {
                this.quantidadeAtual -= getQuantidadeCompra();
                this.statusAcao = Status.Efetuado;
            } else {
                this.statusAcao = Status.ProblemaNoValor;
            }
        } else {
            this.statusAcao = Status.ProblemaNaQuantidade;
        }

        return statusOrdem();
    }

    public Status statusOrdem() {
        return this.statusAcao;
    }
}
