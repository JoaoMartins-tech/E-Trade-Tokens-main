package test;

import controller.Produto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Suíte de testes unitários para validar o controle de estoque e os atributos de Produto
public class ProdutoTest {

    // Verifica a redução de estoque quando há unidades suficientes e o bloqueio quando o estoque é insuficiente
    @Test
    public void testDebitarEstoque() {
        Produto produto = new Produto("P1", "Token Ouro", 50.0, 10);

        // Cobre o branch true (estoque suficiente)
        assertTrue(produto.debitarEstoque(4));
        assertEquals(6, produto.getQuantidadeEstoque());

        // Cobre o branch false (estoque insuficiente)
        assertFalse(produto.debitarEstoque(10));
        assertEquals(6, produto.getQuantidadeEstoque());
    }

    // Valida o retorno de todos os métodos getters da classe Produto
    @Test
    public void testGettersProduto() {
        Produto produto = new Produto("P1", "Token Ouro", 50.0, 10);
        assertEquals("P1", produto.getId());
        assertEquals("Token Ouro", produto.getNome());
        assertEquals(50.0, produto.getPrecoTokens());
        assertEquals(10, produto.getQuantidadeEstoque());
    }
}