package com.state.negocio.status;
import com.state.negocio.Pedido;
public class PagamentoAprovado implements Status {

    Pedido pedido;
    public PagamentoAprovado(Pedido pedido) {
        System.out.println("Pagamento do pedido " + pedido.getNome() + " aprovado.");
        this.pedido = pedido;
    }

    @Override
    public Status recebido() {
        return this;
    }

    @Override
    public Status pagamentoAprovado() {
        return new NotaFiscalDisponivel(pedido);
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
