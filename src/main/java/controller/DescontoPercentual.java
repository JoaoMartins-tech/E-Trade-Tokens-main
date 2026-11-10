package controller;

public class DescontoPercentual implements DescontoStrategy {
    private double percentual;

    public DescontoPercentual(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double aplicarDesconto(double valorOriginal) {
        return valorOriginal * (1 - percentual);
    }
}