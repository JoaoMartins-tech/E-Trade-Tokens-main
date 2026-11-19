package controller;

// Estratégia concreta (Pattern Strategy / Null Object) que mantém o valor integral sem desconto
public class DescontoSemDesconto implements DescontoStrategy {

    // Retorna o valor original da compra sem nenhuma alteração
    @Override
    public double aplicarDesconto(double valorOriginal) {
        return valorOriginal;
    }
}