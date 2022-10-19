package br.edu.femass.gui;

import br.edu.femass.model.TipoLeitor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiLeitor {
    private javax.swing.JPanel JPanel;
    private JComboBox cboBoxSelectLeitor;
    private JButton btnContinuar;

    public GuiLeitor() {
        btnContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(TipoLeitor.PROFESSOR.toString() == "Professor"){
                    new GuiProfessor().abrirTela();
                }
                if(TipoLeitor.ALUNO.toString() == "Aluno") {
                    new GuiAluno().abrirTelaModal();
                }
            }
        });
    }

    public void preencherJCombobox() {
        cboBoxSelectLeitor.setModel(new DefaultComboBoxModel(TipoLeitor.values()));
    }

    public void abrirTela() {
        JFrame frame = new JFrame();
        GuiLeitor guiLeitor = new GuiLeitor();
        guiLeitor.preencherJCombobox();
        frame.setContentPane(guiLeitor.JPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Cadastro de Leitor");
        frame.pack();
        frame.setVisible(true);
    }
}
