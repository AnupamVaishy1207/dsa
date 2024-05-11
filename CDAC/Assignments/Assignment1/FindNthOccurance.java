package CDAC.Assignments.Assignment1;
/* Implement linear search algorithm to find the nth occurence of the given element. If nth occurrence is
not found, return -1 */
public class FindNthOccurance {
    public static int findNthOccurance(int arr[],int size,int key,int nthoccurance){
        int count=0;
        for(int i=0;i<size-1;i++){
            if(key==arr[i]){
                count++;
                if(count==nthoccurance){
                    return i;
                }
               
            }
        }
        return -1;

    }
    public static void main(String args[]){
        int arr[]={11,55,44,33,22,88,77,99,44,55,33,55,33,44,77,11,22,44,22,44,77,88,11,44,44};
        int key=44;
        int nthoccurance=3;
        int index=findNthOccurance(arr, arr.length, key, nthoccurance);
        if(index!=-1){
            System.out.println("Element found at index number "+index);
        } else{
                System.out.println("Element not found");
            }
       
    }
    
}
