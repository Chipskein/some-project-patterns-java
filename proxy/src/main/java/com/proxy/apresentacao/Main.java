package com.proxy.apresentacao;

import java.time.LocalDate;

import com.proxy.negocio.Carro;
import com.proxy.negocio.Empregado;
import com.proxy.negocio.GarageSistema;
import com.proxy.negocio.ProxyProtecao;

public class Main {
    public static void main(String[] args) {
        var car1=new Carro(2000, "Ka", "Ford", "ABC1234", "01234567");
        var emp1=new Empregado("Usuario Menor de Idade", LocalDate.of(2010, 12, 5));
        var emp2=new Empregado("Usuario Maior de Idade e Manobrista", LocalDate.of(2000, 12, 5),"124124124");
        var emp3=new Empregado("Usuario Maior sem CNH", LocalDate.of(2000, 5, 5));
        var proxy=new ProxyProtecao(new GarageSistema());
        proxy.manobrar(emp2, car1);
        System.out.println("======================================");
        proxy.manobrar(emp1, car1);
        System.out.println("======================================");
        proxy.manobrar(emp3, car1);
        System.out.println("======================================");
    }
}