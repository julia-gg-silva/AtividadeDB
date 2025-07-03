package org.example;

import com.sun.security.jgss.GSSUtil;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
     private static final Scanner sc = new Scanner(System.in);


    public static void menu() {
        System.out.println("-- Cadastro de Itens --");
        System.out.println("1. Cadastro Alunos");
        System.out.printf("2 . Cadastro de Produtos");
        System.out.println("3. Cadastro de Pedidos");
        System.out.println("4. Cadastro de Livros");
        System.out.println("5. Cadastro de Funcionarios");
        System.out.println("0. Sair");
        System.out.println("Informe o que deseja cadastrar __");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1: cadastroAlunos(); break;
            case 2: cadastroProdutos(); break;
            case 3: cadastroPedido(); break;
            case 4: cadastroLivros(); break;
            case 5: cadastroFuncionarios(); break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
                break;
        }

    }

    private static void cadastroAlunos() {

        AlunoDAO alunoDAO = new AlunoDAO();

        System.out.println("Digite o nome do aluno: ");
        String nome = sc.nextLine();

        System.out.println("Digite a matrícula do aluno: ");
        int matricula = sc.nextInt();

        System.out.println("Digite o curso do aluno: ");
        String curso = sc.nextLine();

        Aluno aluno = new Aluno(nome, matricula, curso);

        alunoDAO.inserir(aluno);

    }

    public static void main(String[] args) {
        menu();
    }
}