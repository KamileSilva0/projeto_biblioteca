package br.edu.femass.model;

public class Professor extends Leitor {

    private String disciplina;

    public Professor(){

    }
    public Professor (String disciplina) {
        this.disciplina = disciplina;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String toString() {
        return this.getCodigo().toString() + ": " +
                this.getNome().toString() + " - " +
                this.disciplina.toString();
    }
}
