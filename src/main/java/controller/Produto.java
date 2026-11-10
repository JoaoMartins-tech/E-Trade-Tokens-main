package controller;

public class Produto {
    private String id;
    private String nome;
    private double precoTokens;
    private int quantidadeEstoque;

    public Produto(String id, String nome, double precoTokens, int quantidadeEstoque) {
        this.id = id;
        this.nome = nome;
        this.precoTokens = precoTokens;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public boolean debitarEstoque(int qtd) {
        if (this.quantidadeEstoque >= qtd) {
            this.quantidadeEstoque -= qtd;
            return true;
        }
        return false;
    }

    public String getId() { return id; }
    public String getNome() { return nome; }
    public double getPrecoTokens() { return precoTokens; }
    public int getQuantidadeEstoque() { return quantidadeEstoque; }
}