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
public class Exercicio_AplicacaoDAO {
    private Exercicio_Aplicacao ex_aplicacao[] = new Exercicio_Aplicacao[100];

    public Exercicio_AplicacaoDAO() {
        Exercicio_Aplicacao e1 = new Exercicio_Aplicacao();
        e1.setDataCriacao(LocalDate.now());
        e1.setDescricao("4x12");
        this.adiciona(e1);
        
        Exercicio_Aplicacao e2 = new Exercicio_Aplicacao();
        e2.setDataCriacao(LocalDate.now());
        e2.setDescricao("3x10");
        this.adiciona(e2);
        
        Exercicio_Aplicacao e3 = new Exercicio_Aplicacao();
        e3.setDataCriacao(LocalDate.now());
        e3.setDescricao("3x8");
        this.adiciona(e3);
        
        Exercicio_Aplicacao e4 = new Exercicio_Aplicacao();
        e4.setDataCriacao(LocalDate.now());
        e4.setDescricao("corrida");
        this.adiciona(e4);
        
        Exercicio_Aplicacao e5 = new Exercicio_Aplicacao();
        e5.setDataCriacao(LocalDate.now());
        e5.setDescricao("caminhada");
        this.adiciona(e5);
        
    }
    
    
    
    public boolean adiciona(Exercicio_Aplicacao a) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            ex_aplicacao[proximaPosicaoLivre] = a;
            return true;
        } else {
            return false;
        }

    }

    public boolean ehVazio() {
        for (Exercicio_Aplicacao exer_ap: ex_aplicacao) {
            if (exer_ap != null) {
                return false;
            }
        }
        return true;

    }

    public void mostrarTodos() {
        boolean temExercicioAplicacao = false;
        for (Exercicio_Aplicacao a : ex_aplicacao) {
            if (a != null) {
                System.out.println(a);
                temExercicioAplicacao = true;
            }
        }
        if (!temExercicioAplicacao) {
            System.out.println("não existe Exercicio Aplicação cadastrado");
        }
    }

    public boolean alterar(int id, String novaDescricao) {
       
        if(this.buscaPorId(id) != null){
            ex_aplicacao[id].setDescricao(novaDescricao);
            ex_aplicacao[id].setDataModificacao(LocalDate.now());
            System.out.println("Alteracao feita com sucesso");
            return true;
        }else{
            System.out.println("Erro!");
            return false;
        }

    }

    Exercicio_Aplicacao buscaPorNome(String descricao) {
        for (Exercicio_Aplicacao a : ex_aplicacao) {
            if (a != null && a.getDescricao().equals(descricao)) {
                return a;
            }
        }
        return null;

    }
    
    public Exercicio_Aplicacao buscaPorId(int id) {
        for (Exercicio_Aplicacao a : ex_aplicacao) {
            if (a != null && a.getId() == id) {
                return a;
            }
        }
        return null;

    }
    
    

    public boolean remover(int id) {
      if(this.buscaPorId(id) != null){
          ex_aplicacao[id] = null;
          System.out.println("Remoção realizada com sucesso!");
          return true;
      }else{
          System.out.println("Erro.");
          return false;
      }
    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < ex_aplicacao.length; i++) {
            if (ex_aplicacao[i] == null) {
                return i;
            }

        }
        return -1;

    }
}
