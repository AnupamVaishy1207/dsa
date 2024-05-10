package Datastructure.BinarySearch;

public class RotatedArray {

   

        public int getPivot(int[] nums,int length) {
            int size=length;
            int s = 0;
            int e = nums.length - 1;
            int mid = s + (e - s) / 2;
            while (s < e) {
                if (nums[mid] >= nums[0]) {
                    s = mid + 1;
                } else {
                    e = mid;
                }
                mid = s + (e - s) / 2;
            } return s;
    
        }
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
    
        public int search(int[] nums, int target) {
            int size=nums.length;
            int pivot=getPivot(nums,size);
            if(target>=nums[pivot] && target <= nums[size-1]){
               //BinarySearch on line first
                return binarySearch(nums,pivot,size-1,target);
            }else{
                //BinarySearch on line second
                return binarySearch(nums,0,pivot-1,target);
            }
    
        }
       
        public static void main(String[] args) {
            // Create an instance of the Solution class
            RotatedArray rotatedArray = new RotatedArray();
    
            // Define an array
            int[] nums = {4, 5, 6, 7, 0, 1, 2};
            
            // Define the target value
            int target = 0;
    
            // Call the search method and print the result
            int result = rotatedArray.search(nums, target);
            System.out.println("Index of target " + target + " is: " + result);
        }
        
    }
    

