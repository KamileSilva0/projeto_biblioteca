package br.edu.femass.gui;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Livro;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiLivro {
    private JList lstLivros;
    private JTextField txtTitulo;
    private JButton bntRegistrar;
    private javax.swing.JPanel JPanel;
    private JComboBox cboBoxSelecionarAutor;
    private JTextField txtCodigo;

    public GuiLivro() {
        lstLivros.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Livro livro = (Livro) lstLivros.getSelectedValue();
                txtTitulo.setText(livro.getTitulo());
                txtCodigo.setText(livro.getCodigo().toString());
                cboBoxSelecionarAutor.setSelectedItem(livro.getAutor());

            }
        });
        bntRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Livro livro = new Livro(
                            txtTitulo.getText(),
                            (Autor) cboBoxSelecionarAutor.getSelectedItem());
                    new DaoLivro().salvar(livro);
                    preencherLista();
                } catch (Exception exception){
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                }
            }
        });

    }

    public void preencherJCombobox() {
        try {
            List<Autor> autores = new DaoAutor().getAll();
            cboBoxSelecionarAutor.removeAll();
            for (Autor autor: autores){
                cboBoxSelecionarAutor.addItem(autor);
            }
        }catch (Exception exception){
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
    }
    private void preencherLista() {
        try {
            lstLivros.setListData(new DaoLivro().getAll().toArray());
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void abrirTelaModal() {
        JDialog frame = new JDialog(new Frame(), true);
        GuiLivro guiLivro = new GuiLivro();
        guiLivro.preencherLista();
        guiLivro.preencherJCombobox();
        frame.setContentPane(guiLivro.JPanel);
        frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        frame.setTitle("Cadastrar Livro");
        frame.pack();
        frame.setVisible(true);

    }
}
