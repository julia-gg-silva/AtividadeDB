package org.example;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

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
}
