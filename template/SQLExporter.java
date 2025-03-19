public class SQLExporter extends Exporter {
    
    private String tableName;
    
    public SQLExporter(String filepath, char sep, String table) {
        super(filepath, sep);
        this.tableName=table;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public String generateContent() {
        String result="";
        String[] columns=this.headers;
        result+="DROP TABLE "+tableName+";\n";
        result+="CREATE TABLE "+tableName+" (\n";
        for(int i=0;i<columns.length;i++){
            result+=columns[i]+" VARCHAR(255)";
            if(i<columns.length-1){
                result+=",";
            }
            result+="\n";
        }
        result+=");\n";
        for(var line : lines){
            result+="INSERT INTO "+tableName+" VALUES (";
            for(int j=0;j<line.size();j++){
                result+="'"+line.get(j)+"'";
                if(j<line.size()-1) result+=",";
            }
            result+=");\n";
        }
        return result;
    }
}
