//linear search

public int linearSearch(int key){
for (int i=0;i<arr.length;i++){
if(arr[i]===key){
return i;
}
}

return 0;
}
