package br.edu.femass.test;

import br.edu.femass.dao.Dao;
import br.edu.femass.dao.DaoAutor;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Livro;

import java.util.List;

public class JsonTest {
    public static void main(String[] args) {
        lerAutores();
        criarAutores();

    }
    private static void lerAutores() {

        Dao<Autor> dao = new DaoAutor();
        try {
            List<Autor> autores = new DaoAutor().getAll();
            for (Autor autor: autores) { //Imprime os autores;
                System.out.println(autores);
                for (Livro livro: autor.getLivros()) { //Para cada autor, imprime seus livros;
                    System.out.println(livro);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private static void criarAutores() {
        Autor autor = new Autor("Colleen", "Hoover", "Americana");
        try {
            new DaoAutor().salvar(autor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Autor autor1 = new Autor("Taylor Jankins", "Reid", "Americana");
        autor1.adicionarLivro("Os Sete Maridos de Evelyn Hugo");
        try {
            new DaoAutor().salvar(autor1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
