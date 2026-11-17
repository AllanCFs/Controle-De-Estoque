package estoque;

public class Produto {
    private String nome;
    private int quantidade;

    public Produto(String nome, int quantidadeInicial) {
        this.nome = nome;
        this.quantidade = Math.max(quantidadeInicial, 0);
    }

    public void adicionarUnidades(int qtd) {
        if (qtd > 0) {
            this.quantidade += qtd;
        }
    }

    public boolean retirarUnidades(int qtd) {
        if (qtd > 0 && qtd <= this.quantidade) {
            this.quantidade -= qtd;
            return true;
        }
        return false;
    }

    public int consultarSaldo() {
        return this.quantidade;
    }

    public String getNome() {
        return nome;
    }
}