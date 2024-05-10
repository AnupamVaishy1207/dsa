package Datastructure.BinarySearch;

public class FindPivot {
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
    public static void main(String[] args) {
        // Create an instance of the FindPivot class
        FindPivot findPivot = new FindPivot();

        // Define an array
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        
        // Define the length of the array
        int length = nums.length;

        // Call the getPivot method and print the result
        int pivotIndex = findPivot.getPivot(nums, length);
        System.out.println("Pivot index: " + pivotIndex);
        System.out.println("Pivot element: " + nums[pivotIndex]);
    }
    
}
