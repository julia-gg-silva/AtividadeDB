package org.example;

import com.sun.security.jgss.GSSUtil;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void menu() {
        int opcao;
        do {
            System.out.println("--- Manipulação de Itens ---");
            System.out.println("1. Cadastrar um item");
            System.out.println("2. Atualizar um item");
            System.out.println("3. Excluir um item");
            System.out.println("0. Sair");
            System.out.println("Opção desejada __");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    menuCadastro();
                    break;
                case 2:
                    menuAtualizar();
                    break;
                case 3:
                    menuExcluir();
                    break;
                case 0:
                    System.out.println("Sistema encerrado");
                    System.exit(0);
            }
        } while (opcao != 0);
    }

    private static void menuExcluir() {
    }


    public static void menuAtualizar() {
        int opcao;
        do {
            System.out.println("-- Menu Atualizar --");
            System.out.println("1. Atualizar Alunos");
            System.out.println("2. Atualizar Produtos");
            System.out.println("3. Atualizar Pedidos");
            System.out.println("4. Atualizar Livros");
            System.out.println("5. Atualizar Funcionarios");
            System.out.println("0. Voltar");
            System.out.println("Informe o que deseja atualizar __");
            opcao = sc.nextInt();
            switch (opcao) {
                case 0:
                    return;
                case 1:
                    atualizarAluno();
                    break;
//                case 2: atualizarProduto();
//                    break;
//                case 3: atualizarPedidos();
//                    break;
//                case 4:  atualizarLivros();
//                    break;
//                case 5: atualizarFuncinarios();
//                    break;
                default:
                    System.out.println("Valor inválido, tentente novamente!");
            }
        } while (opcao != 0);
    }

    private static void atualizarAluno() {
        int opcao;
        AlunoDAO alunoDao = new AlunoDAO();
        sc.nextLine();
        System.out.println("--- Atualizar aluno ---");
        System.out.println("Informe o nome do aluno que deseja atualizar: ");
        String nome = sc.nextLine();

        System.out.println("Escolha o campo que deseja atualizar: ");
        System.out.println("1. Nome");
        System.out.println("2. Matricula");
        System.out.println("3. Curso");
        System.out.println("0. VOLTAR");

        opcao = sc.nextInt();

        switch (opcao) {
            case 0:
                return;
            case 1:
                sc.nextLine();
                System.out.println("--- Atualizar nome ---");
                System.out.println("Digite o novo nome: ");
                String novoNome = sc.nextLine();

                alunoDao.atualizarNome(nome, novoNome);
                break;
            case 2:
                sc.nextLine();
                System.out.println("--- Atualizar matricula ---");
                System.out.println("Digite a nova matricula: ");
                int novaMatricula = sc.nextInt();

                alunoDao.atualizarMatricula(nome, novaMatricula);
                break;

            case 3:
                sc.nextLine();

                System.out.println("--- Atualizar curso ---");
                System.out.println("Digite o novo curso: ");
                String novoCurso = sc.nextLine();

                alunoDao.atualizarCurso(nome, novoCurso);
                break;

            default:
                System.out.println("Opção inválida! Tente novamente!");
        }

    }

    public static void menuCadastro() {
        int opcao;
        do {
            System.out.println("-- Menu de Cadastro --");
            System.out.println("1. Cadastro Alunos");
            System.out.println("2. Cadastro de Produtos");
            System.out.println("3. Cadastro de Pedidos");
            System.out.println("4. Cadastro de Livros");
            System.out.println("5. Cadastro de Funcionarios");
            System.out.println("0. Voltar");
            System.out.println("Informe o que deseja cadastrar __");
            opcao = sc.nextInt();
            switch (opcao) {
                case 0:
                    return;
                case 1:
                    cadastroAlunos();
                    break;
                case 2:
                    cadastroProdutos();
                    break;
                case 3:
                    cadastroPedido();
                    break;
                case 4:
                    cadastroLivros();
                    break;
                case 5:
                    cadastroFuncionarios();
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 0);

    }

    private static void cadastroFuncionarios() {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        sc.nextLine();

        System.out.println("Digite o nome do funcionario: ");
        String nome = sc.nextLine();

        System.out.println("Digite o cargo do funcionario: ");
        String cargo = sc.nextLine();


        System.out.println("Digite o salário do funcionario: ");
        double salario = sc.nextDouble();

        Funcionario funcionario = new Funcionario(nome, cargo, salario);

        funcionarioDAO.inserir(funcionario);

    }

    private static void cadastroLivros() {
        LivroDAO livroDAO = new LivroDAO();

        sc.nextLine();

        System.out.println("Digite o titulo do livro: ");
        String titulo = sc.nextLine();

        System.out.println("Digite o autor do livro: ");
        String autor = sc.nextLine();

        System.out.println("Digite o ano de publicação do livro: ");
        int ano = sc.nextInt();

        Livro livro = new Livro(titulo, autor, ano);

        livroDAO.inserir(livro);
    }

    private static void cadastroPedido() {
        PedidoDAO pedidoDAO = new PedidoDAO();

        sc.nextLine();

        System.out.println("Digite o cliente do pedido: ");
        String nomeCliente = sc.nextLine();

        LocalDate dataPedido = LocalDate.now();


        System.out.println("Digite o valor total do pedido: ");
        double total = sc.nextDouble();

        Pedido pedido = new Pedido(nomeCliente, dataPedido, total);

        pedidoDAO.inserir(pedido);

    }

    private static void cadastroProdutos() {

        ProdutoDAO produtoDAO = new ProdutoDAO();

        sc.nextLine();

        System.out.println("Digite o nome do produto: ");
        String nome = sc.nextLine();

        System.out.println("Digite o preço do produto: ");
        double preco = sc.nextDouble();

        sc.nextLine();

        System.out.println("Digite o quantidade do produto: ");
        int quantidade = sc.nextInt();

        Produto produto = new Produto(nome, preco, quantidade);

        produtoDAO.inserir(produto);

    }

    private static void cadastroAlunos() {

        AlunoDAO alunoDAO = new AlunoDAO();

        sc.nextLine();

        System.out.println("Digite o nome do aluno: ");
        String nome = sc.nextLine();

        System.out.println("Digite a matrícula do aluno: ");
        int matricula = sc.nextInt();

        sc.nextLine();

        System.out.println("Digite o curso do aluno: ");
        String curso = sc.nextLine();

        Aluno aluno = new Aluno(nome, matricula, curso);

        alunoDAO.inserir(aluno);

    }

    public static void main(String[] args) {
        menu();
    }
}