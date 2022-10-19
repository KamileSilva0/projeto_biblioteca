package br.edu.femass.gui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GuiListaAtrasoEmprestimo {
    private JList lstEmprestimoAtraso;
    private javax.swing.JPanel JPanel;


    public GuiListaAtrasoEmprestimo() {
        lstEmprestimoAtraso.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

            }
        });
    }

    public void abrirTela() {
        JFrame frame = new JFrame();
        GuiListaAtrasoEmprestimo guiAtraso = new GuiListaAtrasoEmprestimo();
        frame.setContentPane(guiAtraso.JPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Lista de Empréstimos Atrasados");
        frame.pack();
        frame.setVisible(true);
    }
}
