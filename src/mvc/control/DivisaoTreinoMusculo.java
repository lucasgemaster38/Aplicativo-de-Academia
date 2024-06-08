/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.control;

import java.time.LocalDate;

/**
 *
 * @author lucas
 */
public class DivisaoTreinoMusculo {
    private static long serial;
    private long id;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    private DivisaoTreino divisaoDeTreino;
    private String descricao;
    
    public DivisaoTreinoMusculo() {
    
        id = ++DivisaoTreinoMusculo.serial;
    }

    public static long getSerial() {
        return serial;
    }

    public static void setSerial(long serial) {
        DivisaoTreinoMusculo.serial = serial;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "DivisaoTreinoMusculo{" + "divisaoDeTreino=" + divisaoDeTreino + ", descricao=" + descricao + '}';
    }
  
}
