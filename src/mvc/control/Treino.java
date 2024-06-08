/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.control;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author lucas
 */
public class Treino {
    private static long serial;
    private long id;
    private String objetivo;
    private LocalDate datainicio;
    private LocalDate datatermino;
    private DivisaoTreino divisaoDeTreino;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public Treino() {
    
        id = ++Treino.serial;
    }

    public static long getSerial() {
        return serial;
    }

    public static void setSerial(long serial) {
        Treino.serial = serial;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public LocalDate getDatainício() {
        return datainicio;
    }

    public LocalDate getDatatermino() {
        return datatermino;
    }


    public DivisaoTreino getDivisaoDeTreino() {
        return divisaoDeTreino;
    }

    public void setDivisaoDeTreino(DivisaoTreino divisaoDeTreino) {
        this.divisaoDeTreino = divisaoDeTreino;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public void setDatainicio(String string) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.datainicio = LocalDate.parse(string, dtf);
    }
    public void setDatatermino(String string) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.datatermino = LocalDate.parse(string, dtf);
    }

    @Override
    public String toString() {
        return "" + "id=" + id + ", objetivo=" + objetivo + ", datainicio=" + datainicio + ", datatermino=" + datatermino + ", divisaoDeTreino=" + divisaoDeTreino + '}';
    }
    
    
}
