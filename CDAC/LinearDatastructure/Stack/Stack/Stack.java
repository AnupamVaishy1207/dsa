package CDAC.LinearDatastructure.Stack.Stack;

public class Stack {
    private int arr[];
    private int top;
    private final int SIZE;
    public Stack(int size){
        SIZE=size;
        arr=new int[SIZE];
        top=-1;
    }
    public void push(int value){
        //1.Reposition top
        top++;
        //2.add value at top index
        arr[top]=value;

    }
    public int pop(){
        //1.reposition top and return value of top index
        return arr[top++];

    }

    public int peek(){
        //1.read and return value of top index
        return arr[top];
    }
    public boolean isEmpty(){
        //1.check the posititon of top 
        return top==-1;
    }
    public boolean isFull(){
        return top == SIZE -1;
    }
    
}

