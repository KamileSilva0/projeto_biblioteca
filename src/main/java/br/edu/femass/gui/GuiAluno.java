package br.edu.femass.gui;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoProfessor;
import br.edu.femass.model.Aluno;
import br.edu.femass.model.Professor;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiAluno {
    private javax.swing.JPanel JPanel;
    private JList lstLeitorAluno;
    private JTextField txtNome;
    private JTextField txtTelefone;
    private JTextField txtMatricula;
    private JTextField txtEndereco;
    private JTextField txtCodigo;
    private JButton bntEmprestimo;
    private JButton bntRegistar;

    public GuiAluno() {
        lstLeitorAluno.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Aluno aluno = (Aluno) lstLeitorAluno.getSelectedValue();
                txtNome.setText(aluno.getNome());
                txtEndereco.setText(aluno.getEndereco());
                txtTelefone.setText(aluno.getTelefone());
                txtCodigo.setText(aluno.getCodigo().toString());
                txtMatricula.setText(aluno.getMatricula());

            }
        });
        bntRegistar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Aluno aluno = new Aluno(txtMatricula.getText());
                    new DaoAluno().salvar(aluno);
                    preencherLista();
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                }

            }
        });
        bntEmprestimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiEmprestimo().abrirTela();

            }
        });
    }

    public void preencherLista() {
        try {
            lstLeitorAluno.setListData(new DaoAluno().getAll().toArray());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void abrirTelaModal() {
        JDialog frame = new JDialog(new Frame(), true);
        GuiAluno guiAluno = new GuiAluno();
        guiAluno.preencherLista();
        frame.setContentPane(guiAluno.JPanel);
        frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        frame.setTitle("Cadastro de Leitor Aluno");
        frame.pack();
        frame.setVisible(true);
    }
}
