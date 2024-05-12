package CDAC.Assignments.Assignment3;

import java.util.Scanner;

/*
1. Write a program to implement descending stack. (Initialize top = SIZE)
 */
class Stack{
    private int arr[];
    private int top;
    private final int size;
    public Stack(int size){
        this.size=size;
        arr=new int[size];
        top=size;
    }
    public void push(int value){
        //1.Reposition top
        top--;
        //add a value at top index
        arr[top]=value; 
    }
    public int pop(){
        //reposition top and return it
        return arr[top--];

    }
    public int peek(){
        //read to value at top
        return arr[top];
    }
    public boolean isEmpty(){
        return top==size;
    }
    public boolean isFull(){
        return top==-1;
    }
}
public class DecendingStack {
       public static void main(String args[]){

        Stack stack =new Stack(5);
        int choice;
        Scanner sc=new Scanner(System.in);
        do {
        
                    System.out.println("0. Exit\n1. Push\n2. Pop\n3. Peek");
                    System.out.print("Enter choice : ");
                    choice = sc.nextInt();
                    
                    switch(choice) {
                    case 1:
                        if(stack.isFull())
                            System.out.println("Stack is full");
                        else {
                            System.out.print("Enter value : ");
                            int value = sc.nextInt();
                            stack.push(value);
                        }
                        break;
                    case 2:
                        if(stack.isEmpty())
                            System.out.println("Stack is empty");
                        else
                            System.out.println("Poped value : " + stack.pop()); 
                        break;
                    case 3:
                        if(stack.isEmpty())
                            System.out.println("Stack is empty");
                        else
                            System.out.println("Peeked value : " + stack.peek());
                        break;
                    }
            
        } while (choice!=0);
        sc.close();
    }
}
