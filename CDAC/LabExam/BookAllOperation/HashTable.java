public class HashTable {
    public static class Entry{
private String key_author;
private int value_count;
public Entry(String author ,int count){
    this.key_author=author;
    this.value_count=count;
}
    }
    private int size;
    private Entry[] arr;
    public HashTable(int size){
        this.size = size;
        this.arr = new Entry[size];
    }
    public int h(String author){
        return(Math.abs(author.hashCode()))%size;
    }
    public int h(String author,int i){
        return (h(author)+ i)%size;
    }
    public void add(String author){
        int index = h(author);
        int i=1;
        if(arr[index]!=null){
            if(arr[index].key_author.equals(author)){
                arr[index].value_count=(arr[index].value_count)+1;
                return;
            }else{
                index=h(author+i++);
            } 
        }arr[index]=new Entry(author,1);
    }
    public void print(){
        for(Entry entry : arr){
            if(entry !=null){
                System.out.println(" Author Name : "+entry.key_author+"\n Book Count : "+entry.value_count);
            }
        }
    }
    
}
