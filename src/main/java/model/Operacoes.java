package model;

// Interface que define o contrato básico das operações financeiras de carteira em tokens
public interface Operacoes {

    // Adiciona uma quantia positiva de tokens ao saldo
    void depositar(double valor);

    // Debita o valor da compra se houver saldo suficiente, retornando o status da operação
    boolean comprar(double valor);
}