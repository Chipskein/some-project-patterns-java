package com.state.negocio.status;

import com.state.negocio.Pedido;
public class Entregue implements Status{
    Pedido pedido;

    public Entregue(Pedido pedido) {
        System.out.println("Pedido " + pedido.getNome() + " entregue.");
        this.pedido = pedido;
        pedido.setEntregue(true);
    }

    @Override
    public Status recebido() {
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
