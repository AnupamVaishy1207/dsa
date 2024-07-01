import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindOccurrenceOfAnElement {
    public static int[] sort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

        }
        return arr;
    }
    public static void findOccurrenceOfAnElement(int arr[], int size) {
        int[] sortArr = FindOccurrenceOfAnElement.sort(arr);
        int count = 1;
        int frequencyCount[] = new int[size];
        int j = 0;
        for (int i = 0; i < size - 1; i++) {
            if (sortArr[i] == sortArr[i + 1]) {

                count++;
            } else {
                frequencyCount[j++] = count;
                
                count = 1;

            }
        }
        frequencyCount[j++] = count;
        System.out.print("sorted Array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(sortArr[i] + " ");
        }
        System.out.print("Frequency of elements in sorted order: ");
        
        for (int i = 0; i < size; i++) {
            System.out.print(frequencyCount[i] + " ");
        }

    }
    //==========================[-----------Using HashTable-----------------]==========================
    public static void findUsingHashTable(int arr[],int size){
        Map<Integer,Integer> hashmap=new HashMap<>();
       
       for(int i=0;i<arr.length;i++){
        //if Key already containing value
        if(hashmap.containsKey(arr[i])){
            //hashmap.get(arr[i]) give already present count then we have to increment it 
            hashmap.put(arr[i], hashmap.get(arr[i])+1);
        }else{
             //if Key Not containing value
             hashmap.put(arr[i], 1);
        }
       } System.out.println("Key    |  Value10"  );
       for(Map.Entry entry:hashmap.entrySet()){
        System.out.println(entry.getKey()+ " -----------> "+entry.getValue() );
       }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an Array ");
        int size = sc.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter the element in an Array");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        //findOccurrenceOfAnElement(arr, size);
        findUsingHashTable(arr, size);
    }
}
