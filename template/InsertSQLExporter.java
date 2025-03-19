public class InsertSQLExporter extends Exporter {

    public InsertSQLExporter(String filepath){
        super(filepath);
    }

    @Override
    public String generateContent() {
        return "INSERT INTO TABLE() VALUES();";
    }
}
