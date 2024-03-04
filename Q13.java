
import java.util.ArrayList;
import java.util.List;
class M{
}
public class Q13 {
    public static void main(String[] args) {
        List<Object> obj=new ArrayList<>();
        M obj1=new M();
        obj.add(13);
        obj.add("Saud");
        obj.add(13.02);
        obj.add(13f);
        obj.add('c');
        obj.add(14);
        obj.add(15);
        obj.add(obj1);
        List<Integer> integers=new ArrayList<>();
        for(Object o : obj){
            try{
                int m=(int) o;
                integers.add(m);
            } catch (ClassCastException e){
                System.out.println(o+ " : " +e.getMessage());
            }
        }
        System.out.println();
        System.out.println("There are " +integers.size()+ " integers : ");
        System.out.println(integers);
    }
}
