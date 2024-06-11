/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.control;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author lucas
 */
public class DivisaoTreinoMusculo {

    private long id;
    private DivisaoTreino divisaoDeTreino;
    private String descricao;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
    
    
    
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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDateTime dataModificacao) {
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
        return "ID = " + id + ", Divisao De Treino = " + divisaoDeTreino + ", descricao = " + descricao + '}';
    }
  
}
