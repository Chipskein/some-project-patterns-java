package com.builder.apresentacao;

import java.time.LocalDate;
import java.util.ArrayList;

import com.builder.negocio.Cliente;
import com.builder.negocio.Endereco;
import com.builder.negocio.Item;
import com.builder.negocio.Pedido;
import com.builder.negocio.Produto;
import com.builder.negocio.Vendedor;

public class Main {
    public static void main(String[] args) {
        Vendedor vendedor = new Vendedor(1, "João", LocalDate.now());
        Cliente cliente = new Cliente(1, "Igor", new Endereco(1, "alfredo huch", "bgv", "1000", "sem complemento"),"Maria","1111111111");
        Produto produto1 = new Produto(1, "Produto1", 100, 2);
        Produto produto2 = new Produto(2, "Produto2", 200, 3);

        ArrayList<Item> items = new ArrayList<Item>();

        Item item1 = new Item(produto1, 2, produto1.getPreco());
        Item item2 = new Item(produto2, 4, produto2.getPreco());
        items.add(item1);
        items.add(item2);
        
        Pedido pedido = new Pedido.Builder()
            .vendedor(vendedor)
            .cliente(cliente)
            .items(items)
            .id(12)
            .build()
        ;
        System.out.println(pedido);  
    }
}