package com.state.negocio.status;

public interface Status {
    Status recebido();
    Status pagamentoAprovado();
    Status notaFiscalDisponivel();
    Status emTransito();
    Status entregue();
}
