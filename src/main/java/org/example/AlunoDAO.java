package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    public void inserir(Aluno aluno) {
        String sql = "INSERT INTO alunos (nome, matricula, curso) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getMatricula());
            stmt.setString(3, aluno.getCurso());

            stmt.executeUpdate();

            System.out.println("Aluno inserido com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarNome(String nome, String novoNome) {
        String sql = "UPDATE alunos SET nome = ? WHERE nome = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoNome);
            stmt.setString(2, nome);

            stmt.executeUpdate();

            System.out.println("Nome atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void atualizarMatricula(String nome, int novaMatricula) {
        String sql = "UPDATE alunos SET matricula = ? WHERE nome = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, novaMatricula);
            stmt.setString(2, nome);

            stmt.executeUpdate();
            System.out.println("Matricula atualizada com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarCurso(String nome, String novoCurso) {

        String sql = "UPDATE alunos SET curso = ? WHERE nome = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoCurso);
            stmt.setString(2, nome);

            stmt.executeUpdate();
            System.out.println("Curso atualizada com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarAluno(String nome) {
        String sql = "DELETE FROM alunos WHERE nome = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);

            stmt.executeUpdate();

            System.out.println("Aluno removido com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Aluno> listarAlunos() {
        List<Aluno> alunos = new ArrayList<>();

        String sql = "SELECT nome,matricula,curso FROM alunos";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet set = stmt.executeQuery();

            while (set.next()) {

                String nome = set.getString("nome");
                int matricula = set.getInt("matricula");
                String curso = set.getString("curso");

                Aluno aluno = new Aluno(nome, matricula, curso);

                alunos.add(aluno);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alunos;
    }
}
