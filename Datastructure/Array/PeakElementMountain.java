import java.util.Scanner;

class PeakElementMountain {
    public int peakIndexInMountainArray(Scanner sc,int[] arr) {
       int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        // At the end of the loop, low and high converge to the peak index
        return low; 
        
    }

    public static void main(String args[]){
Scanner sc =new Scanner(System.in);
System.out.println("Enter a Size of an array");
int size=sc.nextInt();
System.out.println("Enter a Element");
int arr[]=new int[size];
for(int i=0;i<arr.length;i++)
 arr[i]=sc.nextInt();
 PeakElementMountain p=new PeakElementMountain();
p.peakIndexInMountainArray(sc,arr);
    }
}
