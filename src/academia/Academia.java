/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package academia;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import mvc.control.Academia1;
import mvc.control.Academia1DAO;
import mvc.control.DivisaoTreino;
import mvc.control.DivisaoTreinoDAO;
import mvc.control.DivisaoTreinoMusculo;
import mvc.control.DivisaoTreinoMusculoDAO;
import mvc.control.Exercicio;
import mvc.control.ExercicioDAO;
import mvc.control.Exercicio_Aplicacao;
import mvc.control.Exercicio_AplicacaoDAO;
import mvc.control.Pessoa;
import mvc.control.PessoaDAO;
import mvc.control.Treino;
import mvc.control.TreinoAplicacao;
import mvc.control.TreinoAplicacaoDAO;
import mvc.control.TreinoDAO;
import mvc.control.Util;
import mvc.view.GUI;

/**
 *
 * @author lucas
 */
public class Academia {

    GUI gui = new GUI();
    Academia1DAO academ = new Academia1DAO();
    PessoaDAO pesso = new PessoaDAO();
    ExercicioDAO exer = new ExercicioDAO();
    Exercicio_AplicacaoDAO exer_ap = new Exercicio_AplicacaoDAO();
    DivisaoTreinoDAO di_trei = new DivisaoTreinoDAO();
    DivisaoTreinoMusculoDAO di_trei_musc = new DivisaoTreinoMusculoDAO();
    TreinoDAO treinoo = new TreinoDAO();
    TreinoAplicacaoDAO aplicatreino = new TreinoAplicacaoDAO();
    Scanner scan = new Scanner(System.in);
    int opcaoUsuario;

    public Academia() throws IOException, InterruptedException {
        int log = 0;
        while (log == 0) {
//            if (this.Logado() != null) {
            log = 1;
            do {

                opcaoUsuario = this.opcaoDecadastro();
                switch (opcaoUsuario) {
                    case 1:
                        this.cadastrarAcademia();
                        break;
                    case 2:
                        this.cadastrarPessoa();
                        break;
                    case 3:
                        this.cadastrarExercicio();
                        break;
                    case 4:
                        this.cadastrarExercicioAplicacao();
                        break;
                    case 5:
                        this.cadastrarDivisaoDeTreino();
                        break;
                    case 6:
                        this.cadastrarDivisaoDeTreinoMusculo();
                        break;
                    case 7:
                        this.cadastrarTreino();
                        break;
                    case 8:
                        this.cadastrarTreinoAplicacao();
                        break;
                    case 9:
                        System.out.println("saindo...");
                        break;
                }
            } while (opcaoUsuario != 9);

//            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        new Academia();
    }

//    private Pessoa Logado() {
//        StringBuilder builder = new StringBuilder("");
//        builder.append("SEJA BEM VINDO AO MEU PROGRAMA\n\n");
//        builder.append("\n Logar com usuario e senha");
//        System.out.print(builder.toString());
//
//        System.out.println("Login: ");
//        String login = scan.nextLine();
//        System.out.println("Senha:");
//        String senha = scan.nextLine();
//        Pessoa logada = pesso.buscaPessoaLogin(login, senha);
//
//        if (logada != null) {
//            System.out.println("Pessoa logada");
//            Util.setPessoaLogada(logada);
//            System.out.println("pessoa logada e: " + Util.getPessoaLogada().toString());
//            return logada;
//
//        } else {
//            System.out.println("Login Inválido. Tente novamente");
//            return null;
//        }
//
//    }
    private int opcaoDecadastro() {
        int opcao = 0;
        StringBuilder builder2 = new StringBuilder("");
        builder2.append("1 - CADASTRO DE ACADEMIAS\n\n");
        builder2.append("2 - CADASTRO DE PESSOAS\n\n");
        builder2.append("3 - CADASTRO DE EXERCICIO\n\n");
        builder2.append("4 - CADASTRO DE EXERCICIO E SUA APLICACAO\n\n");
        builder2.append("5 - CADASTRO DE DIVISAO DE TREINO\n\n");
        builder2.append("6 - CADASTRO DE DIVISAO DE TREINO POR MUSCULO\n\n");
        builder2.append("7 - CADASTRO DE TREINO\n\n");
        builder2.append("8 - CADASTRO DE TREINO E SUA APLICACAO\n\n");
        builder2.append("9 - SAIR\n\n");
        System.out.print(builder2.toString());
        System.out.println("Escolha uma opcao:");
        opcao = Integer.parseInt(scan.nextLine());
        return opcao;
    }

    private void cadastrarAcademia() {
        int opcao;
        List<Academia1> lista;
        int id;
        Academia1 academia;

        do {
            opcao = gui.menuCadastrarAcademia();

            switch (opcao) {
                case 1:
                    Academia1 a = new Academia1();
                    a.setDataCriacao(LocalDateTime.now());
                    System.out.println("Informe o nome da academia: ");
                    a.setNome(scan.nextLine());
                    System.out.println("Informe o endereco da academia: ");
                    a.setEndereco(scan.nextLine());
                    academ.adiciona(a);
                    break;

                case 2:
                    mostraAcademias();
                    break;

                case 3:

                    mostraAcademias();
                    System.out.println("Informe o id da academia que deseja remover:");
                    id = Integer.parseInt(scan.nextLine());
                    academia = obtemAcademia(id);
                    academ.exclui(academia);
                    System.out.println("Academia excluída com sucesso");
                    break;

                case 4:
                    mostraAcademias();
                    System.out.println("Informe o id da academia que deseja editar:");
                    id = Integer.parseInt(scan.nextLine());
                    academia = obtemAcademia(id);
                    System.out.println("Nome: ");
                    academia.setNome(scan.nextLine());
                    System.out.println("Endereco");
                    academia.setEndereco(scan.nextLine());
                    academia.setDataModificacao(LocalDateTime.now());
                    academ.altera(academia);
                    break;
                case 5:
                    System.out.println("Saindo..");
                    break;
            }

        } while (opcao != 5);

    }

    private Academia1 obtemAcademia(int id) {
        Academia1 academia = new Academia1();
        academia.setId(id);
        return academia;
    }

    private void mostraAcademias() {
        List<Academia1> lista;
        lista = academ.lista(null);
        for (Academia1 academia1 : lista) {
            System.out.println(academia1);
        }
    }

    private void cadastrarPessoa() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int opcao;
        List<Pessoa> lista;
        int id;
        do {
            opcao = gui.menuCadastrarPessoa();

            switch (opcao) {
                case 1:
                    Pessoa a = new Pessoa();
                    System.out.println("Infome o nome:");
                    a.setNome(scan.nextLine());
                    System.out.println("Informe a data de nascimento: ");
                    a.setNascimento(LocalDate.parse(scan.nextLine(), dtf));
                    System.out.println("Informe o sexo: ");
                    a.setSexo(scan.nextLine());
                    System.out.println("Informe um login: ");
                    a.setLogin(scan.nextLine());
                    System.out.println("Informe uma senha: ");
                    a.setSenha(scan.nextLine());
                    a.setDataCriacao(LocalDateTime.now());
                    a.setDataModificacao(LocalDateTime.now());
                    System.out.println("\nInforme o tipo do usuario: ");
                    System.out.println("\n1 - administrador");
                    System.out.println("\n2 - Instrutor");
                    System.out.println("\n3 - Usuario");
                    a.setTipoUsuario(Integer.parseInt(scan.nextLine()));

                    if (pesso.adiciona(a) != null) {
                        System.out.println("Adicionado com sucesso");
                    } else {
                        System.out.println("Erro. Contate o superte.");
                    }
                    break;

                case 2:
                    lista = pesso.lista(null);
                    System.out.println("\n");
                    System.out.println("PESSOAS CADASTRADAS2"
                            + ": ");
                    for (Pessoa pessoa : lista) {
                        System.out.println(pessoa);
                    }
                    System.out.println("\n");

                    break;

                case 3:
                    lista = pesso.lista(null);
                    for (Pessoa pessoa : lista) {
                        System.out.println(pessoa);
                    }
                    System.out.println("Informe o id da usuario que deseja remover:");
                    id = Integer.parseInt(scan.nextLine());
                    Pessoa pessoa = obtemPessoa(id);
                    pesso.exclui(pessoa);
                    System.out.println("Pessoa excluída com sucesso");

                    break;
                case 4:
                    System.out.println("Informe o id da pessoa que deseja editar:");
                    id = Integer.parseInt(scan.nextLine());
                    Pessoa pessoaAlterada = obtemPessoa(id);

                    System.out.println("Infome o nome:");
                    pessoaAlterada.setNome(scan.nextLine());

                    System.out.println("Informe o sexo: ");
                    pessoaAlterada.setSexo(scan.nextLine());

                    System.out.println("Informe a data de nascimento: ");
                    pessoaAlterada.setNascimento(LocalDate.parse(scan.nextLine(), dtf));

                    System.out.println("Informe um novo login: ");
                    pessoaAlterada.setLogin(scan.nextLine());

                    System.out.println("Informe uma nova senha: ");
                    pessoaAlterada.setSenha(scan.nextLine());
                    pessoaAlterada.setDataModificacao(LocalDateTime.now());

                    System.out.println("\nInforme o tipo do usuario: ");
                    System.out.println("\n1 - administrador");
                    System.out.println("\n2 - Instrutor");
                    System.out.println("\n3 - Usuario");

                    pessoaAlterada.setTipoUsuario(Integer.parseInt(scan.nextLine()));

                    pesso.altera(pessoaAlterada);
                    System.out.println("Alteração realizada com sucesso");

                    break;

                case 5:
                    System.out.println("Saindo..");
                    break;
            }

        } while (opcao != 5);
    }

    private Pessoa obtemPessoa(int id) {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        return pessoa;
    }

    private void cadastrarExercicio() throws IOException, InterruptedException {
        int opcao;
        List<Exercicio> lista;
        int id;
        Exercicio exercicio;
        do {
//            gui.limpar();
            opcao = gui.menuCadastrarExercicio();

            switch (opcao) {
                case 1:
                    Exercicio e = new Exercicio();
                    System.out.println("Informe o nome do exercicio:");
                    e.setNome(scan.nextLine());
                    e.setDataCriacao(LocalDateTime.now());
                    e.setDataModificacao(LocalDateTime.now());
                    System.out.println("Descreva o exercicio:");
                    e.setDescricao(scan.nextLine());
                    exer.adiciona(e);
                    break;

                case 2:
                    mostrarExercicios();
                    break;

                case 3:
                    mostrarExercicios();
                    System.out.println("Informe o id do exercicio que deseja remover:");
                    id = Integer.parseInt(scan.nextLine());
                    exercicio = obtemExercicio(id);
                    exer.exclui(exercicio);
                    break;

                case 4:
                    mostrarExercicios();
                    System.out.println("Informe o id do exercicio que deseja editar:");
                    id = Integer.parseInt(scan.nextLine());
                    exercicio = obtemExercicio(id);
                    System.out.println("Informe o novo nome:");
                    exercicio.setNome(scan.nextLine());
                    System.out.println("Informe a descrição:");
                    exercicio.setDescricao(scan.nextLine());
                    exercicio.setDataModificacao(LocalDateTime.now());
                    exer.altera(exercicio);
                    break;
                case 5:
                    System.out.println("Saindo..");
                    break;
            }

        } while (opcao != 5);
    }

    private void mostrarExercicios() {
        System.out.println("\nEXERCICIOS");
        List<Exercicio> lista;
        lista = exer.lista(null);
        for (Exercicio exercicio : lista) {
            System.out.println(exercicio);
        }
        System.out.println("\n");
    }

    private Exercicio obtemExercicio(int id) {
        Exercicio exercicio = new Exercicio();
        exercicio.setId(id);
        return exercicio;
    }

    private void cadastrarExercicioAplicacao() {
        int id, opcao;
        Exercicio_Aplicacao aplicacao;
        do {
            opcao = gui.menuCadastrarExercicioAplicacao();

            switch (opcao) {
                case 1:
                    Exercicio_Aplicacao e_ap = new Exercicio_Aplicacao();
                    System.out.println("Informe a aplicação dos exercicios");
                    e_ap.setDescricao(scan.nextLine());
                    e_ap.setDataCriacao(LocalDateTime.now());
                    e_ap.setDataModificacao(LocalDateTime.now());
                    exer_ap.adiciona(e_ap);
                    break;

                case 2:
                    mostrarExerciciosAplicacao();
                    break;

                case 3:
                    mostrarExerciciosAplicacao();
                    System.out.println("Informe o id do exercicio aplicação que deseja remover:");
                    id = Integer.parseInt(scan.nextLine());
                    aplicacao = obtemExercicioAplicacao(id);
                    exer_ap.exclui(aplicacao);
                    break;

                case 4:
                    mostrarExerciciosAplicacao();
                    System.out.println("Informe o id do exercicio que deseja editar:");
                    id = Integer.parseInt(scan.nextLine());
                    aplicacao = obtemExercicioAplicacao(id);
                    System.out.println("Informe a descrição:");
                    aplicacao.setDescricao(scan.nextLine());
                    aplicacao.setDataModificacao(LocalDateTime.now());
                    exer_ap.altera(aplicacao);
                    break;
                case 5:
                    System.out.println("Saindo..");
                    break;
            }

        } while (opcao != 5);
    }

    private void mostrarExerciciosAplicacao() {
        System.out.println("\nEXERCICIOS APLICACAO");
        List<Exercicio_Aplicacao> lista;
        lista = exer_ap.lista(null);
        for (Exercicio_Aplicacao exercicio_Aplicacao : lista) {
            System.out.println(exercicio_Aplicacao);
        }
        System.out.println("\n");
    }

    private Exercicio_Aplicacao obtemExercicioAplicacao(int id) {
        Exercicio_Aplicacao aplicacao = new Exercicio_Aplicacao();
        aplicacao.setId(id);
        return aplicacao;
    }

    private void cadastrarDivisaoDeTreino() {
        int opcao, id;
        DivisaoTreino divTreino;
        int quantidade = 1;

        do {
            opcao = gui.menuCadastrarDivisaoDeTreino();

            switch (opcao) {
                case 1:
                    DivisaoTreino div = new DivisaoTreino();
                    System.out.println("Informe uma divisao de treino: ");
                    div.setNome(scan.nextLine());

                    do {
                        //essa parte do código limita o usuário a digitar numeros
                        //maiores que 7 ou menores que zero. Afinal, a semana tem somente
                        //7 dias. Comumente, não há treinos que durem mais de 1 semana.
                        System.out.println("Informe a quantidade de dias desse treino");
                        quantidade = Integer.parseInt(scan.nextLine());
                        if (quantidade > 7 || quantidade < 1) {
                            System.out.println("\nA quantidade de dias deve durar até 7.\n");
                        }
                    } while (quantidade > 7);

                    div.setQuantidade(quantidade);
                    System.out.println("Informe a descricao do treino: ");
                    div.setDescricao(scan.nextLine());
                    div.setDataCriacao(LocalDateTime.now());
                    div.setDataModificacao(LocalDateTime.now());
                    di_trei.adiciona(div);
                    break;

                case 2:
                    mostrarDivisoesDeTreino();
                    break;

                case 3:
                    mostrarDivisoesDeTreino();
                    System.out.println("Informe o id para remover:");
                    id = Integer.parseInt(scan.nextLine());
                    divTreino = obtemDivisaoDeTreino(id);
                    di_trei.exclui(divTreino);
                    break;

                case 4:
                    mostrarDivisoesDeTreino();
                    System.out.println("Informe o id que deseja editar:");
                    id = Integer.parseInt(scan.nextLine());
                    divTreino = obtemDivisaoDeTreino(id);
                    System.out.println("Informe o novo nome da Divisao de Treino:");
                    divTreino.setNome(scan.nextLine());
                    System.out.println("Informe a quantidade de dias desse treino");
                    divTreino.setQuantidade(Integer.parseInt(scan.nextLine()));
                    System.out.println("Informe a nova descrição:");
                    divTreino.setDescricao(scan.nextLine());
                    divTreino.setDataModificacao(LocalDateTime.now());
                    di_trei.altera(divTreino);

                    break;
                case 5:
                    System.out.println("Saindo..");
                    break;
            }

        } while (opcao != 5);
    }

    private void mostrarDivisoesDeTreino() {
        System.out.println("\nDIVISÕES DE TREINO");
        List<DivisaoTreino> lista;
        lista = di_trei.lista(null);
        for (DivisaoTreino divisaoTreino : lista) {
            System.out.println(divisaoTreino);
        }
        System.out.println("\n");
    }

    private DivisaoTreino obtemDivisaoDeTreino(int id) {
        DivisaoTreino aplicacao = new DivisaoTreino();
        aplicacao.setId(id);
        return aplicacao;
    }

    private void cadastrarDivisaoDeTreinoMusculo() {
        int opcao, id;
        DivisaoTreino divTreino;
        do {
            opcao = gui.menuCadastrarDivisaoDeTreinoMusculo();

            switch (opcao) {
                case 1:
                    mostrarDivisoesDeTreino();
                    System.out.println("\nEscolha o id do treino que deseja fazer: \n");
                    id = Integer.parseInt(scan.nextLine());
                    divTreino = di_trei.buscaPorId(id);
                    
                    if (di_trei.buscaPorId(id) != null) {
                        int quantidade = 0;
                        while (quantidade < divTreino.getQuantidade()) {
                            DivisaoTreinoMusculo treinoMusculo = new DivisaoTreinoMusculo();
                            treinoMusculo.setDivisaoDeTreino(divTreino);
                            treinoMusculo.setDataCriacao(LocalDateTime.now());
                            treinoMusculo.setDataModificacao(LocalDateTime.now());
                            System.out.println((quantidade + 1) + " - Descrição do treino de musculo: ");
                            treinoMusculo.setDescricao(scan.nextLine());
                            di_trei_musc.adiciona(treinoMusculo);
                            quantidade++;
                        }
                    } else {
                        System.out.println("\nEsse treino não existe.\n");
                    }

                    break;

                case 2:
                       mostrarDivisoesDeTreinoMusculo();
                    break;

                case 3:

//                    System.out.println("Escolha um ID para remover:");
//                    id = Integer.parseInt(scan.nextLine());
//                    divTreino = obtemDivisaoDeTreino(id);
//                    di_trei_musc.exclui();
                    break;
                case 4:
//                    di_trei_musc.mostrarTodos();
//                    System.out.println("Informe o id que deseja editar:");
//                    id = Integer.parseInt(scan.nextLine());
//
//                    if (di_trei_musc.buscaPorId(id) != null) {
//                        System.out.println("Informe o novo nome da Divisao de Treino:");
//                        String novoNome = scan.nextLine();
//                        System.out.println("Informe a nova descrição:");
//                        String novaDescrição = scan.nextLine();
//                        di_trei_musc.alterar(id, novoNome, novaDescrição);
//                    }
                    break;
                case 5:
                    System.out.println("Saindo..");
                    break;
            }

        } while (opcao != 5);
    }

    private void mostrarDivisoesDeTreinoMusculo() {
        System.out.println("\nDIVISÕES DE TREINO MUSCULO: ");
        List<DivisaoTreinoMusculo> lista;
        lista = di_trei_musc.lista(null);
        long d = -1;
        for (DivisaoTreinoMusculo divisaoTreinoMusculo : lista) {
            
            if(divisaoTreinoMusculo.getDivisaoDeTreino().getId() != d){
                System.out.println("\nTreino: " + divisaoTreinoMusculo.getDivisaoDeTreino().getNome() + ": ");
                d = divisaoTreinoMusculo.getDivisaoDeTreino().getId();
            }
            System.out.println(divisaoTreinoMusculo);
        }
    }

    private DivisaoTreinoMusculo obtemDivisaoDeTreinoMusculo(int id) {
        DivisaoTreinoMusculo aplicacao = new DivisaoTreinoMusculo();
        aplicacao.setId(id);
        return aplicacao;
    }

    private void cadastrarTreino() {
        int opcao, id;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        do {
            opcao = gui.menuCadastrarTreino();

            switch (opcao) {
                case 1:

                    Treino div = new Treino();
                    System.out.println("Informe o objetivo do treino: ");
                    div.setObjetivo(scan.nextLine());
//                    di_trei.mostrarTodos();
                    System.out.println("Escolha uma divisão de treino. Informe o id correspondente:");
                    id = Integer.parseInt(scan.nextLine());
//                    div.setDivisaoDeTreino(di_trei.buscaPorId(id - 1));
                    System.out.println("Informe quando será o início do(s) treino(s). (dd/MM/yyyy)");
                    div.setDatainicio(scan.nextLine());
                    System.out.println("Informe quando será o final do(s) treino(s). (dd/MM/yyyy)");
                    div.setDatatermino(scan.nextLine());
                    div.setDataCriacao(LocalDate.now());
//                    treinoo.adiciona(div);
                    break;

                case 2:
//                    treinoo.mostrarTodos();
                    break;

                case 3:
//                    treinoo.mostrarTodos();
                    System.out.println("Informe o id para remover:");
                    id = Integer.parseInt(scan.nextLine());
                    id = id - 1;
//                    treinoo.remover(id);
                    break;

                case 4:
////                    treinoo.mostrarTodos();
//                    System.out.println("Informe o id que deseja editar:");
//                    id = Integer.parseInt(scan.nextLine());
//                    System.out.println(id);
////                    Treino a = treinoo.buscaPorId(id);
//
//                    if (a != null) {
//
//                        System.out.println("Altere o objetivo do treino: ");
//                        String objetivo = scan.nextLine();
////                        di_trei.mostrarTodos();
//                        System.out.println("Altere a divisão de treino. Informe o id correspondente:");
//                        int id2 = Integer.parseInt(scan.nextLine());
////                        DivisaoTreino diTrei = di_trei.buscaPorId(id2);
//                        System.out.println("Informe quando será o novo início do(s) treino(s). (dd/MM/yyyy)");
//                        String dataInicio = scan.nextLine();
//                        System.out.println("Informe quando será o final do(s) treino(s). (dd/MM/yyyy)");
//                        String dataFim = scan.nextLine();
////                        treinoo.alterar(id, objetivo, diTrei, dataInicio, dataFim);
//                    }
                    break;
                case 5:
                    System.out.println("Saindo..");
                    break;
            }

        } while (opcao != 5);

    }

    private void cadastrarTreinoAplicacao() {
        int opcao, id;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        do {
            opcao = gui.menuCadastrarTreino();

            switch (opcao) {
                case 1:
                    TreinoAplicacao t = new TreinoAplicacao();
                    t.setDataCriacao(LocalDate.now());

//                    di_trei.mostrarTodos();
                    System.out.println("Escolha uma divisão de Treino: ");
                    id = Integer.parseInt(scan.nextLine());

//                    DivisaoTreino dt = di_trei.buscaPorId(id);
//                    if (dt != null) {
//                        t.setDivisaoDeTreino(dt);
//                    } else {
//                        System.out.println("Não deu certo");
//                        break;
//                    }
//                    di_trei_musc.mostraTudo();
//                    System.out.println("Escolha um treino de acordo com o músculo: ");
//                    id = Integer.parseInt(scan.nextLine());
//                    DivisaoTreinoMusculo dtm = di_trei_musc.buscaPorId(id);
//
//                    if (dtm != null) {
//                        t.setDivisaoDeTreinoMusculo(dtm);
//                    } else {
//                        System.out.println("Não deu certo");
//                        break;
//                    }

//                    exer.mostrarTodos();
//                    System.out.println("Escolha um treino de acordo com o músculo: ");
//                    id = Integer.parseInt(scan.nextLine());3
//                    Exercicio e = exer.buscaPorId(id);
//                    if (e != null) {
////                        t.setExerci?cio(e);
//                    } else {
//                        System.out.println("Não deu certo");
//                        break;
//                    }
//                    exer_ap.mostrarTodos();
//                    System.out.println("Escolha a forma como o execicio será aplicado: ");
//                    id = Integer.parseInt(scan.nextLine());
//                    Exercicio_Aplicacao ea = exer_ap.buscaPorId(id);
//                    if (ea != null) {
////                        t.setExerci?cioAplicacao(ea);
//                    } else {
//                        System.out.println("Não deu certo");
//                        break;
//                    }
//                    treinoo.mostrarTodos();
                    System.out.println("Escolha um treino: ");
                    id = Integer.parseInt(scan.nextLine());
//                    Treino tr = treinoo.buscaPorId(id);
//                    if (tr != null) {
//                        t.setTreino(tr);
//                    } else {
//                        System.out.println("Não deu certo");
//                        break;
//                    }
//                    aplicatreino.adiciona(t);
                    break;

                case 2:
//                    aplicatreino.mostrarTodos();
                    break;

                case 3:
//                    treinoo.mostrarTodos();
//                    System.out.println("Informe o id para remover:");
//                    id = Integer.parseInt(scan.nextLine());
//                    id = id - 1;
//                    treinoo.remover(id);
                    break;

                case 4:
//                    treinoo.mostrarTodos();
//                    System.out.println("Informe o id que deseja editar:");
//                    id = Integer.parseInt(scan.nextLine());
//                    System.out.println(id);
//                    Treino a = treinoo.buscaPorId(id);
//
//                    if (a != null) {
//
//                        System.out.println("Altere o objetivo do treino: ");
//                        String objetivo = scan.nextLine();
////                        di_trei.mostrarTodos();
//                        System.out.println("Altere a divisão de treino. Informe o id correspondente:");
//                        int id2 = Integer.parseInt(scan.nextLine());
////                        DivisaoTreino diTrei = di_trei.buscaPorId(id2);
//                        System.out.println("Informe quando será o novo início do(s) treino(s). (dd/MM/yyyy)");
//                        String dataInicio = scan.nextLine();
//                        System.out.println("Informe quando será o final do(s) treino(s). (dd/MM/yyyy)");
////                        String dataFim = scan.nextLine();
////                        treinoo.alterar(id, objetivo, diTrei, dataInicio, dataFim);
//                    }
                    break;
                case 5:
                    System.out.println("Saindo..");
                    break;
            }

        } while (opcao != 5);
    }


}
