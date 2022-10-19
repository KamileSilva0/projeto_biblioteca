package br.edu.femass.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Exemplar{

    private String isbn; // Código identificador de livros, cada exemplar possui um diferente;
    private LocalDate dataAquisicao;
    private Long codigo;
    private static Long proximoCodigo = 1L;

    public Exemplar(){ // Método vazio, para atender a exigencia do Jackson;

    }

    public Exemplar(String isbn){
        this.codigo = proximoCodigo;
        proximoCodigo++;
        this.isbn = isbn;
        this.dataAquisicao = LocalDate.now();
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public Long getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return dataAquisicao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n" +
                this.isbn.toString() + "\n" +
                this.codigo.toString();
    }

    @Override
    public boolean equals(Object obj) {
        Exemplar exemplar = (Exemplar) obj;
        return this.codigo.equals(exemplar.getCodigo());
    }
}