package controller;

import model.Usuario;

// Representa o usuário consumidor e gerencia o próprio saldo de tokens
public class Cliente extends Usuario {
    private String genero;
    private String codigoAmigo;
    private String cpf;
    private double tokens;
    private String senha;

    public Cliente(String id, String nome, String genero, String codigoAmigo, String cpf, double tokens, String senha) {
        super(id, nome);
        this.genero = genero;
        this.codigoAmigo = codigoAmigo;
        this.cpf = cpf;
        this.tokens = tokens;
        this.senha = senha;
    }

    // Adiciona tokens ao saldo apenas se o valor for positivo
    public void depositar(double valor) {
        if (valor > 0) {
            this.tokens += valor;
        }
    }

    // Debita o valor da compra se houver saldo suficiente
    public boolean comprar(double valor) {
        if (this.tokens >= valor) {
            this.tokens -= valor;
            return true;
        }
        return false;
    }

    public String getGenero() { return genero; }
    public String getCodigoAmigo() { return codigoAmigo; }
    public String getCpf() { return cpf; }
    public double getTokens() { return tokens; }
    public String getSenha() { return senha; }
}