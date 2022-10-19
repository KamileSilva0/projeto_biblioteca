package br.edu.femass.model; // Pacote para implementar as classes;

import java.util.ArrayList;
import java.util.List;

public class Autor {

    private String nome;
    private String sobreNome;
    private String nacionalidade;
    private List<Livro> livros; // Lista de livros que o autor possui;
    public Autor (){ // Método vazio, para atender a exigencia do Jackson;

    }

    public Autor(String nome, String sobreNome, String nacionalidade) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.nacionalidade = nacionalidade;
        this.livros = new ArrayList<Livro>();

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    @Override
    public String toString() {
        return this.nome.toString() + " " +
                this.sobreNome.toString();
    }

    public void adicionarLivro(String titulo) {
        Livro livro = new Livro(); // Classe Autor "cria" livro e adiciona à lista de livros do autor;
        this.livros.add(livro);
    }

}
