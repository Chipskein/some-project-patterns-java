import exporter.*;
class Main {
    public static void main(String[] args) {
        System.out.println("Testando exporters");
        
        System.out.println("Testando HTML");
        var htmlExporter=new HtmlExporter("exemplo.csv",';');
        htmlExporter.export("exemplo.html");
        
        System.out.println("Testando PlainText");
        var textExporter=new TextExporter("exemplo.csv",';');
        textExporter.export("exemplo.txt");
        
        System.out.println("Testando XML");
        var xmlExporter=new XMLExporter("exemplo.csv",';');
        xmlExporter.export("exemplo.xml");
        
        System.out.println("Testando SQL");
        var sqlExporter=new SQLExporter("exemplo.csv",';',"example");
        sqlExporter.export("exemplo.sql");

    }
}