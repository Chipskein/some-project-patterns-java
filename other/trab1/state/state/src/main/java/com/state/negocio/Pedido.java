package com.state.negocio;

import com.state.negocio.status.Status;
import com.state.negocio.status.Recebido;
import java.util.List;
import java.util.ArrayList;

public class Pedido {
    private String nome;
    
    private String endereco;
    
    private String telefone;
    
    private String email;
    
    private Status status;

    private List<Item> items;

    private boolean pago=false;

    private boolean entregue=false;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public boolean isEntregue() {
        return entregue;
    }

    public void setEntregue(boolean entregue) {
        this.entregue = entregue;
    }

    public Pedido(String nome, String endereco, String telefone, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.items = new ArrayList<>();
    }

    public Pedido(String nome, String endereco, String telefone, String email,List<Item> items) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.items = items;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void iniciar() {
        if (status == null) {
            status = new Recebido(this);
        }
    }

    public void recebido() {
        if (status == null) return ;
        status = status.recebido();
    }

    public void pagamentoAprovado() {
        if (status == null) return ;
        status = status.pagamentoAprovado();
    }

    public void notaFiscalDisponivel() {
        if (status == null) return ;
        status = status.notaFiscalDisponivel();
    }

    public void emTransito() {
        if (status == null) return ;
        status = status.emTransito();
    }

    public void entregue() {
        if (status == null) return ;
        status = status.entregue();
    }
}
