package CDAC.Assignments.Assignment1;
//find the first non-repeating element: Input: { 1, 2, 3, -1, 2, 1, 0, 4, -1, 7, 8 } Ouput: 3
public class NonReaptingElement {
    public static int firstNonRepeatingElement(int arr[],int size){

        for(int i=0;i<size-1;i++) {
         int counter=0;
         for(int j=i+1;j<size;j++){
             if(arr[i]==arr[j]){
             counter++;
             }
         }
         if(counter==0){
             return i;
         }
        }
        return -1;
    }

    public static void main(String args[]){
        int arr[]={1, 2, 3, -1, 2, 1, 0, 4, -1, 7, 8};
        int size=arr.length;
        int index=firstNonRepeatingElement(arr, size);
        if(index!=-1){
            System.out.println("Non Reapting element found at index "+index);
        }else{
            System.out.println("There is no non reapting element in an array");
        }
        
    }
}
