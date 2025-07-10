package org.example;

import com.sun.security.jgss.GSSUtil;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
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
            System.out.println("4. Listar uma tabela");
            System.out.println("5. Buscar por ID");
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
                case 4:
                    listarTabelas();
                    break;
                case 5:
                    buscarPorID();
                    break;
                case 0:
                    System.out.println("Sistema encerrado");
                    System.exit(0);
            }
        } while (opcao != 0);
    }

    private static void buscarPorID() {
        int opcao;
        do{
            System.out.println("--- Bucar por ID ---");
            System.out.println("1. Buscar Alunos");
            System.out.println("2. Buscar Produtos");
            System.out.println("3. Buscar Pedidos");
            System.out.println("4. Buscar Livros");
            System.out.println("5. Buscar Funcionarios");
            System.out.println("0. Voltar");
            System.out.println("Informe o que deseja listar __");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:

            }
        }while (opcao != 0);

    }

    private static void listarTabelas() {
        int opcao;
        do {
            System.out.println("--- Menu Listar ---");
            System.out.println("1. Listar Alunos");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Listar Pedidos");
            System.out.println("4. Listar Livros");
            System.out.println("5. Listar Funcionarios");
            System.out.println("0. Voltar");
            System.out.println("Informe o que deseja listar __");
            opcao = sc.nextInt();
            switch (opcao) {
                case 0:
                    return;
                case 1:
                    listarAlunos();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    listarPedidos();
                    break;
                case 4: listarLivros();

            }
        }while (opcao != 0);
    }

    public static void listarLivros() {

    }

    public static void listarPedidos() {
        PedidoDAO pedidosDAO = new PedidoDAO();

        List<Pedido> pedidos = pedidosDAO.listarPedidos();
        for(Pedido pedido : pedidos) {
            System.out.println("ID: " +pedido.getId());
            System.out.println("Cliente: " + pedido.getNomeCliente());
            System.out.println("Data do pedido: " + pedido.getDataPedido());
            System.out.println("Total: " + pedido.getTotal()+ "\n\n");
        }
    }

    public static void listarProdutos() {
        ProdutoDAO produtoDAO = new ProdutoDAO();

        List<Produto> produtos = produtoDAO.listarProdutos();
        for(Produto produto : produtos) {
            System.out.println("ID: " +produto.getId());
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Preco: " + produto.getPreco());
            System.out.println("Quantidade: " + produto.getQuantidade()+ "\n\n");
        }
    }

    public static void listarAlunos() {
        AlunoDAO alunoDAO = new AlunoDAO();

        List<Aluno> alunos = AlunoDAO.listarAlunos();
        for(Aluno aluno : alunos){
            System.out.println("ID: " +aluno.getId());
            System.out.println("Nome: "+ aluno.getNome());
            System.out.println("Matricula: "+ aluno.getMatricula());
            System.out.println("Curso: "+ aluno.getCurso()+ "\n\n");
        }
    }

    private static void menuExcluir() {
        int opcao;
        do {
            System.out.println("-- Menu Excluir --");
            System.out.println("1. Excluir Alunos");
            System.out.println("2. Excluir Produtos");
            System.out.println("3. Excluir Pedidos");
            System.out.println("4. Excluir Livros");
            System.out.println("5. Excluir Funcionarios");
            System.out.println("0. Voltar");
            System.out.println("Informe o que deseja excluir __");
            opcao = sc.nextInt();
            switch (opcao) {
                case 0:
                    return;
                case 1:
                    sc.nextLine();
                    AlunoDAO alunoDAO = new AlunoDAO();
                    System.out.println("--- Excluir Alunos ---");
                    System.out.println("Digite o nome do aluno que deseja excluir: ");
                    String nomeAluno = sc.next();

                    alunoDAO.deletarAluno(nomeAluno);
                    break;
                case 2:
                    sc.nextLine();
                    ProdutoDAO produtoDAO = new ProdutoDAO();
                    System.out.println("--- Excluir Produtos ---");
                    System.out.println("Digite o nome do produto que deseja excluir: ");
                    String nomeProduto = sc.nextLine();

                    produtoDAO.deletarProduto(nomeProduto);
                    break;
                case 3:
                    sc.nextLine();
                    PedidoDAO pedidoDAO = new PedidoDAO();
                    System.out.println("--- Excluir Pedidos ---");
                    System.out.println("Digite o nome do cliente que realizou o pedido: ");
                    String nomeClie = sc.nextLine();

                    pedidoDAO.deletarPedido(nomeClie);
                    break;
                case 4:
                    sc.nextLine();
                    LivroDAO  livroDAO = new LivroDAO();
                    System.out.println("--- Excluir Livros ---");
                    System.out.println("Digite o titulo do livro que deseja excluir: ");
                    String titulo = sc.nextLine();

                    livroDAO.deletarLivro(titulo);
                    break;
                case 5:
                    sc.nextLine();
                   FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                    System.out.println("--- Excluir Funcionarios ---");
                    System.out.println("Digite o nome do funcionario que deseja excluir: ");
                    String nome = sc.nextLine();

                    funcionarioDAO.deletarFuncionario(nome);
                    break;
                default:
                    System.out.println("Valor inválido, tentente novamente!");
            }
        } while (opcao != 0);
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
                case 2:
                    atualizarProduto();
                    break;
                case 3:
                    atualizarPedidos();
                    break;
                case 4:
                    atualizarLivros();
                    break;
                case 5:
                    atualizarFuncinarios();
                    break;
                default:
                    System.out.println("Valor inválido, tentente novamente!");
            }
        } while (opcao != 0);
    }

    private static void atualizarFuncinarios() {
        int opcao;
        FuncionarioDAO funcionarioDao = new FuncionarioDAO();

        sc.nextLine();

        System.out.println("--- Atualizar Funcionarios ---");
        System.out.println("Informe o nome do Funcionario que deseja atualizar: ");
        String nome = sc.nextLine();

        System.out.println("Escolha o campo que deseja atualizar: ");
        System.out.println("1. Nome");
        System.out.println("2. Cargo");
        System.out.println("3. Salário");
        System.out.println("0. Voltar");
        opcao = sc.nextInt();

        switch (opcao) {
            case 0:
                return;
            case 1:
                sc.nextLine();
                System.out.println("--- Atualizar Nome ---");
                System.out.println("Informe o novo Nome do funcionario: ");
                String novoNome = sc.nextLine();

                funcionarioDao.atualizarNome(nome, novoNome);
                break;
            case 2:
                sc.nextLine();
                System.out.println("--- Atualizar Cargo ---");
                System.out.println("Informe o novo cargo: ");
                String novoCargo = sc.nextLine();

                funcionarioDao.atualizarCargo(nome, novoCargo);
                break;
            case 3:
                sc.nextLine();
                System.out.println("--- Atualizar Salário ---");
                System.out.println("Informe o novo Salario: ");
                Double salario = sc.nextDouble();

                funcionarioDao.atualizarSalario(nome, salario);
                break;
        }

    }

    private static void atualizarLivros() {
        int opcao;
        LivroDAO livroDao = new LivroDAO();

        sc.nextLine();

        System.out.println("--- Atualizar Livros ---");
        System.out.println("Informe o titulo do livro que deseja atualizar: ");
        String tituloLivro = sc.nextLine();

        System.out.println("Escolha o campo que deseja atualizar: ");
        System.out.println("1. Titulo");
        System.out.println("2. Autor");
        System.out.println("3. Ano de publicação");
        System.out.println("0. Voltar");
        opcao = sc.nextInt();

        switch (opcao) {
            case 0:
                return;
            case 1:
                sc.nextLine();
                System.out.println("--- Atualizar titulo ---");
                System.out.println("Informe o novo Titulo do livro: ");
                String novoTitulo = sc.nextLine();

                livroDao.atualizarTitulo(tituloLivro, novoTitulo);
                break;
            case 2:
                sc.nextLine();
                System.out.println("--- Atualizar Autor ---");
                System.out.println("Informe o novo Autor do livro: ");
                String novoAutor = sc.nextLine();

                livroDao.atualizarAutor(tituloLivro, novoAutor);
                break;
            case 3:
                sc.nextLine();
                System.out.println("--- Atualizar Ano Publicação ---");
                System.out.println("Informe o novo Ano de publicação do livro: ");
                String novoAno = sc.nextLine();

                livroDao.atualizarAno(tituloLivro, novoAno);
                break;
        }


    }

    private static void atualizarPedidos() {
        int opcao;
        PedidoDAO pedidoDAO = new PedidoDAO();

        sc.nextLine();
        System.out.println("--- Atualizar Pedido ---");
        System.out.println("Informe o nome do cliente que realizou o pedido: ");
        String nomeCli = sc.nextLine();

        System.out.println("Escolha o campo que deseja atualizar: ");
        System.out.println("1. Cliente");
        System.out.println("2. Total");
        System.out.println("0. VOLTAR");

        opcao = sc.nextInt();
        switch (opcao) {
            case 0:
                return;
            case 1:
                sc.nextLine();
                System.out.println("--- Atualizar Cliente ---");
                System.out.println("Digite o novo nome do cliente: ");
                String novoNome = sc.nextLine();

                pedidoDAO.atualizarNome(nomeCli, novoNome);
                break;
            case 2:
                sc.nextLine();
                System.out.println("--- Atualizar Total ---");
                System.out.println("Digite o novo total: ");
                double novoTotal = sc.nextDouble();

                pedidoDAO.atualizarTotal(nomeCli, novoTotal);
                break;
            default:
                System.out.println("Valor inválido, tentente novamente!");
                break;
        }
    }

    private static void atualizarProduto() {
        int opcao;
        ProdutoDAO produtoDAO = new ProdutoDAO();

        sc.nextLine();
        System.out.println("--- Atualizar Produto ---");
        System.out.println("Informe o nome do produto que deseja atualizar: ");
        String nome = sc.nextLine();

        System.out.println("Escolha o campo que deseja atualizar: ");
        System.out.println("1. Nome");
        System.out.println("2. Preço");
        System.out.println("3. Quantidade");
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

                produtoDAO.atualizarNome(nome, novoNome);
                break;
            case 2:
                sc.nextLine();
                System.out.println("--- Atualizar preço ---");
                System.out.println("Digite o novo preço: ");
                double novoPreco = sc.nextDouble();

                produtoDAO.atualizarPreco(nome, novoPreco);
                break;
            case 3:
                sc.nextLine();
                System.out.println("--- Atualizar quantidade ---");
                System.out.println("Digite a nova quantidade: ");
                int novaQuantidade = sc.nextInt();

                produtoDAO.atualizarQuantidade(nome, novaQuantidade);
                break;
            default:
                System.out.println("Valor inválido, tentente novamente!");
                break;
        }

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