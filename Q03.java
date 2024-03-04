
public class Q03 {
    public static void main(String[] args) {
        String str=null;
        //Handling null pointer exception using try-catch.
        try{
            System.out.println("String length : " +str.length());
        } catch (NullPointerException e){
            System.err.println(e.getMessage());
        }
        //Handling Null Pointer Exception using Default Exception Handler.
        try{
            System.out.println("String length : " +str.length());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        //Preventing unchecked exception
        if(str!=null) System.out.println("String length : " +str.length());
        else System.out.println("String is null, can't find it's length.");
    }
}
