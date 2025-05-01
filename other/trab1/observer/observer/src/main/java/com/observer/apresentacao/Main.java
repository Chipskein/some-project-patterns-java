package com.observer.apresentacao;

import java.util.Date;

import com.observer.negocio.Noticia;
import com.observer.negocio.Revista;
import com.observer.negocio.assinante.PessoaFisica;
import com.observer.negocio.assinante.PessoaJuridica;
import com.observer.negocio.assinante.Idoso;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testando Revista");

        var revista=new Revista("Fofoquitos", "fofoca");
        
        var joao=new PessoaFisica("João Das Neves", "04344859212");
        revista.inscrever(joao);
        
        var kleber=new Idoso("Kleber Macabeus", "0434485933321",60);
        revista.inscrever(kleber);

        var gasEPesca=new PessoaJuridica("Gas e Pesca LTDA", "04344859333212124124");
        revista.inscrever(gasEPesca);

        var noticia1=new Noticia("Noticia 1", "Essa é a noticia 1", new Date());

        revista.adicionarNoticia(noticia1);

        var noticia2=new Noticia("Noticia 2", "Essa é a noticia 2", new Date());
        revista.cancelar(joao);
        revista.adicionarNoticia(noticia2);


        
        
        


        




    }
}