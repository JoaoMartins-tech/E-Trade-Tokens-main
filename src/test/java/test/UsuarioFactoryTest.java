package test;

import controller.Cliente;
import controller.Empresa;
import controller.UsuarioFactory;
import model.Usuario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Suíte de testes unitários para validar a criação polimórfica de usuários via UsuarioFactory
public class UsuarioFactoryTest {

    // Verifica se a Factory instancia corretamente um objeto Cliente quando o tipo "CLIENTE" é informado
    @Test
    public void testCriarClienteViaFactory() {
        Usuario user = UsuarioFactory.criarUsuario("CLIENTE", "1", "Maria", "F", "8888", "98765432100", 150.0, "senha123");
        System.out.println("[TESTE FACTORY] Instância criada com sucesso: " + user.getNome() + " (Classe: " + user.getClass().getSimpleName() + ")");
        assertTrue(user instanceof Cliente);
        assertEquals("Maria", user.getNome());
    }

    // Verifica se a Factory instancia corretamente um objeto Empresa quando o tipo "EMPRESA" é informado
    @Test
    public void testCriarEmpresaViaFactory() {
        Usuario user = UsuarioFactory.criarUsuario("EMPRESA", "2", "Loja X", "12345678000199", "contato@lojax.com", null, 500.0, "senha123");
        System.out.println("[TESTE FACTORY] Instância criada com sucesso: " + user.getNome() + " (Classe: " + user.getClass().getSimpleName() + ")");
        assertTrue(user instanceof Empresa);
        assertEquals("Loja X", user.getNome());
    }

    // Verifica se a Factory lança IllegalArgumentException ao receber um tipo de perfil desconhecido
    @Test
    public void testTipoInvalido() {
        System.out.println("[TESTE FACTORY] Testando lançamento de exceção para tipo de utilizador inválido...");
        assertThrows(IllegalArgumentException.class, () -> {
            UsuarioFactory.criarUsuario("INVALIDO", "3", "Teste", "", "", "", 0.0, "");
        });
    }

    // Valida os métodos setters de id e nome herdados da classe base abstrata Usuario
    @Test
    public void testSettersUsuario() {
        Cliente cliente = new Cliente("1", "João", "M", "9999", "12345678900", 100.0, "123");
        cliente.setId("99");
        cliente.setNome("Maria");

        assertEquals("99", cliente.getId());
        assertEquals("Maria", cliente.getNome());
    }
}