package controller;

public class DescontoSemDesconto implements DescontoStrategy {
    @Override
    public double aplicarDesconto(double valorOriginal) {
        return valorOriginal;
    }
}