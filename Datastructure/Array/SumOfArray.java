import java.util.Scanner;

public class SumOfArray {
    public static void sumOfArray(int arr[],int size){
 int sum=0;
 for(int i=0;i<size;i++){
sum=arr[i]+sum;
 }
 System.out.println("sum of an array is "+sum);
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of an array");
        int size=sc.nextInt();
        int arr[]=new int[size];
        System.out.println("Enter the 5"+ size +" element in an array");
        for(int i=0;i<size;i++){

arr[i]=sc.nextInt();
        }
sumOfArray(arr, size);
    }
}