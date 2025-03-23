package exporter;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public abstract class Exporter {
    
    protected List<List<String>> lines;
    
    protected String[] headers;
    
    protected char sep;

    public Exporter(String filepath,char sep){
        this.loadCSV(filepath,sep);
    }

    private final void loadCSV(String filepath,char sep){
        try{
            this.sep=sep;
            this.lines=new ArrayList<>();
            if(filepath.isEmpty()) throw new Error("filepath is empty");
            File input = new File(filepath);
            if(!input.exists()) throw new Error("File does not exists");
            if(!input.isFile()) throw new Error("filepath is not a File");
            BufferedReader buffer=new BufferedReader(new FileReader(filepath));
            String line="";
            boolean firstLine=true;
            while(line!=null){
                line=buffer.readLine();
                if(line!=null){
                    if(firstLine){
                        this.headers=line.split(""+sep);
                        firstLine=false;
                    } else{
                        String[] values=line.split(""+sep);
                        List<String> lineValues=new ArrayList<>();
                        for(String value:values){
                            lineValues.add(value);
                        }
                        this.lines.add(lineValues);
                    }
                }
            }
            buffer.close();
            if(lines.size()==0) throw new Error("Lines array is empty");
        } catch (Exception e){
            System.out.println("Invalid filepath : "+filepath);
            System.out.println("Error : " + e.getMessage());
            System.exit(1);
        }
    }

    public abstract String generateContent();
    
    public final void Save(String content,String outFilePath){
        try{
            if(outFilePath.isEmpty()) throw new Error("outFilePath is empty");
            File output = new File(outFilePath);
            if(output.exists()) System.out.println("Warning : File already exists, it will be overwritten");
            java.io.FileWriter writer = new java.io.FileWriter(outFilePath);
            writer.write(content);
            writer.close();
        } catch (Exception e){
            System.out.println("Invalid outFilePath : "+outFilePath);
            System.out.println("Error : " + e.getMessage());
            System.exit(1);
        }
    };

    final public void export(String outFilePath){
        String content=this.generateContent();
        this.Save(content,outFilePath);
    }
}
