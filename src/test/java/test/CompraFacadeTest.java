package test;

import controller.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompraFacadeTest {

    @Test
    public void testRealizarCompraComSucessoPadrao() {
        Cliente cliente = new Cliente("1", "João", "M", "9999", "12345678900", 200.0, "123");
        Produto produto = new Produto("P1", "Cupom Desconto", 50.0, 10);
        Menus facade = new Menus();

        boolean comprou = facade.realizarCompra(cliente, produto, 2);
        System.out.println("[TESTE FACADE] Compra padrão realizada. Saldo restante: " + cliente.getTokens() + " tokens.");

        assertTrue(comprou);
        assertEquals(100.0, cliente.getTokens());
        assertEquals(8, produto.getQuantidadeEstoque());
    }

    @Test
    public void testRealizarCompraComDescontoStrategy() {
        Cliente cliente = new Cliente("1", "João", "M", "9999", "12345678900", 200.0, "123");
        Produto produto = new Produto("P1", "Cupom Desconto", 50.0, 10);
        Menus facade = new Menus();
        
        DescontoStrategy dezPorCento = new DescontoPercentual(0.10);

        boolean comprou = facade.realizarCompra(cliente, produto, 2, dezPorCento);
        System.out.println("[TESTE FACADE/STRATEGY] Compra com 10% de desconto. Saldo final: " + cliente.getTokens() + " tokens | Estoque: " + produto.getQuantidadeEstoque());

        assertTrue(comprou);
        assertEquals(110.0, cliente.getTokens());
        assertEquals(8, produto.getQuantidadeEstoque());
    }

    @Test
    public void testRealizarCompraSemSaldo() {
        Cliente cliente = new Cliente("1", "João", "M", "9999", "12345678900", 30.0, "123");
        Produto produto = new Produto("P1", "Cupom Desconto", 50.0, 10);
        Menus facade = new Menus();

        boolean comprou = facade.realizarCompra(cliente, produto, 1);
        System.out.println("[TESTE FACADE] Falha esperada: Saldo insuficiente. Compra retornou: " + comprou);

        assertFalse(comprou);
        assertEquals(30.0, cliente.getTokens());
        assertEquals(10, produto.getQuantidadeEstoque());
    }

    @Test
    public void testRealizarCompraSemEstoque() {
        Cliente cliente = new Cliente("1", "João", "M", "9999", "12345678900", 500.0, "123");
        Produto produto = new Produto("P1", "Cupom Desconto", 50.0, 1);
        Menus facade = new Menus();

        boolean comprou = facade.realizarCompra(cliente, produto, 5);
        System.out.println("[TESTE FACADE] Falha esperada: Estoque insuficiente. Compra retornou: " + comprou);

        assertFalse(comprou);
        assertEquals(500.0, cliente.getTokens());
        assertEquals(1, produto.getQuantidadeEstoque());
    }
}