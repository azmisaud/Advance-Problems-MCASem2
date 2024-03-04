
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q12 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<String> str=new ArrayList<>();
        System.out.println("Enter the elements in the string list or enter 'end' to break : ");
        while(true){
            String input=scanner.nextLine();
            if(input.equalsIgnoreCase("end")) break;
            str.add(input);
        }
        System.out.println();
        System.out.println("You have entered " +str.size() + " elements.");
        System.out.println(str);
        List<Integer> nonNumericIndex=new ArrayList<>();
        List<Integer> integer=new ArrayList<>();
        for(String s : str){
            try{
                int m=Integer.parseInt(s);
                integer.add(m);
            } catch (NumberFormatException e){
                nonNumericIndex.add(str.indexOf(s));
            }
        }
        System.out.println();
        System.out.println("Non-numeric values in the string are : ");
        for(int i : nonNumericIndex){
            System.out.print("'"+str.get(i)+ "'  ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Integer values in the string list : ");
        System.out.println(integer);
        System.out.println("There are " +integer.size()+ " integers in the string list.");
    }
}
