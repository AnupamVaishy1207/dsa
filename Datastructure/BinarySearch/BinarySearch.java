package Datastructure.BinarySearch;

public class BinarySearch {
    public int binarySearch(int[] nums,int s,int e,int key){
            
        int start=s;
        int end=e;
        int mid=start+(end-start)/2;
        while(start<=end){
            if(nums[mid]==key){
                return mid;
            }
            if(key>nums[mid]){
                start=mid+1;
            }else{
                end=mid-1;
            }
           mid= start+(end-start)/2;
        }
        return -1;
    }

    
    public static void main(String[] args) {
        // Create an instance of the BinarySearch class
        BinarySearch binarySearch = new BinarySearch();

        // Define an array
        int[] nums = {1, 3, 5, 7, 9, 11, 13};
        
        // Define the target value
        int target = 7;

        // Call the binarySearch method and print the result
        int result = binarySearch.binarySearch(nums, 0, nums.length - 1, target);
        if (result != -1) {
            System.out.println("Target " + target + " found at index: " + result);
        } else {
            System.out.println("Target " + target + " not found in the array.");
        }
    }
}


