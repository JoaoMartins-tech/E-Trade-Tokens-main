package view;

import controller.Cliente;
import controller.Menus;
import controller.Produto;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("1", "João", "M", "9999", "12345678900", 200.0, "123");
        Produto produto = new Produto("P1", "Cupom Desconto", 50.0, 10);
        Menus facade = new Menus();

        boolean sucesso = facade.realizarCompra(cliente, produto, 2, null);
        System.out.println("Compra realizada: " + sucesso);
        System.out.println("Saldo final do cliente: " + cliente.getTokens());
    }
}