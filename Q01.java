
import java.io.*;
import java.util.ArrayList;
import java.util.List;
class InvalidDataException extends NumberFormatException {
    public InvalidDataException(String str) {
        super(str);
    }
}
class DataProcessor{
    public DataProcessor() {};
    public List<Double> readValuesFromFile(String Path){
        List<Double> input=new ArrayList<>();
        try {
            try(BufferedReader br = new BufferedReader(new FileReader(Path))){
                String line;
                String[] str;
                int count=1;
                while((line=br.readLine())!=null) {
                    str = line.split(" ");
                    for (String s : str) {
                        try {
                            try {
                                double m = Double.parseDouble(s.trim());
                                input.add(m);
                            } catch (NumberFormatException e) {
                                throw new InvalidDataException("Non-numeric values at line : " + count);
                            }
                        } catch (InvalidDataException e){
                            System.err.println(e.getMessage());
                        }
                    }
                    count++;
                }
            }
        } catch(FileNotFoundException e){
            System.err.println("File not found.");
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
        return input;
    }
    public double calculateAverage(List<Double> values){
        double sum = 0.0;
        for (Double value : values) {
            sum += value;
        }
        return sum / (double) values.size();
    }
    public void writeResultToFile(double average, String outputPath){
        File f=new File(outputPath);
        try {
            if(f.exists() || f.createNewFile()){
                try(BufferedWriter bw=new BufferedWriter(new FileWriter(f))) {
                    String str = String.valueOf(average);
                    bw.write(str);
                    bw.flush();
                    System.out.println("Average written to the file whose path is " +f.getAbsolutePath());
                }
            }
        } catch (IOException e){
            System.err.println("Error creating the file.");
        }
    }
}
public class Q01 {
    public static void main(String[] args) {
        String inputFilePath = "Test.txt";
        String outputFilePath = "Average.txt";
        DataProcessor dp = new DataProcessor();
        List<Double> mp = dp.readValuesFromFile(inputFilePath);
        System.out.println(mp);
        dp.writeResultToFile(dp.calculateAverage(mp), outputFilePath);
    }
}
