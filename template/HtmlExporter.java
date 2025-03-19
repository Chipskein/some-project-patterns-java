public class HtmlExporter extends Exporter {

    public HtmlExporter(String filepath){
        super(filepath);
    }

    @Override
    public String generateContent() {
        String[] columns=this.lines.get(0).split(String.valueOf(sep));
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
        for(int i=1;i<this.lines.size();i++){
            result += "<tr>";
                String[] data=this.lines.get(i).split(String.valueOf(sep));
                for(int j=0;j<data.length;j++){
                    result += "<td>";
                    result += data[j];
                    result += "</td>";
                }
            result += "</tr>";
        }
        result += "</table>";
        result+="</div>";
        return result+="</html>";
    }
}
