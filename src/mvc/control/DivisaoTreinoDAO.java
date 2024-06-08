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
public class DivisaoTreinoDAO {
    
    private DivisaoTreino[] divisoesTreino = new DivisaoTreino[100];
    
        public DivisaoTreinoDAO() {
        DivisaoTreino d1 = new DivisaoTreino();
        d1.setNome("ABC");
        d1.setDescricao("Treina 2x e descansa 1x");
        d1.setDataCriacao(LocalDate.now());
        this.adiciona(d1);
        
        DivisaoTreino d2 = new DivisaoTreino();
        d2.setNome("ABCD");
        d2.setDescricao("Treina 3x e descansa 1x");
        d2.setDataCriacao(LocalDate.now());
        this.adiciona(d2);
        
        DivisaoTreino d3 = new DivisaoTreino();
        d3.setNome("ABCDE");
        d3.setDescricao("Treina 4x e descansa 1x");
        d3.setDataCriacao(LocalDate.now());
        this.adiciona(d3);
        
        DivisaoTreino d4 = new DivisaoTreino();
        d4.setNome("FULL");
        d4.setDescricao("Treina todos os dias");
        d4.setDataCriacao(LocalDate.now());
        this.adiciona(d4);
    }
    
    public boolean adiciona(DivisaoTreino a) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            divisoesTreino[proximaPosicaoLivre] = a;
            return true;
        } else {
            return false;
        }

    }

    public boolean ehVazio() {
        for (DivisaoTreino divis : divisoesTreino) {
            if (divis != null) {
                return false;
            }
        }
        return true;

    }

    public void mostrarTodos() {
        boolean temDivisaoTreino = false;
        for (DivisaoTreino d : divisoesTreino) {
            if (d != null) {
                System.out.println(d);
                temDivisaoTreino = true;
            }
        }
        if (!temDivisaoTreino) {
            System.out.println("não existe divisões de treino cadastradas");
        }
    }

    public boolean alterar(int id, String novoNome, String novaDescricao) {
       
        if(this.buscaPorId(id) != null){
            divisoesTreino[id].setNome(novoNome);
            divisoesTreino[id].setDescricao(novaDescricao);
            divisoesTreino[id].setDataModificacao(LocalDate.now());
            System.out.println("Alteracao feita com sucesso");
            return true;
        }else{
            System.out.println("Erro!");
            return false;
        }

    }

    DivisaoTreino buscaPorNome(String nome) {
        for (DivisaoTreino d : divisoesTreino) {
            if (d != null && d.getNome().equals(nome)) {
                return d;
            }
        }
        return null;

    }
    
    public DivisaoTreino buscaPorId(int id) {
        for (DivisaoTreino d : divisoesTreino) {
            if (d != null && d.getId() == id) {
                return d;
            }
        }
        return null;
    }
    
    

    public boolean remover(int id) {
      if(this.buscaPorId(id) != null){
          divisoesTreino[id] = null;
          System.out.println("Remoção realizada com sucesso!");
          return true;
      }else{
          System.out.println("Erro.");
          return false;
      }
    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < divisoesTreino.length; i++) {
            if (divisoesTreino[i] == null) {
                return i;
            }

        }
        return -1;

    }
    
}
