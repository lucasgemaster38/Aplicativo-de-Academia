/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.control;

import academia.Academia;
import java.time.LocalDate;

/**
 *
 * @author lucas
 */
public class TreinoDAO {

    private Treino[] treinos = new Treino[100];

    public TreinoDAO() {
        Treino a1 = new Treino();
        a1.setDataCriacao(LocalDate.now());
        a1.setObjetivo("Perder 25 kilos");
        a1.setDatainicio("22/05/2024");
        a1.setDatatermino("22/05/2025");
        DivisaoTreinoDAO b1 = new DivisaoTreinoDAO();
        a1.setDivisaoDeTreino(b1.buscaPorId(0));
        this.adiciona(a1);

        Treino a2 = new Treino();
        a2.setDataCriacao(LocalDate.now());
        a2.setObjetivo("Entrar no shape");
        a2.setDatainicio("16/06/2024");
        a2.setDatatermino("22/09/2024");
        DivisaoTreinoDAO b2 = new DivisaoTreinoDAO();
        a2.setDivisaoDeTreino(b2.buscaPorId(1));
        this.adiciona(a2);

        Treino a3 = new Treino();
        a3.setDataCriacao(LocalDate.now());
        a3.setObjetivo("Ganhar Peso");
        a3.setDatainicio("16/06/2024");
        a3.setDatatermino("22/09/2024");
        DivisaoTreinoDAO b3 = new DivisaoTreinoDAO();
        a3.setDivisaoDeTreino(b3.buscaPorId(2));
        this.adiciona(a3);

    }

    public boolean adiciona(Treino a) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            treinos[proximaPosicaoLivre] = a;
            return true;
        } else {
            return false;
        }

    }

    public boolean ehVazio() {
        for (Treino exer : treinos) {
            if (exer != null) {
                return false;
            }
        }
        return true;

    }

    public void mostrarTodos() {
        boolean temTreino = false;
        for (Treino a : treinos) {
            if (a != null) {
                System.out.println(a);
                temTreino = true;
            }
        }
        if (!temTreino) {
            System.out.println("não existe Treino cadastrado");
        }
    }

    public void alterar(int id, String objetivo, DivisaoTreino divisaoDeTreino, String DataInicio, String DataFim) {
        for (Treino a : treinos) {
            if (a != null && a.getId() == id) {
                treinos[id-1].setObjetivo(objetivo);
                treinos[id-1].setDivisaoDeTreino(divisaoDeTreino);
                treinos[id-1].setDatainicio(DataInicio);
                treinos[id-1].setDatatermino(DataFim);
                treinos[id-1].setDataModificacao(LocalDate.now());
            }

        }

    } 

    public Treino buscaPorId(long id) {
        for (Treino a : treinos) {
            if (a != null && a.getId() == id) {
                return a;
            }
        }
        return null;

    }

        public Treino buscaPorNome(String descricao) {
        for (Treino a : treinos) {
            if (a != null && a.getObjetivo().equals(descricao)) {
                return a;
            }
        }
        return null;

    }
    
    public void remover(int id) {

        this.treinos[id] = null;

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
