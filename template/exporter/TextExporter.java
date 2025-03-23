package exporter;

public class TextExporter extends Exporter {

    public TextExporter(String filepath, char sep) {
        super(filepath, sep);
    }

    @Override
    public String generateContent() {
        String result="";
        for(var header : headers){
            result += header+" ";
        }
        result += "\n";
        for(var line :lines){
                for(var data : line){
                    result += data+" ";
                }
            result += "\n";
        }
        return result;
    }
}
