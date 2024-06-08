/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package academia;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

        do {
//            gui.limpar();
            opcao = gui.menuCadastrarExercicio();

            switch (opcao) {
                case 1:
                    Exercicio e = new Exercicio();
                    System.out.println("Informe o nome do exercicio:");
                    e.setNome(scan.nextLine());
                    e.setDataCriacao(LocalDate.now());
                    System.out.println("Descreva o exercicio:");
                    e.setDescricao(scan.nextLine());
                    exer.adiciona(e);
                    break;

                case 2:
                    exer.mostrarTodos();
                    break;

                case 3:
                    exer.mostrarTodos();
                    System.out.println("Informe o nome da exercicio que deseja remover:");
                    String nome = scan.nextLine();
                    exer.remover(nome);
                    break;

                case 4:
                    exer.mostrarTodos();
                    System.out.println("Informe o nome da exercicio que deseja editar:");
                    nome = scan.nextLine();
                    if (exer.buscaPorNome(nome) != null) {
                        System.out.println("Informe o novo nome:");
                        String novoNome = scan.nextLine();
                        System.out.println("Informe a descrição:");
                        String novaDescrição = scan.nextLine();
                        exer.alterarNome(nome, novoNome, novaDescrição);
                    }
                    break;
                case 5:
                    System.out.println("Saindo..");
                    break;
            }

        } while (opcao != 5);
    }

    private void cadastrarExercicioAplicacao() {
        int opcao, id;

        do {
            opcao = gui.menuCadastrarExercicioAplicacao();

            switch (opcao) {
                case 1:
                    Exercicio_Aplicacao e_ap = new Exercicio_Aplicacao();
                    System.out.println("Informe como a maneira que se dará as repetições dos exercicios");
                    e_ap.setDescricao(scan.nextLine());
                    e_ap.setDataCriacao(LocalDate.now());
                    exer_ap.adiciona(e_ap);
                    break;

                case 2:
                    exer_ap.mostrarTodos();
                    break;

                case 3:
                    exer_ap.mostrarTodos();
                    System.out.println("Informe o id para remover:");
                    id = Integer.parseInt(scan.nextLine());
                    exer_ap.remover(id);
                    break;

                case 4:
                    exer_ap.mostrarTodos();
                    System.out.println("Informe o id que deseja editar:");
                    id = Integer.parseInt(scan.nextLine());

                    if (exer_ap.buscaPorId(id) != null) {
                        System.out.println("Informe a nova descrição:");
                        String novaDescrição = scan.nextLine();
                        exer_ap.alterar(id, novaDescrição);
                    }
                    break;
                case 5:
                    System.out.println("Saindo..");
                    break;
            }

        } while (opcao != 5);
    }

    private void cadastrarDivisaoDeTreino() {
        int opcao, id;

        do {
            opcao = gui.menuCadastrarDivisaoDeTreino();

            switch (opcao) {
                case 1:
                    DivisaoTreino div = new DivisaoTreino();
                    System.out.println("Informe uma divisao de treino: ");
                    div.setNome(scan.nextLine());
                    System.out.println("Informe a descricao do treino: ");
                    div.setDescricao(scan.nextLine());
                    div.setDataCriacao(LocalDate.now());
                    di_trei.adiciona(div);
                    break;

                case 2:
                    di_trei.mostrarTodos();
                    break;

                case 3:
                    di_trei.mostrarTodos();
                    System.out.println("Informe o id para remover:");
                    id = Integer.parseInt(scan.nextLine());
                    di_trei.remover(id);
                    break;

                case 4:
                    di_trei.mostrarTodos();
                    System.out.println("Informe o id que deseja editar:");
                    id = Integer.parseInt(scan.nextLine());

                    if (di_trei.buscaPorId(id) != null) {
                        System.out.println("Informe o novo nome da Divisao de Treino:");
                        String novoNome = scan.nextLine();
                        System.out.println("Informe a nova descrição:");
                        String novaDescrição = scan.nextLine();
                        di_trei.alterar(id, novoNome, novaDescrição);
                    }
                    break;
                case 5:
                    System.out.println("Saindo..");
                    break;
            }

        } while (opcao != 5);
    }

    private void cadastrarDivisaoDeTreinoMusculo() {
        int opcao, id;

        do {
            opcao = gui.menuCadastrarDivisaoDeTreinoMusculo();

            switch (opcao) {
                case 1:
                    DivisaoTreinoMusculo treinoMusculo = new DivisaoTreinoMusculo();
                    System.out.println("Escolha o id do treino que deseja fazer: ");
                    di_trei.mostrarTodos();
                    id = Integer.parseInt(scan.nextLine());
                    if (di_trei.buscaPorId(id) != null) {
                        DivisaoTreino escolhaUsuario = di_trei.buscaPorId(id);
                        treinoMusculo.setDivisaoDeTreino(escolhaUsuario);
                    }

                    treinoMusculo.setDataCriacao(LocalDate.now());
                    System.out.println("Descreva como será o treino do musculo: ");
                    treinoMusculo.setDescricao(scan.nextLine());
                    di_trei_musc.adiciona(treinoMusculo);
                    break;

                case 2:
                    di_trei_musc.mostraTudo();
                    break;

                case 3:
                    di_trei_musc.mostraTudo();
                    System.out.println("Escolha um ID para remover:");
                    id = Integer.parseInt(scan.nextLine());
                    di_trei_musc.remover(id);
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
                    di_trei.mostrarTodos();
                    System.out.println("Escolha uma divisão de treino. Informe o id correspondente:");
                    id = Integer.parseInt(scan.nextLine());
                    div.setDivisaoDeTreino(di_trei.buscaPorId(id - 1));
                    System.out.println("Informe quando será o início do(s) treino(s). (dd/MM/yyyy)");
                    div.setDatainicio(scan.nextLine());
                    System.out.println("Informe quando será o final do(s) treino(s). (dd/MM/yyyy)");
                    div.setDatatermino(scan.nextLine());
                    div.setDataCriacao(LocalDate.now());
                    treinoo.adiciona(div);
                    break;

                case 2:
                    treinoo.mostrarTodos();
                    break;

                case 3:
                    treinoo.mostrarTodos();
                    System.out.println("Informe o id para remover:");
                    id = Integer.parseInt(scan.nextLine());
                    id = id - 1;
                    treinoo.remover(id);
                    break;

                case 4:
                    treinoo.mostrarTodos();
                    System.out.println("Informe o id que deseja editar:");
                    id = Integer.parseInt(scan.nextLine());
                    System.out.println(id);
                    Treino a = treinoo.buscaPorId(id);

                    if (a != null) {

                        System.out.println("Altere o objetivo do treino: ");
                        String objetivo = scan.nextLine();
                        di_trei.mostrarTodos();
                        System.out.println("Altere a divisão de treino. Informe o id correspondente:");
                        int id2 = Integer.parseInt(scan.nextLine());
                        DivisaoTreino diTrei = di_trei.buscaPorId(id2);
                        System.out.println("Informe quando será o novo início do(s) treino(s). (dd/MM/yyyy)");
                        String dataInicio = scan.nextLine();
                        System.out.println("Informe quando será o final do(s) treino(s). (dd/MM/yyyy)");
                        String dataFim = scan.nextLine();
                        treinoo.alterar(id, objetivo, diTrei, dataInicio, dataFim);
                    }
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

                    di_trei.mostrarTodos();
                    System.out.println("Escolha uma divisão de Treino: ");
                    id = Integer.parseInt(scan.nextLine());

                    DivisaoTreino dt = di_trei.buscaPorId(id);
                    if (dt != null) {
                        t.setDivisaoDeTreino(dt);
                    } else {
                        System.out.println("Não deu certo");
                        break;
                    }
                    di_trei_musc.mostraTudo();
                    System.out.println("Escolha um treino de acordo com o músculo: ");
                    id = Integer.parseInt(scan.nextLine());
                    DivisaoTreinoMusculo dtm = di_trei_musc.buscaPorId(id);

                    if (dtm != null) {
                        t.setDivisaoDeTreinoMusculo(dtm);
                    } else {
                        System.out.println("Não deu certo");
                        break;
                    }

                    exer.mostrarTodos();
                    System.out.println("Escolha um treino de acordo com o músculo: ");
                    id = Integer.parseInt(scan.nextLine());
                    Exercicio e = exer.buscaPorId(id);
                    if (e != null) {
                        t.setExercício(e);
                    } else {
                        System.out.println("Não deu certo");
                        break;
                    }

                    exer_ap.mostrarTodos();
                    System.out.println("Escolha a forma como o execicio será aplicado: ");
                    id = Integer.parseInt(scan.nextLine());
                    Exercicio_Aplicacao ea = exer_ap.buscaPorId(id);
                    if (ea != null) {
                        t.setExercícioAplicacao(ea);
                    } else {
                        System.out.println("Não deu certo");
                        break;
                    }

                    treinoo.mostrarTodos();
                    System.out.println("Escolha um treino: ");
                    id = Integer.parseInt(scan.nextLine());
                    Treino tr = treinoo.buscaPorId(id);
                    if (tr != null) {
                        t.setTreino(tr);
                    } else {
                        System.out.println("Não deu certo");
                        break;
                    }
                    aplicatreino.adiciona(t);
                    break;

                case 2:
                    aplicatreino.mostrarTodos();
                    break;

                case 3:
                    treinoo.mostrarTodos();
                    System.out.println("Informe o id para remover:");
                    id = Integer.parseInt(scan.nextLine());
                    id = id - 1;
                    treinoo.remover(id);
                    break;

                case 4:
                    treinoo.mostrarTodos();
                    System.out.println("Informe o id que deseja editar:");
                    id = Integer.parseInt(scan.nextLine());
                    System.out.println(id);
                    Treino a = treinoo.buscaPorId(id);

                    if (a != null) {

                        System.out.println("Altere o objetivo do treino: ");
                        String objetivo = scan.nextLine();
                        di_trei.mostrarTodos();
                        System.out.println("Altere a divisão de treino. Informe o id correspondente:");
                        int id2 = Integer.parseInt(scan.nextLine());
                        DivisaoTreino diTrei = di_trei.buscaPorId(id2);
                        System.out.println("Informe quando será o novo início do(s) treino(s). (dd/MM/yyyy)");
                        String dataInicio = scan.nextLine();
                        System.out.println("Informe quando será o final do(s) treino(s). (dd/MM/yyyy)");
                        String dataFim = scan.nextLine();
                        treinoo.alterar(id, objetivo, diTrei, dataInicio, dataFim);
                    }
                    break;
                case 5:
                    System.out.println("Saindo..");
                    break;
            }

        } while (opcao != 5);
    }

}
