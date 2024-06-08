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
public class DivisaoTreinoMusculoDAO {

    private DivisaoTreinoMusculo[] divisoesTreinoMusculo = new DivisaoTreinoMusculo[100];

    public DivisaoTreinoMusculoDAO() {
        DivisaoTreinoDAO dtrein = new DivisaoTreinoDAO();

        DivisaoTreinoMusculo a1 = new DivisaoTreinoMusculo();
        a1.setDataCriacao(LocalDate.now());
        DivisaoTreino a = dtrein.buscaPorNome("ABC");
        a1.setDivisaoDeTreino(a);
        a1.setDescricao("A - PEITO, OMBRO, TRICEPS");
        this.adiciona(a1);

        DivisaoTreinoMusculo a2 = new DivisaoTreinoMusculo();
        a2.setDataCriacao(LocalDate.now());
        DivisaoTreino b = dtrein.buscaPorNome("ABCD");
        a2.setDivisaoDeTreino(b);
        a2.setDescricao("B - COSTAS, BICEPS");
        this.adiciona(a2);
    }

    public void mostraTudo() {
        DivisaoTreinoMusculo treinomusculo = new DivisaoTreinoMusculo();
        for (int i = 0; i < divisoesTreinoMusculo.length; i++) {
            if (divisoesTreinoMusculo[i] != null) {
                treinomusculo = divisoesTreinoMusculo[i];
                System.out.println("ID: " + (i + 1) + " " + treinomusculo.toString());
            }
        }
    }

    public boolean adiciona(DivisaoTreinoMusculo a) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            divisoesTreinoMusculo[proximaPosicaoLivre] = a;
            return true;
        } else {
            return false;
        }
    }

    public boolean ehVazio() {
        for (DivisaoTreinoMusculo divis : divisoesTreinoMusculo) {
            if (divis != null) {
                return false;
            }
        }
        return true;

    }

    public void mostrarTodos() {
        boolean temDivisaoTreinoMusculo = false;
        for (DivisaoTreinoMusculo d : divisoesTreinoMusculo) {
            if (d != null) {
                System.out.println(d);
                temDivisaoTreinoMusculo = true;
            }
        }
        if (!temDivisaoTreinoMusculo) {
            System.out.println("não existe divisões de treino por músculo cadastrados");
        }
    }

    public boolean alterarNome(String nome, String novoNome) {
        for (DivisaoTreinoMusculo divis : divisoesTreinoMusculo) {
            if (divis != null && divis.getDescricao().equals(nome)) {
                //divis.setDescricao();
                return true;
            }
        }
        return false;

    }

    public DivisaoTreinoMusculo buscaPorId(int id) {
        for (DivisaoTreinoMusculo d : divisoesTreinoMusculo) {
            if (d != null && d.getId() == id) {
                return d;
            }
        }
        return null;

    }

    public DivisaoTreinoMusculo buscaPorNome(String descricao) {
        for (DivisaoTreinoMusculo a : divisoesTreinoMusculo) {
            if (a != null && a.getDescricao().equals(descricao)) {
                return a;
            }
        }
        return null;

    }

    public boolean remover(int id) {
        this.divisoesTreinoMusculo[id - 1] = null;
        return true;
    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < divisoesTreinoMusculo.length; i++) {
            if (divisoesTreinoMusculo[i] == null) {
                return i;
            }

        }
        return -1;

    }
}
