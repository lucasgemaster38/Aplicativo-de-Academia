/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.view;

import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class GUI {

    public int menuCadastrarAcademia() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Cadastrar Academia");
        System.out.println("2. Mostrar Academias");
        System.out.println("3. Remover Academias");
        System.out.println("4. Editar Academias");
        System.out.println("5. Sair");
        System.out.println("Escolha uma opcao valida");
        return Integer.parseInt(scan.nextLine());
    }

    public int menuCadastrarPessoa() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Cadastrar Pessoa");
        System.out.println("2. Mostrar Pessoas");
        System.out.println("3. Remover Pessoas");
        System.out.println("4. Editar Pessoas");
        System.out.println("5. Sair");
        System.out.println("Escolha uma opcao valida");
        return Integer.parseInt(scan.nextLine());
    }

    public int menuCadastrarExercicio() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Cadastrar Exercicio");
        System.out.println("2. Mostrar Exercicios cadastrados");
        System.out.println("3. Remover Exercicios Cadastrados");
        System.out.println("4. Editar Exercicios");
        System.out.println("5. Sair");
        System.out.println("Escolha uma opcao valida");
        return Integer.parseInt(scan.nextLine());
    }

    public int menuCadastrarExercicioAplicacao() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Cadastrar Aplicacao");
        System.out.println("2. Mostrar Aplicacoes exercicios cadastrados");
        System.out.println("3. Remover Aplicacoes Exercicios Cadastrados");
        System.out.println("4. Editar Aplicacoes Exercicios");
        System.out.println("5. Sair");
        System.out.println("Escolha uma opcao valida");
        return Integer.parseInt(scan.nextLine());
    }

    public int menuCadastrarDivisaoDeTreino() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Cadastrar Divisão de Treino");
        System.out.println("2. Mostrar Divisoes de Treino");
        System.out.println("3. Remover Divisoes de Treino");
        System.out.println("4. Editar Divisoes de Treino");
        System.out.println("5. Sair");
        System.out.println("Escolha uma opcao valida");
        return Integer.parseInt(scan.nextLine());
    }

    public int menuCadastrarDivisaoDeTreinoMusculo() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Cadastrar Divisão de Treino por Musculo");
        System.out.println("2. Mostrar Divisoes de Treino por Musculo");
        System.out.println("3. Remover Divisoes de Treino por Musculo");
        System.out.println("4. Editar Divisoes de Treino por Musculo");
        System.out.println("5. Sair");
        System.out.println("Escolha uma opcao valida");
        return Integer.parseInt(scan.nextLine());
    }

    public int menuCadastrarTreino() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Cadastrar Treino");
        System.out.println("2. Mostrar Treinos");
        System.out.println("3. Remover Treinos");
        System.out.println("4. Editar Treinos");
        System.out.println("5. Sair");
        System.out.println("Escolha uma opcao valida");
        return Integer.parseInt(scan.nextLine());
    }
}
