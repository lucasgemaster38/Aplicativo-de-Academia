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
public class DivisaoTreino {
    private static long serial;
    private long id;
    private String nome;
    private String descricao;
    LocalDate dataCriacao;
    LocalDate dataModificacao;
    
    public DivisaoTreino() {
        id = ++DivisaoTreino.serial;
    }

    public static long getSerial() {
        return serial;
    }

    public static void setSerial(long serial) {
        DivisaoTreino.serial = serial;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    @Override
    public String toString() {
        return "DivisaoTreino: " + "id=" + id + ", nome=" + nome + ", descricao=" + descricao;
    }


    
}
