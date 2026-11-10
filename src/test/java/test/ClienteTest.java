package test;

import controller.Cliente;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    @Test
    public void testDepositar() {
        Cliente cliente = new Cliente("", "João", "M", "9999", "12345678900", 100.0, "123");
        cliente.depositar(50.0);
        System.out.println("[TESTE CLIENTE] Depósito realizado com sucesso. Saldo atual: " + cliente.getTokens());
        assertEquals(150.0, cliente.getTokens());
    }

    @Test
    public void testComprarComSaldoSuficiente() {
        Cliente cliente = new Cliente("", "João", "M", "9999", "12345678900", 100.0, "123");
        boolean resultado = cliente.comprar(80.0);
        System.out.println("[TESTE CLIENTE] Compra aprovada. Saldo restante: " + cliente.getTokens());
        assertTrue(resultado);
        assertEquals(20.0, cliente.getTokens());
    }

    @Test
    public void testComprarSemSaldo() {
        Cliente cliente = new Cliente("", "João", "M", "9999", "12345678900", 50.0, "123");
        boolean resultado = cliente.comprar(100.0);
        System.out.println("[TESTE CLIENTE] Compra recusada por saldo insuficiente. Saldo mantido: " + cliente.getTokens());
        assertFalse(resultado);
        assertEquals(50.0, cliente.getTokens());
    }
}