package view;

import javax.swing.JFrame;

// Janela gráfica (Swing) responsável pela interface de compra de produtos com tokens
public class ComprarProdutoFrame extends JFrame {

    // Configura título, dimensões e comportamento de fechamento da janela de compra
    public ComprarProdutoFrame() {
        setTitle("Comprar Produto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}