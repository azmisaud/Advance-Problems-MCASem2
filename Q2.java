
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Q2 {
    public static void main(String[] args) {
        File f=new File("C:\\Users\\reala\\MyJava\\Saud2.java");
        try {
            try(BufferedReader br = new BufferedReader(new FileReader(f))){
                String line;
                ArrayList<String> m=new ArrayList<>();
                int count=0;
                boolean fileNotFound=false;
                while((line=br.readLine())!=null){
                    if(line.contains("catch")) count++;
                    if(line.contains("throw")) count++;
                    if(line.contains("throws")) count++;
                    if(line.contains("Exception")) count++;
                    if(line.contains("try")) count++;
                    if(line.contains("FileNotFoundException") || line.contains("InputStream") || line.contains("OutputStream") || line.contains("Reader") || line.contains("Write")){
                        fileNotFound=true;
                        m.add(line);
                    }
                }
                System.out.println("Exception related terms are : " +count);
                if(fileNotFound) {
                    System.out.println("Program can throw FileNotFoundException.");
                    System.out.println("The lines which can throw FileNotFoundException are : ");
                    System.out.println();
                    for(String s : m){
                        System.out.println(s);
                    }
                }
            }
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
