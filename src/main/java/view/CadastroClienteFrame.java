package view;

import javax.swing.JFrame;

// Janela gráfica (Swing) responsável pela interface de cadastro de novos clientes
public class CadastroClienteFrame extends JFrame {

    // Configura título, dimensões e comportamento de fechamento da janela de cadastro
    public CadastroClienteFrame() {
        setTitle("Cadastro de Cliente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}