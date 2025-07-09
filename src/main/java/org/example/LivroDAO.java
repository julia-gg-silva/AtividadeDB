package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LivroDAO {

    public void inserir(Livro livro){

        String sql = "INSERT INTO livros (titulo, autor, ano_publicacao) VALUES (?, ?, ?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getAnoPublicacao());

            stmt.executeUpdate();
            System.out.println("Livro inserido com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarTitulo(String tituloLivro, String novoTitulo){

        String sql = "UPDATE livros SET titulo = ? WHERE titulo = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, novoTitulo);
            stmt.setString(2, tituloLivro);

            stmt.executeUpdate();
            System.out.println("Titulo atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void atualizarAutor(String tituloLivro, String novoAutor){

        String sql = "UPDATE livros SET autor = ? WHERE titulo = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, novoAutor);
            stmt.setString(2, tituloLivro);

            stmt.executeUpdate();
            System.out.println("Autor atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarAno(String tituloLivro, String novoAno){

        String sql = "UPDATE livros SET ano_publicacao = ? WHERE titulo = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, novoAno);
            stmt.setString(2, tituloLivro);

            stmt.executeUpdate();
            System.out.println("Ano de publicação atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarLivro(String titulo){
        String sql = "DELETE FROM livros WHERE titulo = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, titulo);

            stmt.executeUpdate();

            System.out.println("Livro removido com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
