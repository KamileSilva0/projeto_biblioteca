package br.edu.femass.gui;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.model.Autor;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiAutor {
    private javax.swing.JPanel JPanel;
    private JTextField txtNome;
    private JTextField txtSobrenome;
    private JTextField txtNacionaliade;
    private JButton bntSalvar;

    private JList lstAutores;
    private JTextField txtNacionalidade;


    public GuiAutor() {
        bntSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Autor autor = new Autor(
                            txtNome.getText(),
                            txtSobrenome.getText(),
                            txtNacionaliade.getText()
                    );
                    new DaoAutor().salvar(autor);
                    preencherLista();
                } catch (Exception exception){
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                }

            }
        });
        lstAutores.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Autor autor = (Autor) lstAutores.getSelectedValue();
                txtNome.setText(autor.getNome());
                txtSobrenome.setText((autor.getSobreNome()));
                txtNacionaliade.setText(autor.getNacionalidade());

            }
        });
    }

    private void preencherLista() {
        try {
            lstAutores.setListData(new DaoAutor().getAll().toArray());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public void abrirTelaModal() {
        JDialog frame = new JDialog(new Frame(), true);
        GuiAutor guiAutor = new GuiAutor();
        guiAutor.preencherLista();
        frame.setContentPane(guiAutor.JPanel);
        frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        frame.setTitle("Cadastrar Autor");
        frame.pack();
        frame.setVisible(true);
    }
}
