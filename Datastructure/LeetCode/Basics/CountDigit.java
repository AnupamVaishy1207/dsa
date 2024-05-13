package Datastructure.LeetCode.Basics;
import java.lang.*;
//Question ---> https://www.geeksforgeeks.org/problems/count-digits5716/1
public class CountDigit{
    //Brute force solution
   public static int evenlyDivides(int N){
        // code hereint counter=0;
        int counter=0;
      while(N>0){
        
               counter++;
               N=N/10;
        }
        return counter;
    }
    //Optimal Solution
    public static int OptimalCount(int digit){
        int count=(int)Math.log10(digit);

        return count;
    }
    public static void main(String args[]){
        int Digit=435252;
        int digitCount=evenlyDivides(Digit);
        System.out.println("Totol number of degit present in digit is "+digitCount);
        int digitCountOptimal=evenlyDivides(Digit);
        System.out.println("Totol number of degit present in digit is "+digitCountOptimal);

    }
}