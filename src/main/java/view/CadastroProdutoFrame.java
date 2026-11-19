package view;

import javax.swing.JFrame;

// Janela gráfica (Swing) responsável pela interface de cadastro de novos produtos no catálogo
public class CadastroProdutoFrame extends JFrame {

    // Configura título, dimensões e comportamento de fechamento da janela de cadastro
    public CadastroProdutoFrame() {
        setTitle("Cadastro de Produto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}