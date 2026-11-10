package test;

import controller.Cliente;
import controller.Menus;
import controller.Produto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {

    @Test
    public void testCompraComSucessoEVenda() {
        Cliente cliente = new Cliente("1", "João", "M", "9999", "12345678900", 200.0, "123");
        Produto produto = new Produto("P1", "Item Teste", 50.0, 5);
        Menus facade = new Menus();

        boolean comprou = facade.realizarCompra(cliente, produto, 2);
        System.out.println("[TESTE PRODUTO/VENDA] Compra realizada: " + comprou + " | Estoque restante do produto: " + produto.getQuantidadeEstoque());
        assertTrue(comprou);
        assertEquals(100.0, cliente.getTokens());
        assertEquals(3, produto.getQuantidadeEstoque());
    }
}