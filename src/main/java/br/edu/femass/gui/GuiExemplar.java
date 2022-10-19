package br.edu.femass.gui;

import javax.swing.*;

public class GuiExemplar {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton salvarButton;
    private javax.swing.JPanel JPanel;

    public void abrirTela() {
        JFrame frame = new JFrame();
        GuiExemplar guiExemplar = new GuiExemplar();
        frame.setContentPane(guiExemplar.JPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Cadastro de Exemplar");
        frame.pack();
        frame.setVisible(true);
    }
}
