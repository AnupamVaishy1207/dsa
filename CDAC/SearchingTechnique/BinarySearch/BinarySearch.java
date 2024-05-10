package CDAC.SearchingTechnique.BinarySearch;

public class BinarySearch{
    public static int binarySearch(int arr[],int size,int key){
  //1. decide key to be search also decide left and rigth side of the array
  int left=0,right=size-1,mid;
  //2.find middle element of the array.
  mid=(left+right)/2;
// make a termination condition when should your lopp break
  while(left<=right){
      //3.compare middle element with key
      if(key==arr[mid])
        //3.1 if key is matching return the index of it .
        return mid;
        //3.2 if key is less than mid element, then search it inside left partition.
         else if(key<arr[mid])
         right=mid-1;
         //3.3 if key is greater than middle element , then search it inside right partition.
          else
          left=mid+1;
         //4 return -1 if key not found.
  }
  
  return -1;
    }

    public static void main(String args[]){
        int arr[]={11,22,33,44,55,66,77,88,99};
        int size=arr.length;
        int key=55;
        int index =binarySearch(arr, size, key);
        if(index!=-1){
            System.out.println("Element found at index number "+index);
        }else{
            System.out.println("Element not found");
        }
    }
  
    
}
