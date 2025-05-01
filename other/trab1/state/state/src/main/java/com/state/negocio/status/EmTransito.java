package com.state.negocio.status;

import com.state.negocio.Pedido;

public class EmTransito implements Status {

    Pedido pedido;

    public EmTransito(Pedido pedido) {
        System.out.println("Pedido " + pedido.getNome() + " está em trânsito.");
        this.pedido = pedido;
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
        return new Entregue(pedido);
    }

    @Override
    public Status entregue() {
        return this;
    }
    
}
