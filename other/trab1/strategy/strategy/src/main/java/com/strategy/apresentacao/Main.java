package com.strategy.apresentacao;
import com.strategy.negocio.produto.Livro;
import com.strategy.negocio.produto.Brinquedo;
import com.strategy.negocio.produto.DVD;
import com.strategy.negocio.produto.promocao.Liquidacao;
import com.strategy.negocio.produto.promocao.Regular;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("Testando Loja Virtual");
        Livro livro = new Livro("O Senhor dos Anéis", 39.90, "J.R.R. Tolkien", "Fantasia");
        
        Brinquedo brinquedo = new Brinquedo("Carrinho de Controle Remoto", 99.90, "5 a 10 anos", "Carrinho");
        
        DVD dvd = new DVD("Star Wars", 29.90, "George Lucas", "Ficção Científica");

        DVD dvd2 = new DVD("Matrix", 100.0, "Lana Wachowski", "Ficção Científica");

        System.out.println("Sem desconto:");
        System.out.println("\t"+livro.getNome()+" "+livro.calPreco());
        System.out.println("\t"+brinquedo.getNome()+" "+brinquedo.calPreco());
        System.out.println("\t"+dvd.getNome()+" "+dvd.calPreco());
        

        System.out.println("Com desconto regular 10% + 7% Extra:");
        
        livro.setPromocao(new Regular(0.07));
        System.out.println("\t"+livro.getNome()+" "+livro.calPreco());

        System.out.println("Com desconto regular 10% + 5% Extra:");
        brinquedo.setPromocao(new Regular(0.05));
        System.out.println("\t"+brinquedo.getNome()+" "+brinquedo.calPreco());


        
        System.out.println("Com desconto liqidação 30%:");
        dvd2.setPromocao(new Liquidacao());
        System.out.println("\t"+dvd2.getNome()+" "+dvd2.calPreco());

        

    }
}