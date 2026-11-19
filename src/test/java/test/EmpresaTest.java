package test;

import controller.Empresa;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Suíte de testes unitários para validar operações de carteira e atributos cadastrais de Empresa
public class EmpresaTest {

    // Verifica depósitos positivos e garante que valores zerados ou negativos sejam ignorados
    @Test
    public void testDepositarEmpresa() {
        Empresa empresa = new Empresa("1", "Tech Corp", "12345678000199", "contato@tech.com", 100.0, "senha123");
        empresa.depositar(50.0);
        assertEquals(150.0, empresa.getTokens());

        // Cobre o branch false (valor <= 0)
        empresa.depositar(0.0);
        empresa.depositar(-20.0);
        assertEquals(150.0, empresa.getTokens());
    }

    // Verifica a aprovação de compra com saldo suficiente e a recusa quando o valor excede o saldo
    @Test
    public void testComprarEmpresa() {
        Empresa empresa = new Empresa("1", "Tech Corp", "12345678000199", "contato@tech.com", 100.0, "senha123");
        
        // Cobre o branch true (saldo suficiente)
        assertTrue(empresa.comprar(60.0));
        assertEquals(40.0, empresa.getTokens());

        // Cobre o branch false (saldo insuficiente)
        assertFalse(empresa.comprar(100.0));
        assertEquals(40.0, empresa.getTokens());
    }

    // Valida o retorno de todos os métodos getters específicos da classe Empresa
    @Test
    public void testGettersEmpresa() {
        Empresa empresa = new Empresa("1", "Tech Corp", "12345678000199", "contato@tech.com", 100.0, "senha123");
        assertEquals("12345678000199", empresa.getCnpj());
        assertEquals("contato@tech.com", empresa.getEmail());
        assertEquals(100.0, empresa.getTokens());
        assertEquals("senha123", empresa.getSenha());
    }
}