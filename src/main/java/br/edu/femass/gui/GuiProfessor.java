package br.edu.femass.gui;

import br.edu.femass.dao.DaoProfessor;
import br.edu.femass.model.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiProfessor {
    private JTextField txtNome;
    private JTextField txtEndereco;
    private JTextField txtTelefone;
    private javax.swing.JPanel JPanel;
    private JList lstLeitorProfessor;
    private JTextField txtDisciplina;
    private JButton bntEmprestimo;
    private JButton bntRegistar;
    private JTextField txtCodigo;

    public GuiProfessor() {
        lstLeitorProfessor.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Professor professor = (Professor) lstLeitorProfessor.getSelectedValue();
                txtNome.setText(professor.getNome());
                txtEndereco.setText(professor.getEndereco());
                txtTelefone.setText(professor.getTelefone());
                txtCodigo.setText(professor.getCodigo().toString());
                txtDisciplina.setText(professor.getDisciplina());

            }
        });
        bntEmprestimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiEmprestimo().abrirTela();

            }
        });
        bntRegistar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Professor professor = new Professor(txtDisciplina.getText());
                    new DaoProfessor().salvar(professor);
                    preencherLista();
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                }
            }
        });
    }

    private void preencherLista() {
        try {
            lstLeitorProfessor.setListData(new DaoProfessor().getAll().toArray());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void abrirTela() {
        JDialog frame = new JDialog(new Frame(), true);
        GuiProfessor guiProfessor = new GuiProfessor();
        guiProfessor.preencherLista();
        frame.setContentPane(guiProfessor.JPanel);
        frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        frame.setTitle("Casdatro de Leitor Professor");
        frame.pack();
        frame.setVisible(true);
    }


}
