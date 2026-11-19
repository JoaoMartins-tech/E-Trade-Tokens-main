package controller;

// Facade que centraliza e simplifica o fluxo de compra de produtos com tokens
public class Menus {

    // Sobrecarga para compras sem política de desconto
    public boolean realizarCompra(Cliente cliente, Produto produto, int quantidade) {
        return realizarCompra(cliente, produto, quantidade, null);
    }

    // Valida estoque, aplica o desconto (Strategy) e delega o débito ao Cliente (Information Expert)
    public boolean realizarCompra(Cliente cliente, Produto produto, int quantidade, DescontoStrategy descontoStrategy) {
        double valorBruto = produto.getPrecoTokens() * quantidade;
        double valorFinal = (descontoStrategy != null) 
            ? descontoStrategy.aplicarDesconto(valorBruto) 
            : valorBruto;

        // Cancela a compra se não houver unidades suficientes em estoque
        if (produto.getQuantidadeEstoque() < quantidade) {
            return false;
        }

        // Efetiva o débito de saldo no cliente e atualiza o estoque
        if (cliente.comprar(valorFinal)) {
            produto.debitarEstoque(quantidade);
            return true;
        }
        return false;
    }
}