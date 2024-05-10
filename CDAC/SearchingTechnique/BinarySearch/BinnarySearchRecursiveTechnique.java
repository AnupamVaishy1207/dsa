package CDAC.SearchingTechnique.BinarySearch;

public class BinnarySearchRecursiveTechnique {
    public static int binarySearch(int arr[],int left,int right , int key){
        int mid;
//1. stop if invalid partition
if(left>right)
return -1;
//2. find middle element of the array
mid=(left+right)/2;
//3. compare middle element with key
if(key==arr[mid])
    //3.1 if key is matching, then return index of it
    return mid;
//3.2 if key is less than middle element, then search it inside left partition
else if(key<arr[mid])
 return binarySearch(arr, left,mid-1, key);
//3.3 if key is greater tha middle element, then search it inside right partition
else
return binarySearch(arr, mid+1, right, key);

    }
	 public static void main(String args[]) {
    int arr[]={11,22,33,44,55,66,77,88,99};
    int left=0;
    int right = arr.length-1;
    int key = 66;
    int index = binarySearch(arr, left, right, key);
    if(index!=-1){
        System.out.println("Element found at index "+index);
    }else{
        System.out.println("Element not found");
    }
     } 
    
}
