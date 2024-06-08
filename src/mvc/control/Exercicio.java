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
public class Exercicio {
    private static long serial;
    private long id;
    private String nome;
    private String descricao;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    
       public Exercicio() {
        
        id = ++Exercicio.serial;
    }

    public static long getSerial() {
        return serial;
    }

    public static void setSerial(long serial) {
        Exercicio.serial = serial;
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
        return "Exercicio{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + '}';
    }
      
     
    
     
}
