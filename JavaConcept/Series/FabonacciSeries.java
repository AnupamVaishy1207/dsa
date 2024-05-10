package JavaConcept.Series;
import java.util.*;


public class FabonacciSeries {
 

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int FirstNumber=0;
        int SecondNumber=1;
        int sum=0;
      
          System.out.println(FirstNumber+" + "+FirstNumber+" = "+FirstNumber);
          System.out.println(FirstNumber+" + "+SecondNumber+" = "+SecondNumber);
        for(int i=1;i<=n;i++){
          sum= FirstNumber+SecondNumber;
            System.out.println(FirstNumber+" + "+SecondNumber+" = "+sum);
            FirstNumber=SecondNumber;
            SecondNumber=sum;
          

        }
    }
    
}
    

