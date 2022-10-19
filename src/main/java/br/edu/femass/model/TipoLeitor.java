package br.edu.femass.model;

public enum TipoLeitor {
    PROFESSOR ("Professor"),
    ALUNO ("Aluno");
    private String nome;
    TipoLeitor(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
