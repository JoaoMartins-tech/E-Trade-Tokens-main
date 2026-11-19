package view;

import javax.swing.JFrame;

// Janela principal (Swing) que serve como tela inicial e ponto de navegação do E-Trade Tokens
public class MainFrame extends JFrame {

    // Configura título, dimensões e encerramento da aplicação ao fechar a janela principal
    public MainFrame() {
        setTitle("E-Trade Tokens");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}