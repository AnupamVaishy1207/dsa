linear search
public int linearSearch(int key){
for (int i=0;i<arr.length;i++)
{
   if(arr[i]===key)
    return i;
}
return 0;
}
Select sort
public void selectionSort(int arr){
for (int i=0;i<arrr.length-1;i++)
{
for(int j=i+1;j<arr.length;j++){
if(arr[i]>arr[j]){
int temp=arr[i];
arr[i]=arr[j];
arr[j]=temp;
}
}
}
