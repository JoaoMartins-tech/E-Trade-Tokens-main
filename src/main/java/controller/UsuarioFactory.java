package controller;

import model.Usuario;

// Factory responsável por criar instâncias de Cliente ou Empresa conforme o tipo informado
public class UsuarioFactory {

    // Construtor privado para impedir instanciação indevida da Factory estática
    private UsuarioFactory() {}

    // Instancia o perfil adequado ou lança exceção caso o tipo seja inválido
    public static Usuario criarUsuario(String tipo, String id, String nome, String extra1, String extra2, String extra3, double tokens, String senha) {
        if ("CLIENTE".equalsIgnoreCase(tipo)) {
            return new Cliente(id, nome, extra1, extra2, extra3, tokens, senha);
        } else if ("EMPRESA".equalsIgnoreCase(tipo)) {
            return new Empresa(id, nome, extra1, extra2, tokens, senha);
        }
        throw new IllegalArgumentException("Tipo de utilizador inválido: " + tipo);
    }
}