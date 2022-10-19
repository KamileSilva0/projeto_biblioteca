package br.edu.femass.test;

import br.edu.femass.model.Autor;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Livro;

public class BibliotecaTest {

    public static void main(String[] args) {

        Autor autor = new Autor("Cassandra",
                             "Clare",
                             "Americana");
        System.out.println("\nInformações do Autor\n" + autor.toString());

        autor.adicionarLivro("Cidade dos Ossos");
        autor.adicionarLivro("Cidade das Cinzas");

        System.out.println("\nLivros do Autor\n");

        for (Livro livro: autor.getLivros()) {

            System.out.println(livro.toString());
        }
        //Dentro de livro tenho que criar os exemplares, como fazer?

        Livro livro = autor.getLivros().get(0);



    }
}
