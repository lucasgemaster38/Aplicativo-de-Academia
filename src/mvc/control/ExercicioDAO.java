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
public class ExercicioDAO {
    private Exercicio exercicios[] = new Exercicio[100];
    
    
    public ExercicioDAO() {
        Exercicio a1 = new Exercicio();
        a1.setDataCriacao(LocalDate.now());
        a1.setDescricao("barra com pesos");
        a1.setNome("supino reto");
        this.adiciona(a1);
        
        Exercicio a2 = new Exercicio();
        a2.setDataCriacao(LocalDate.now());
        a2.setDescricao("flexão dos joelhos com ou sem peso");
        a2.setNome("agachamento");
        this.adiciona(a2);
        
        Exercicio a3 = new Exercicio();
        a3.setDataCriacao(LocalDate.now());
        a3.setDescricao("caminhada ou corrida na esteira");
        a3.setNome("aeróbico");
        this.adiciona(a3);
        
    }   
    
    public boolean adiciona(Exercicio a) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            exercicios[proximaPosicaoLivre] = a;
            return true;
        } else {
            return false;
        }

    }

    public boolean ehVazio() {
        for (Exercicio exer : exercicios) {
            if (exer != null) {
                return false;
            }
        }
        return true;

    }

    public void mostrarTodos() {
        boolean temExercicio = false;
        for (Exercicio a : exercicios) {
            if (a != null) {
                System.out.println(a);
                temExercicio = true;
            }
        }
        if (!temExercicio) {
            System.out.println("não existe Exercicio cadastrado");
        }
    }

    public boolean alterarNome(String nome, String novoNome, String novaDescricao) {
        for (Exercicio exer : exercicios) {
            if (exer != null && exer.getNome().equals(nome)) {
                exer.setNome(novoNome);
                exer.setDescricao(novaDescricao);
                return true;
            }
        }
        return false;

    }

    public Exercicio buscaPorNome(String nome) {
        for (Exercicio a : exercicios) {
            if (a != null && a.getNome().equals(nome)) {
                return a;
            }
        }
        return null;

    }
    
    public Exercicio buscaPorId(long id) {
        for (Exercicio a : exercicios) {
            if (a != null && a.getId() == id) {
                return a;
            }
        }
        return null;

    }
    
    

    public boolean remover(String nome) {
        for (int i = 0; i < exercicios.length; i++) {
            if (exercicios[i] != null && exercicios[i].getNome().equals(nome)) {
                exercicios[i] = null;
                return true;
            }
        }
        return false;

    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < exercicios.length; i++) {
            if (exercicios[i] == null) {
                return i;
            }

        }
        return -1;

    }
}
