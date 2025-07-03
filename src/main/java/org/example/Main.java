package org.example;

import com.sun.security.jgss.GSSUtil;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);


    public void menu() {
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

    private void cadastroAlunos() {


    }

    public static void main(String[] args) {
        UsuarioDAO userDao = new UsuarioDAO();

        System.out.println("Digite o nome do usuario: ");
        String nome = sc.nextLine();

        System.out.println("Digite o email do usuario: ");
        String email = sc.nextLine();

        Usuario user = new Usuario(nome, email);

        userDao.inserir(user);
    }
}