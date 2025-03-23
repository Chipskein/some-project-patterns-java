package exporter;

public class XMLExporter  extends Exporter{

    public XMLExporter(String filepath, char sep) {
        super(filepath, sep);
    }
    
        @Override
    public String generateContent() {
        String[] columns=this.headers;
        String result="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        result += "<table>";
        result += "<columns>";
        for(int i=0;i<columns.length;i++){
            result += "<coluna nome='"+columns[i]+"'/>";
        }
        result += "</columns>";
        result += "<lines>";
        for(var line: this.lines){
            result+="<line>";
            for(var data : line){
                result += "<cell>";
                result += data;
                result += "</cell>";
            }
            result+="</line>";
        }
        result += "</lines>";
        result += "</table>";
        return result;
    }
    
}
