package br.edu.femass.gui;

import br.edu.femass.model.Emprestimo;
import br.edu.femass.model.TipoCopiaFixa;
import br.edu.femass.model.TipoLeitor;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.tree.DefaultTreeCellEditor;
import java.awt.event.*;

public class GuiEmprestimo {
    private javax.swing.JPanel JPanel;
    private JComboBox cboBoxSelecionarLeitor;
    private JTextField txtDataEmprestimo;
    private JTextField txtDataPrevista;
    private JComboBox cboBoxCopiaFixa;
    private JTextField txtDataDevulocao;
    private JButton btnRegistrar;
    private JButton btnDevolver;
    private JButton btnListaAtraso;

    public GuiEmprestimo() {
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnDevolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Emprestimo emprestimo = new Emprestimo();
                txtDataDevulocao.getSelectedText();

            }
        });
        btnListaAtraso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiListaAtrasoEmprestimo().abrirTela();

            }
        });

    }
    public void preencherJComboboxLeitor() {
        cboBoxSelecionarLeitor.setModel(new DefaultComboBoxModel(TipoLeitor.values()));
    }
    public void preencherJComboboxCopia() {
        cboBoxCopiaFixa.setModel(new DefaultComboBoxModel(TipoCopiaFixa.values()));
    }


    public void abrirTela() {
        JFrame frame = new JFrame();
        GuiEmprestimo guiEmprestimo = new GuiEmprestimo();
        guiEmprestimo.preencherJComboboxLeitor();
        guiEmprestimo.preencherJComboboxCopia();
        frame.setContentPane(guiEmprestimo.JPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Registro de Empréstimos");
        frame.pack();
        frame.setVisible(true);
    }
}
