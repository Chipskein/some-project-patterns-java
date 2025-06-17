package com.builder.negocio;

import java.util.ArrayList;

public class Pedido {

    private int id;
    
    private Cliente cliente;
    
    private Vendedor vendedor;
    
    private ArrayList<Item> items;
    
    private Pedido(Builder builder) {
        this.id = builder.id;
        this.cliente = builder.cliente;
        this.vendedor = builder.vendedor;
        this.items = builder.items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", vendedor=" + vendedor +
                ", items=" + items +
                '}';
    }

    public static class Builder{
        private int id;
        
        private Cliente cliente;
        
        private Vendedor vendedor;
        
        private ArrayList<Item> items;

        public Builder id(int id) {
            this.id = id;
            return this;
        }
        
        public Builder cliente(Cliente cliente) {
            this.cliente = cliente;
            return this;
        }

        public Builder vendedor(Vendedor vendedor) {
            this.vendedor = vendedor;
            return this;
        }

        public Builder items(ArrayList<Item> items) {
            this.items = items;
            return this;
        }

        public Pedido build() {
            return new Pedido(this);
        }
    }
    
}