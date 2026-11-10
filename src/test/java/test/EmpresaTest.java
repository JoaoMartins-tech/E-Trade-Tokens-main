package test;

import controller.Empresa;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmpresaTest {

    @Test
    public void testDepositarEMerchan() {
        Empresa empresa = new Empresa("1", "TechCorp", "12345678000199", "empresa@tech.com", 500.0, "123");
        empresa.depositar(200.0);
        System.out.println("[TESTE EMPRESA] Depósito empresarial efetuado. Saldo total: " + empresa.getTokens() + " tokens.");
        assertEquals(700.0, empresa.getTokens());
    }
}