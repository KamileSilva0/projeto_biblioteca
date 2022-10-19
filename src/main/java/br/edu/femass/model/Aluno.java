package br.edu.femass.model;

public class Aluno extends Leitor {

    private String matricula;

    public Aluno(){

    }

    public Aluno(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String toString() {
        return this.getCodigo().toString() + ": " +
                this.getNome().toString() + " - " +
                this.matricula.toString();
    }

}
