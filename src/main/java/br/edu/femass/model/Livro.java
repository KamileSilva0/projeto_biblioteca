package br.edu.femass.model;

import java.util.ArrayList;
import java.util.List;

public class Livro {

    private Long codigo;
    private String titulo;
    private List<Exemplar> exemplares;
    private static Long proximoCodigo = 1L;
    public Autor autor;

    public Livro(){ // Método vazio, para atender a exigencia do Jackson;

    }

    public Livro(String titulo, Autor autor) {
        this.codigo = proximoCodigo;
        proximoCodigo++;
        this.titulo = titulo;
        this.exemplares = new ArrayList<Exemplar>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public List<Exemplar> getExemplares() {
        return exemplares;
    }

    @Override
    public String toString() {
        return  this.codigo.toString() + ": " +
                this.titulo.toString();

    }

    @Override
    public boolean equals(Object obj) {
        Livro livro = (Livro) obj;
        return this.codigo.equals(livro.getCodigo());
    }

    public void adicionarExemplar(String ibsn) {
        Exemplar exemplar = new Exemplar(ibsn);
        this.exemplares.add(exemplar);
    }

    public Autor getAutor() {
        return autor;
    }

    public static void atualizarProximoCodigo(List<Livro> livros) { // Gravar o útilmo código da lista, mantendo atualizado;
        for(Livro livro: livros) {
            if(livro.getCodigo()>proximoCodigo){
                proximoCodigo = livro.getCodigo()+1;
            }
        }

    }
}
