package test;

import controller.Cliente;
import controller.Empresa;
import controller.UsuarioFactory;
import model.Usuario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioFactoryTest {

    @Test
    public void testCriarClienteViaFactory() {
        Usuario user = UsuarioFactory.criarUsuario("CLIENTE", "1", "Maria", "F", "8888", "98765432100", 150.0, "senha123");
        System.out.println("[TESTE FACTORY] Instância criada com sucesso: " + user.getNome() + " (Classe: " + user.getClass().getSimpleName() + ")");
        assertTrue(user instanceof Cliente);
        assertEquals("Maria", user.getNome());
    }

    @Test
    public void testCriarEmpresaViaFactory() {
        Usuario user = UsuarioFactory.criarUsuario("EMPRESA", "2", "Loja X", "12345678000199", "contato@lojax.com", null, 500.0, "senha123");
        System.out.println("[TESTE FACTORY] Instância criada com sucesso: " + user.getNome() + " (Classe: " + user.getClass().getSimpleName() + ")");
        assertTrue(user instanceof Empresa);
        assertEquals("Loja X", user.getNome());
    }

    @Test
    public void testTipoInvalido() {
        System.out.println("[TESTE FACTORY] Testando lançamento de exceção para tipo de utilizador inválido...");
        assertThrows(IllegalArgumentException.class, () -> {
            UsuarioFactory.criarUsuario("INVALIDO", "3", "Teste", "", "", "", 0.0, "");
        });
    }
}