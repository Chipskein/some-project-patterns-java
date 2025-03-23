package exporter;

public class HtmlExporter extends Exporter {

    public HtmlExporter(String filepath, char sep) {
        super(filepath, sep);
    }

    @Override
    public String generateContent() {
        String[] columns=this.headers;
        String result="<html>";
        result+="<div align='center'>";
        result += "<table>";
        result += "<tr>";
        for(int i=0;i<columns.length;i++){
            result += "<td>";
            result += columns[i];
            result += "</td>";
        }
        result += "</tr>";
        for(var line: this.lines){
            result += "<tr>";
                for(var data : line){
                    result += "<td>";
                    result += data;
                    result += "</td>";
                }
            result += "</tr>";
        }
        result += "</table>";
        result+="</div>";
        return result+="</html>";
    }
}
