package test;

import controller.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Suíte de testes unitários para validar o fluxo de compra da Facade (Menus) e políticas de desconto (Strategy)
public class CompraFacadeTest {

    // Verifica a compra padrão sem estratégia de desconto, validando débito de saldo e redução de estoque
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

    // Verifica a aplicação correta do desconto percentual (10%) sobre o valor total da compra
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

    // Verifica se a compra é recusada na sobrecarga padrão quando o cliente não possui saldo suficiente
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

    // Verifica se a compra é bloqueada antes do débito quando a quantidade solicitada excede o estoque
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

    // Verifica a recusa por saldo insuficiente utilizando a estratégia explícita DescontoSemDesconto
    @Test
    public void testRealizarCompraSaldoInsuficienteNaFacade() {
        Cliente cliente = new Cliente("1", "João", "M", "9999", "12345678900", 50.0, "123");
        Produto produto = new Produto("Token VIP", null, 100.0, 5);
        DescontoStrategy semDesconto = new DescontoSemDesconto();

        Menus facade = new Menus();
        boolean resultado = facade.realizarCompra(cliente, produto, 1, semDesconto);

        assertFalse(resultado, "A Facade deve recusar a compra quando o saldo do cliente é insuficiente");
        assertEquals(50.0, cliente.getTokens(), "O saldo do cliente não deve ser alterado");
        assertEquals(5, produto.getQuantidadeEstoque(), "O estoque do produto não deve ser reduzido");
    }
}