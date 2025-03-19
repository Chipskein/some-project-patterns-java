public class TextExporter extends Exporter {

    public TextExporter(String filepath){
        super(filepath);
    }

    @Override
    public String generateContent() {
        String result="";
        for(var line :lines){
                String[] data=line.split(String.valueOf(sep));
                for(int j=0;j<data.length;j++){
                    result += data[j]+" ";
                }
            result += "\n";
        }
        return result;
    }
}
