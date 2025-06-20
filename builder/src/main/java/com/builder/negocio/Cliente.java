package com.builder.negocio;

public class Cliente extends Pessoa {
    
    private String nomeMae;
    
    private String cpf;
    
    private Endereco endereco;

    public Cliente(int id, String nome, Endereco endereco,String nomeMae,String cpf) {
        super(id, nome);
        this.nomeMae=nomeMae;
        this.cpf=cpf;
        this.endereco = endereco;
    }



    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nomeMae='" + nomeMae + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco=" + endereco+
                '}';
    }
}