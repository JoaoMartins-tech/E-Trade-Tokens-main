package controller;

import model.Usuario;

// Representa uma empresa parceira e gerencia sua carteira corporativa de tokens
public class Empresa extends Usuario {
    private String cnpj;
    private String email;
    private double tokens;
    private String senha;

    public Empresa(String id, String nome, String cnpj, String email, double tokens, String senha) {
        super(id, nome);
        this.cnpj = cnpj;
        this.email = email;
        this.tokens = tokens;
        this.senha = senha;
    }

    // Credita tokens na conta da empresa quando o valor é positivo
    public void depositar(double valor) {
        if (valor > 0) {
            this.tokens += valor;
        }
    }

    // Debita tokens da carteira da empresa se houver saldo disponível
    public boolean comprar(double valor) {
        if (this.tokens >= valor) {
            this.tokens -= valor;
            return true;
        }
        return false;
    }

    public String getCnpj() { return cnpj; }
    public String getEmail() { return email; }
    public double getTokens() { return tokens; }
    public String getSenha() { return senha; }
}