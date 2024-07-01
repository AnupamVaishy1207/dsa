import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class DuplicateRemove {
    public static void duplicateRemoveFromAnArray(int arr[],int size){
        //for sorted array
        int uniqueArray[]=new int[size];
        int j=0;
for(int i=0;i<size-1;i++){
    if( arr[i]!=arr[i+1]  ){
   uniqueArray[j++]=arr[i];
    }
   

} uniqueArray[j++]=arr[size-1];
for(int i=0;i<size;i++)
{
 System.out.println(" "+uniqueArray[i]) ;
}
    }
//==============================================================================
            //For Unsorted array
    public static void duplicateUsingHashset(int arr[],int size){
        Set<Integer> unique=new HashSet<>();
        for(Integer element:arr){
            unique.add(element);
        }
        System.out.print("Unique element in an Array : ");
        for(Integer element:unique){
           System.out.print(element+" ");
        }
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
duplicateRemoveFromAnArray(arr, size);
duplicateUsingHashset(arr, size);
}
    
}
