package controller;

// Interface do padrão Strategy que define o contrato para políticas de cálculo de desconto
public interface DescontoStrategy {

    // Recebe o valor bruto da compra e retorna o valor final após aplicar a regra de desconto
    double aplicarDesconto(double valorOriginal);
}