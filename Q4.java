
public class Q4 {

    public static void main(String[] args) {
        int[][] A=new int[3][];
        A[0]=null;
        A[1]= new int[]{1, 2, 0};
        A[2]=new int[]{0,4,5,6,7};
        for(int i=0;i<3;i++){
            for(int j=0;j<5;j++){
                try{
                    int m=A[i][j] /A[i][j+1];
                    System.out.println(m);
                } catch (ArrayIndexOutOfBoundsException | NullPointerException | ArithmeticException e){
                    System.err.println(e.getMessage());
                }
            }
        }
    }
}
