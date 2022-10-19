package br.edu.femass.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Emprestimo {

    private LocalDate dataEmprestimo;
    private String dataPrevistaDevolucao;
    private String dataDevolucao;

    public TipoCopiaFixa copiaFixa;
    private List<Leitor> leitores;
    public Leitor leitor = new Leitor();

    public Emprestimo() {
        this.leitores = new ArrayList<Leitor>();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        this.dataEmprestimo = LocalDate.now();
        try {
            calendar.setTime(simpleDateFormat.parse(dataEmprestimo.toString()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        calendar.add(Calendar.DAY_OF_MONTH, leitor.getPrazoMaxDevolucao());
        this.dataPrevistaDevolucao = (calendar.getTime().toString());
        this.dataDevolucao = "";

    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(String dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = LocalDate.now().toString();
    }

    public TipoCopiaFixa getCopiaFixa() {
        return copiaFixa;
    }

    @Override
    public String toString() {
        return this.getDataEmprestimo().format(DateTimeFormatter.ofPattern("dd/MM/yyy")) +
                this.getDataPrevistaDevolucao().toString() +
                this.getDataDevolucao();

    }

    public List<Leitor> getLeitores() {
        return leitores;
    }
}
