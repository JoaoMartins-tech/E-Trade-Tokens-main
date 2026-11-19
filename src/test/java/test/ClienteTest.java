package test;

import controller.Cliente;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Suíte de testes unitários para validar operações de saldo, getters e atributos herdados de Cliente
public class ClienteTest {

    // Verifica se o depósito de um valor positivo incrementa corretamente o saldo de tokens
    @Test
    public void testDepositar() {
        Cliente cliente = new Cliente("", "João", "M", "9999", "12345678900", 100.0, "123");
        cliente.depositar(50.0);
        System.out.println("[TESTE CLIENTE] Depósito realizado com sucesso. Saldo atual: " + cliente.getTokens());
        assertEquals(150.0, cliente.getTokens());
    }

    // Verifica se a compra é aprovada e o saldo debitado quando há tokens suficientes
    @Test
    public void testComprarComSaldoSuficiente() {
        Cliente cliente = new Cliente("", "João", "M", "9999", "12345678900", 100.0, "123");
        boolean resultado = cliente.comprar(80.0);
        System.out.println("[TESTE CLIENTE] Compra aprovada. Saldo restante: " + cliente.getTokens());
        assertTrue(resultado);
        assertEquals(20.0, cliente.getTokens());
    }

    // Verifica se a compra é recusada e o saldo permanece intacto quando não há tokens suficientes
    @Test
    public void testComprarSemSaldo() {
        Cliente cliente = new Cliente("", "João", "M", "9999", "12345678900", 50.0, "123");
        boolean resultado = cliente.comprar(100.0);
        System.out.println("[TESTE CLIENTE] Compra recusada por saldo insuficiente. Saldo mantido: " + cliente.getTokens());
        assertFalse(resultado);
        assertEquals(50.0, cliente.getTokens());
    }

    // Verifica se depósitos zerados ou negativos são ignorados sem alterar o saldo
    @Test
    public void testDepositarValorInvalido() {
        Cliente cliente = new Cliente("1", "João", "M", "9999", "12345678900", 100.0, "123");
        cliente.depositar(0.0);
        cliente.depositar(-50.0);
        assertEquals(100.0, cliente.getTokens(), "Depósitos nulos ou negativos não devem alterar o saldo");
    }

    // Valida o retorno de todos os métodos getters específicos de Cliente e herdados de Usuario
    @Test
    public void testGettersCliente() {
        Cliente cliente = new Cliente("1", "João", "M", "9999", "12345678900", 100.0, "123");
        assertEquals("1", cliente.getId());
        assertEquals("João", cliente.getNome());
        assertEquals("M", cliente.getGenero());
        assertEquals("9999", cliente.getCodigoAmigo());
        assertEquals("12345678900", cliente.getCpf());
        assertEquals(100.0, cliente.getTokens());
        assertEquals("123", cliente.getSenha());
    }

    // Valida os métodos setters de id e nome herdados da classe base Usuario
    @Test
    public void testSettersUsuario() {
        Cliente cliente = new Cliente("1", "João", "M", "9999", "12345678900", 100.0, "123");
        cliente.setId("99");
        cliente.setNome("Maria");

        assertEquals("99", cliente.getId());
        assertEquals("Maria", cliente.getNome());
    }
}