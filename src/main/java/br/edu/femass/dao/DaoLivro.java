package br.edu.femass.dao;

import br.edu.femass.model.Autor;
import br.edu.femass.model.Livro;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DaoLivro extends Persistencia<Livro> implements Dao<Livro> {

    private final static String NOMEARQUIVO = "livros.jason";

    public void salvar(Livro livro) throws Exception {
        List<Livro> livros = getAll(); //Armazena e grava;
        livros.add(livro);
        String json = getObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(livros);

        FileOutputStream out = new FileOutputStream(NOMEARQUIVO);
        out.write(json.getBytes());
        out.close();
    }

    public List<Livro> getAll() throws Exception {
        try {
            FileInputStream in = new FileInputStream(NOMEARQUIVO);
            String json = new String(in.readAllBytes());
            List<Livro> livros =  getObjectMapper().readValue(json, new TypeReference<List<Livro>>(){});
            Livro.atualizarProximoCodigo(livros);
            return livros;
        } catch (FileNotFoundException exception){
            return new ArrayList<>();
        }

    }
}
