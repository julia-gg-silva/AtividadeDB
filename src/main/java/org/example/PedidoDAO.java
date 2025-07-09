package org.example;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PedidoDAO {

    public void inserir(Pedido pedido){
        String sql = "INSERT INTO pedidos(cliente, data_pedido, total) VALUES (?, ?, ?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1,pedido.getNomeCliente());
            stmt.setDate(2, Date.valueOf(pedido.getDataPedido()));
            stmt.setDouble(3, pedido.getTotal());

            stmt.executeUpdate();
            System.out.println("Pedido adicionado com sucesso!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void atualizarNome(String nomeCli, String novoNome){

        String sql = "UPDATE pedidos SET cliente = ? WHERE cliente = ?";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, novoNome);
            stmt.setString(2, nomeCli);

            stmt.executeUpdate();

            System.out.println("Cliente atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarTotal(String nomeCli, double total){

        String sql = "UPDATE pedidos SET total = ? WHERE cliente = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setDouble(1,total);
            stmt.setString(2, nomeCli);

            stmt.executeUpdate();

            System.out.println("Total atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarPedido(String cliente){
        String sql = "DELETE FROM pedidos WHERE cliente = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, cliente);

            stmt.executeUpdate();

            System.out.println("Pedido removido com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
