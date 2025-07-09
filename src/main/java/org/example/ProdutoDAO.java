package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO {

    public void inserir(Produto produto){
        String sql = "INSERT INTO produtos (nome, preco, quantidade) VALUES (?, ?, ?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());

            stmt.executeUpdate();

            System.out.println("Produto inserido com sucesso!");

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarNome(String nome, String novoNome){
        String sql = "UPDATE produtos SET nome = ? WHERE nome = ?";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, novoNome);
            stmt.setString(2, nome);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Nome atualizado com sucesso!");

    }

    public void atualizarPreco(String nome,double preco){
        String sql = "UPDATE produtos SET preco = ? WHERE nome = ?";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setDouble(1, preco);
            stmt.setString(2, nome);

            stmt.executeUpdate();

            System.out.printf("Preco atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarQuantidade(String nome, int quantidade){
        String sql = "UPDATE produtos SET quantidade = ? WHERE nome = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, quantidade);
            stmt.setString(2, nome);

            stmt.executeUpdate();

            System.out.printf("Quantidade atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarProduto(String nome){
        String sql = "DELETE FROM produtos WHERE nome = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, nome);

            stmt.executeUpdate();

            System.out.println("Produto removido com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
