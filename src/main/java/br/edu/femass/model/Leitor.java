package br.edu.femass.model;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Leitor {

    private Long codigo;
    private String nome;
    private String endereco;
    private String telefone;
    public Integer prazoMaxDevolucao;
    private static Long proximoCodigo = 1L;
    public TipoLeitor tipoLeitor;
    public Leitor() {

        this.codigo = proximoCodigo;
        proximoCodigo++;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;

        if(this.tipoLeitor.toString() == "Professor"){
            this.prazoMaxDevolucao = 30;
        }
        else {
            this.prazoMaxDevolucao = 15;
        }

    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public TipoLeitor getTipoLeitor() {
        return tipoLeitor;
    }

    public Integer getPrazoMaxDevolucao() {
        return prazoMaxDevolucao;
    }

    public static void atualizarProximoCodigo(List<Leitor> leitores) {
        for(Leitor leitor: leitores) {
            if(leitor.getCodigo()>proximoCodigo){
                proximoCodigo = leitor.getCodigo()+1;
            }
        }

    }
}

