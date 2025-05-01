package com.state.negocio.status;

import com.state.negocio.Pedido;
public class NotaFiscalDisponivel implements Status {

    Pedido pedido;

    public NotaFiscalDisponivel(Pedido pedido) {
        System.out.println("Nota fiscal do pedido " + pedido.getNome() + " disponível.");
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
        return new EmTransito(pedido);
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
