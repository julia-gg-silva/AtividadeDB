package org.example;

import javax.security.auth.login.AppConfigurationEntry;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public List<Pedido> listarPedidos(){
        List<Pedido> pedidos = new ArrayList<>();

        String sql = "SELECT cliente,data_pedido,total FROM pedidos";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt  = conn.prepareStatement(sql)){

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){

                String cliente = rs.getString("cliente");
                LocalDate dataPedido = rs.getDate("data_pedido").toLocalDate();
                double total = rs.getDouble("total ");

                Pedido pedido = new Pedido(cliente, dataPedido, total);
                pedidos.add(pedido);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pedidos;
    }
}
