import java.util.Scanner;

public class LargestElement {
    public static void lastestElement(int arr[],int size){
        int max=Integer.MIN_VALUE;
      
        for(int i=0;i < size;i++){
            
           if(max < arr[i]){
            max=arr[i];
           }
        }
        System.out.println("Largest element in array : "+max);

    }
    public static void smallestElement(int arr[],int size){
        int min=Integer.MAX_VALUE;
      
        for(int i=0;i < size;i++){
            
           if(min > arr[i]){
            min=arr[i];
           }
        }
        System.out.println("Smallest element in array : "+min);

    }
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
System.out.println("Enter the size of an array ");
int size=sc.nextInt();
int arr[]=new int[size];
System.out.println("enter the element in an array");
for(int i=0;i<size;i++){
    arr[i]=sc.nextInt();
}
lastestElement(arr, size);
smallestElement(arr, size);

}
}
