class Main {
    public static void main(String[] args) {
        //exportar sql,plain text,xml
        System.err.println("Testando exporters");
        
        System.err.println("Testando HTML");
        var htmlExporter=new HtmlExporter("/home/aluno/Documentos/bn/template/exemplo.csv");
        System.out.println(htmlExporter.export());

        System.err.println("====================================================================");
        System.err.println("Testando PlainText");
        var textExporter=new TextExporter("/home/aluno/Documentos/bn/template/exemplo.csv");
        System.out.println(textExporter.export());
        
        System.err.println("====================================================================");
        System.err.println("Testando XML");
        var xmlExporter=new XMLExporter("/home/aluno/Documentos/bn/template/exemplo.csv");
        System.out.println(xmlExporter.export());
        
    }
}