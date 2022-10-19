package br.edu.femass.dao;

import java.util.List;

public interface Dao<T> { //Interface Generica para criação dos DAOs;

    public void salvar(T objeto) throws Exception;
    public List<T> getAll() throws Exception;

}
