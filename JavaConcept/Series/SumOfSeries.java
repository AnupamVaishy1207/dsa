package JavaConcept.Series;
import java.util.*;

public class SumOfSeries {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int sum=0;

        for(int i=1,a=0;i<=n;i++){
            sum +=i;
            System.out.println(a+" + "+i+" = "+sum);
           
            a=sum;

        }
    }
    
}
