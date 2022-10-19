package br.edu.femass.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiMenu {
    private JButton btnCadastrarAutor;
    private JButton btnCadastrarLivro;
    private JButton btnCadastrarExemplar;
    private JButton btnCadastrarLeitor;
    private JButton btnEfetuarEmprestimo;
    private javax.swing.JPanel JPanel;

    public GuiMenu() {
        btnCadastrarAutor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiAutor().abrirTelaModal();

            }
        });
        btnCadastrarLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiLivro().abrirTelaModal();

            }
        });
        btnCadastrarExemplar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiExemplar().abrirTela();

            }
        });
        btnCadastrarLeitor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiLeitor().abrirTela();

            }
        });
        btnEfetuarEmprestimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiEmprestimo().abrirTela();

            }
        });

    }

    public void abrirTela() {
        JFrame frame = new JFrame();
        GuiMenu guiMenu = new GuiMenu();
        frame.setContentPane(guiMenu.JPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Menu");
        frame.pack();
        frame.setVisible(true);
    }
}
