package CDAC.SearchingTechnique.LinearSearch;

public class LinearSearch {
    public static int linearSearch(int arr[],int size,int key){
        //1.decide key to be search - key
        //2. start traversing from one end of collection
        for (int i=0;i<size;i++){
            //3.compare key with each element of collection.
            if(key==arr[i]){
                //4.if key found then stop search and return   current index
                return i;
            }
           //5. if key is not found compare with next element of collection till last element
           
        }
        return -1;
    }
    public static void main(String args[]){
        int arr[]={88,77,66,44,55,99,22,11,33};
        int size = arr.length;
        int key = 22;
        int index=linearSearch(arr, size, key);
        if(index!=-1){
            System.out.println("Element found in arr at index number "+index);
        }else{
            System.out.println("Element not found in given array");
        }

    }
    
}
