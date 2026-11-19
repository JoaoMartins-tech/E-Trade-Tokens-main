package controller;

// Estratégia concreta (Pattern Strategy) que aplica um desconto percentual sobre o valor da compra
public class DescontoPercentual implements DescontoStrategy {
    private double percentual;

    // Recebe a taxa de desconto em formato decimal (ex: 0.10 para 10%)
    public DescontoPercentual(double percentual) {
        this.percentual = percentual;
    }

    // Calcula e retorna o valor final após abater o percentual de desconto
    @Override
    public double aplicarDesconto(double valorOriginal) {
        return valorOriginal * (1 - percentual);
    }
}