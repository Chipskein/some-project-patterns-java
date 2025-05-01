package com.state.negocio.status;

import com.state.negocio.Pedido;

public class Recebido implements Status {
    
    Pedido  pedido;

    public Recebido(Pedido pedido) {
        System.out.println("Pedido " + pedido.getNome() + " recebido.");
        this.pedido = pedido;
    }

    @Override
    public Status recebido() {
        if(pedido.isPago()) return new PagamentoAprovado(pedido);
        System.out.println("Pedido " + pedido.getNome() + " não foi pago.");
        return this;
    }

    @Override
    public Status pagamentoAprovado() {
        return this;
    }

    @Override
    public Status notaFiscalDisponivel() {
        return this;
    }

    @Override
    public Status emTransito() {
        return this;
    }

    @Override
    public Status entregue() {
        return this;
    }
}