package br.edu.femass.dao;

import br.edu.femass.model.Autor;
import br.edu.femass.model.Livro;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DaoAutor extends Persistencia<Autor> implements Dao<Autor> {

    private final static String NOMEARQUIVO = "autores.jason";

    //Escreve o Json, grava o arquivo;
    public void salvar(Autor autor) throws Exception {
        List<Autor> autores = getAll(); //Armazena e grava;
        autores.add(autor);
        String json = getObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(autores);

        FileOutputStream out = new FileOutputStream(NOMEARQUIVO);
        out.write(json.getBytes());
        out.close();
    }

    //Recebe o arquivo, lê, converte e devolve os dados;
    public List<Autor> getAll() throws Exception {
        try {
            FileInputStream in = new FileInputStream(NOMEARQUIVO);
            String json = new String(in.readAllBytes());
            List<Autor> autores =  getObjectMapper().readValue(json, new TypeReference<List<Autor>>(){});

            return autores;
        } catch (FileNotFoundException exception){
            return new ArrayList<>();
        }

    }

}
