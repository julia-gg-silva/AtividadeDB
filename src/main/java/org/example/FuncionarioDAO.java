package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FuncionarioDAO {

    public void inserir(Funcionario funcionario){

        String sql = "INSERT INTO funcionarios(nome, cargo, salario) VALUES(?,?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.setDouble(3, funcionario.getSalario());

            stmt.executeUpdate();
            System.out.println("Funcionario inserido com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarNome(String nome, String novoNome){
        String sql = "UPDATE funcionarios SET nome = ? WHERE nome = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, novoNome);
            stmt.setString(2, nome);

            stmt.executeUpdate();
            System.out.println("Nome atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarCargo(String nome, String cargo){
        String sql = "UPDATE funcionarios SET cargo = ? WHERE nome = ?";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, cargo);
            stmt.setString(2, nome);

            stmt.executeUpdate();
            System.out.println("Cargo atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarSalario(String nome, double salario){
        String sql = "UPDATE funcionarios SET salario = ? WHERE nome = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setDouble(1, salario);
            stmt.setString(2, nome);

            stmt.executeUpdate();
            System.out.println("Salário atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarFuncionario(String nome){
        String sql = "DELETE FROM funcionarios WHERE nome = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, nome);

            stmt.executeUpdate();

            System.out.println("Funcionario removido com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}


