package br.edu.femass.model;

public enum TipoCopiaFixa {
    SIM ("Sim"),
    NAO ("Não");
    private String nome;
    TipoCopiaFixa(String nome){
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
