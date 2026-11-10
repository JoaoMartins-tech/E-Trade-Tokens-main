package controller;

public class Menus {

    public boolean realizarCompra(Cliente cliente, Produto produto, int quantidade) {
        return realizarCompra(cliente, produto, quantidade, null);
    }


    public boolean realizarCompra(Cliente cliente, Produto produto, int quantidade, DescontoStrategy descontoStrategy) {
        double valorBruto = produto.getPrecoTokens() * quantidade;
        double valorFinal = (descontoStrategy != null) 
            ? descontoStrategy.aplicarDesconto(valorBruto) 
            : valorBruto;

        if (produto.getQuantidadeEstoque() < quantidade) {
            return false;
        }

        if (cliente.getTokens() >= valorFinal) {
            if (cliente.comprar(valorFinal)) {
                produto.debitarEstoque(quantidade);
                return true;
            }
        }
        return false;
    }
}