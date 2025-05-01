package com.state.apresentacao;

import java.util.List;

import com.state.negocio.Item;
import com.state.negocio.Pedido;
public class Main {
    public static void main(String[] args) {
        System.out.println("Simulando o padrão State");

        List<Item> itens = List.of(
            new Item("Coisa 1", "Alguma coisa", 12.0, 1),
            new Item("Coisa 2", "Alguma coisa", 32.0, 2)
        );
        
        Pedido pedido = new Pedido("Pedido 1", "Rus seila","5398122512","teste@gmail.com",itens);

        pedido.iniciar();
        pedido.recebido();
        System.out.println("Pagando o pedido...");
        pedido.setPago(true);
        pedido.recebido();
        pedido.pagamentoAprovado();
        pedido.notaFiscalDisponivel();
        pedido.emTransito();
        pedido.entregue();
    }
}