package model;

public class OperacoesImpl implements Operacoes {
    private double saldoTokens;

    public OperacoesImpl(double saldoInicial) {
        this.saldoTokens = saldoInicial;
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldoTokens += valor;
        }
    }

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