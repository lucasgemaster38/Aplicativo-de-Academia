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
public class TreinoAplicacaoDAO {
    
    private TreinoAplicacao treinos[] = new TreinoAplicacao[100];

    public TreinoAplicacaoDAO() {
        DivisaoTreinoDAO dt = new DivisaoTreinoDAO();
        DivisaoTreinoMusculoDAO dtm = new DivisaoTreinoMusculoDAO();
        ExercicioDAO e = new ExercicioDAO();
        Exercicio_AplicacaoDAO ea = new Exercicio_AplicacaoDAO();
        TreinoDAO t = new TreinoDAO();
        
        TreinoAplicacao ta1 = new TreinoAplicacao();
        ta1.setDataCriacao(LocalDate.now());
        ta1.setDivisaoDeTreino(dt.buscaPorNome("ABC"));
        ta1.setDivisaoDeTreinoMusculo(dtm.buscaPorNome("A - PEITO, OMBRO, TRICEPS"));
        ta1.setExercício(e.buscaPorNome("supino reto"));
        ta1.setExercícioAplicacao(ea.buscaPorNome("4x12"));
        ta1.setTreino(t.buscaPorNome("Perder 25 kilos"));
        this.adiciona(ta1);
        
        TreinoAplicacao ta2 = new TreinoAplicacao();
        ta2.setDataCriacao(LocalDate.now());
        ta2.setDivisaoDeTreino(dt.buscaPorNome("ABCD"));
        ta2.setDivisaoDeTreinoMusculo(dtm.buscaPorNome("B - COSTAS, BICEPS"));
        ta2.setExercício(e.buscaPorNome("aeróbico"));
        ta2.setExercícioAplicacao(ea.buscaPorNome("3x10"));
        ta2.setTreino(t.buscaPorNome("Entrar no shape"));
        this.adiciona(ta1);
    }
 
    
    
    public boolean adiciona(TreinoAplicacao a) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            treinos[proximaPosicaoLivre] = a;
            return true;
        } else {
            return false;
        }
    }

    public boolean ehVazio() {
        for (TreinoAplicacao tein : treinos) {
            if (tein != null) {
                return false;
            }
        }
        return true;

    }

    public void mostrarTodos() {
        boolean temTreinoCadastrado = false;
        for (TreinoAplicacao t : treinos) {
            if (t != null) {
                System.out.println(t);
                temTreinoCadastrado = true;
            }
        }
        if (!temTreinoCadastrado) {
            System.out.println("não existe Treino cadastrado");
        }
    }


    TreinoAplicacao buscaPorId(long id) {
        for (TreinoAplicacao t : treinos) {
            if (t != null && t.getId() == id) {
                return t;
            }
        }
        return null;

    }
    
    public void remover(int id) {
        treinos[id] = null;
    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < treinos.length; i++) {
            if (treinos[i] == null) {
                return i;
            }
        }
        return -1;
    }
    
}
