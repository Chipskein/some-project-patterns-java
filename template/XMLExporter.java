public class XMLExporter  extends Exporter{

    public XMLExporter(String filepath) {
        super(filepath);
    }
    
        @Override
    public String generateContent() {
        String[] columns=this.lines.get(0).split(String.valueOf(sep));
        String result="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        result += "<table>";
        result += "<columns>";
        for(int i=0;i<columns.length;i++){
            result += "<coluna nome='"+columns[i]+"'/>";
        }
        result += "</columns>";
        result += "<lines>";
        for(int i=1;i<this.lines.size();i++){
            result+="<line>";
            String[] data=this.lines.get(i).split(String.valueOf(sep));
            for(int j=0;j<data.length;j++){
                result += "<cell>";
                result += data[j];
                result += "</cell>";
            }
            result+="</line>";
        }
        result += "</lines>";
        result += "</table>";
        return result;
    }
    
}
