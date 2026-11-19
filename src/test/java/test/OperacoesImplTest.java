package test;

import model.OperacoesImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Suíte de testes unitários para validar as operações financeiras básicas de OperacoesImpl
public class OperacoesImplTest {

    // Verifica depósitos positivos e garante que valores zerados ou negativos não alterem o saldo
    @Test
    public void testDepositarOperacoesImpl() {
        OperacoesImpl op = new OperacoesImpl(100.0);

        // Cobre o branch true (valor > 0)
        op.depositar(50.0);
        assertEquals(150.0, op.getSaldoTokens());

        // Cobre o branch false (valor <= 0)
        op.depositar(0.0);
        op.depositar(-25.0);
        assertEquals(150.0, op.getSaldoTokens());
    }

    // Verifica o débito na compra com saldo suficiente e a recusa quando o saldo é insuficiente
    @Test
    public void testComprarOperacoesImpl() {
        OperacoesImpl op = new OperacoesImpl(100.0);

        // Cobre o branch true (saldo >= valor)
        assertTrue(op.comprar(40.0));
        assertEquals(60.0, op.getSaldoTokens());

        // Cobre o branch false (saldo < valor)
        assertFalse(op.comprar(100.0));
        assertEquals(60.0, op.getSaldoTokens());
    }
}