package com.command.apresentacao;

import com.command.negocio.Clipboard;
import com.command.negocio.Documento;
import com.command.negocio.comandos.Comando;
import com.command.negocio.comandos.CopiarComando;
import com.command.negocio.comandos.ColarComando;
import com.command.negocio.ItemMenu;
public class Main {
    public static void main(String[] args) {
        
        Clipboard clipboard = new Clipboard();
        
        Documento documento = new Documento("documento.txt", "/caminho/do/documento", "txt", "1MB", "01/01/2023",clipboard);
        documento.escrever("1.Texto de exemplo para copiar\n");
        documento.escrever("2.Texto de exemplo para copiar\n");
        documento.escrever("3.Texto de exemplo para copiar\n");

        Documento documento2 = new Documento("documento2.txt", "/caminho/do/documento2", "txt", "2MB", "01/01/2023",clipboard);
        documento2.escrever("Documento Vazio\n");
        
        Comando copiarComando = new CopiarComando(documento,0,10);

        Comando colarComando = new ColarComando(documento2,16);
        
        System.out.println("Texto do documento 1: ");
        System.out.println(documento.getTexto());
        System.out.println("Texto do documento 2: ");
        System.out.println(documento2.getTexto());

        ItemMenu itemMenu = new ItemMenu("Copiar", "Chamar comando de copiar");
        itemMenu.setComando(copiarComando);
        itemMenu.click();

        ItemMenu itemMenu2 = new ItemMenu("Colar", "Chamar comando de colar");
        itemMenu2.setComando(colarComando);
        itemMenu2.click();

        System.out.println("Texto do documento 1: ");
        System.out.println(documento.getTexto());
        System.out.println("Texto do documento 2: ");
        System.out.println(documento2.getTexto());
    }
}