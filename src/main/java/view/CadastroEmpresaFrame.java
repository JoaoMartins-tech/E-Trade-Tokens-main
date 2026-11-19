package view;

import javax.swing.JFrame;

// Janela gráfica (Swing) responsável pela interface de cadastro de novas empresas
public class CadastroEmpresaFrame extends JFrame {

    // Configura título, dimensões e comportamento de fechamento da janela de cadastro
    public CadastroEmpresaFrame() {
        setTitle("Cadastro de Empresa");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}