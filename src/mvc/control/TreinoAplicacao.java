/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.control;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author lucas
 */
public class TreinoAplicacao {
    private static long serial;
    private long id;
    private Pessoa usuario;
    private Treino treino;
    private Exercicio exercício;
    private Exercicio_Aplicacao exercícioAplicacao;
    private DivisaoTreino divisaoDeTreino;
    private DivisaoTreinoMusculo divisaoDeTreinoMusculo;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    
    public TreinoAplicacao() {
    
        id = ++TreinoAplicacao.serial;
    }

    public Pessoa getUsuario() {
        return usuario;
    }

    public void setUsuario(Pessoa usuario) {
        this.usuario = usuario;
    }

    
    
    public static long getSerial() {
        return serial;
    }

    public static void setSerial(long serial) {
        TreinoAplicacao.serial = serial;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Treino getTreino() {
        return treino;
    }

    public void setTreino(Treino treino) {
        this.treino = treino;
    }

    public Exercicio getExercício() {
        return exercício;
    }

    public void setExercício(Exercicio exercício) {
        this.exercício = exercício;
    }

    public Exercicio_Aplicacao getExercícioAplicacao() {
        return exercícioAplicacao;
    }

    public void setExercícioAplicacao(Exercicio_Aplicacao exercícioAplicacao) {
        this.exercícioAplicacao = exercícioAplicacao;
    }

    public DivisaoTreino getDivisaoDeTreino() {
        return divisaoDeTreino;
    }

    public void setDivisaoDeTreino(DivisaoTreino divisaoDeTreino) {
        this.divisaoDeTreino = divisaoDeTreino;
    }

    public DivisaoTreinoMusculo getDivisaoDeTreinoMusculo() {
        return divisaoDeTreinoMusculo;
    }

    public void setDivisaoDeTreinoMusculo(DivisaoTreinoMusculo divisaoDeTreinoMusculo) {
        this.divisaoDeTreinoMusculo = divisaoDeTreinoMusculo;
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
        return "TreinoAplicacao{" + "treino=" + treino + ", exerc\u00edcio=" + exercício + ", exerc\u00edcioAplicacao=" + exercícioAplicacao + ", divisaoDeTreino=" + divisaoDeTreino + ", divisaoDeTreinoMusculo=" + divisaoDeTreinoMusculo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 89 * hash + Objects.hashCode(this.usuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TreinoAplicacao other = (TreinoAplicacao) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.usuario, other.usuario);
    }
    
    
    
}
