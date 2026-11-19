package model;

// Implementação padrão das operações financeiras de depósito e compra com tokens
public class OperacoesImpl implements Operacoes {
    private double saldoTokens;

    public OperacoesImpl(double saldoInicial) {
        this.saldoTokens = saldoInicial;
    }

    // Soma ao saldo apenas depósitos maiores que zero
    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldoTokens += valor;
        }
    }

    // Efetua a compra e desconta do saldo caso haja tokens suficientes
    @Override
    public boolean comprar(double valor) {
        if (this.saldoTokens >= valor) {
            this.saldoTokens -= valor;
            return true;
        }
        return false;
    }

    public double getSaldoTokens() {
        return saldoTokens;
    }
}