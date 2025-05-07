package com.proxy.negocio;

public class Carro {
 
    private int ano;
    private String modelo;
    private String marca;
    private String placa;
    private String chassi;

    public Carro(int ano, String modelo, String marca, String placa, String chassi) {
        this.ano = ano;
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
        this.chassi = chassi;
    }

    public void manobrar(Empregado empregado){
        System.out.println("Carro:"+marca+" "+modelo+" "+ano);
        System.out.println("Placa:"+placa);
        System.out.println("Chassi:"+chassi);
        System.out.println("Manobrado por");
        System.out.println("Nome:"+empregado.getNome());
        System.out.println("CNH:"+empregado.getCnh());
        System.out.println("Idade:"+empregado.calcularIdade());
        System.out.println("Data Nascimento:"+empregado.getData_nascimento());
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }
    
}
