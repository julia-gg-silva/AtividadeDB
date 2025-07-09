package org.example;

import java.time.LocalDate;

public class Pedido {

    private String nomeCliente;
    private LocalDate dataPedido;
    private double total;

    public Pedido(String nomeCliente, LocalDate dataPedido, double total) {
        this.nomeCliente = nomeCliente;
        this.dataPedido = dataPedido;
        this.total = total;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public double getTotal() {
        return total;
    }
}
