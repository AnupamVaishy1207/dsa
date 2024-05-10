package JavaConcept.Series;
import java.util.*;

public class FindPrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       boolean isPrime =true;
    int n=sc.nextInt();
    for(int i=2;i<n;i++){
        if(n%i==0){
            isPrime=false;
            
            break;
        }
       
    }if (isPrime==false){
        System.out.println(n+" is Not a Prime Number");
    }else {
        System.out.println(n+" is  a Prime Number");
    }
   
        
    }
    
    
}
