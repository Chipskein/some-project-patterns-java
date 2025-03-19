import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public abstract class Exporter {
    protected List<String> lines;

    protected char sep;
    
    public Exporter(String filepath){
        this(filepath, ',');
    }

    public Exporter(String filepath,char sep){
        try{
            this.sep=sep;
            this.lines=new ArrayList<String>();
            if(filepath.isEmpty()) throw new Error("filepath is empty");
            File input = new File(filepath);
            if(!input.exists()) throw new Error("File does not exists");
            if(!input.isFile()) throw new Error("filepath is not a File");
            BufferedReader buffer=new BufferedReader(new FileReader(filepath));
            String line="";
            while(line!=null){
                line=buffer.readLine();
                if(line!=null) lines.add(line);
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

    final public String export(){
        return generateContent();
    }
}
