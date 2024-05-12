package CDAC.Assignments.Assignment3;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 3. Create an array of integers. Reverse the array using stack
4. Implement circular queue using counter method
5. Implement following algorithms for multi digit numbers i. postfix evaluation ii. prefix evaluation
Optional
6. Implement following algorithms for multi digit numbers i. infix to postfix ii. infix to prefix
7. Paperwork: Convert following examples from Infix to Prefix and Postfix. K + L - M * N + (O $ P) * W / U /
V * T + Q (A + B) * C - (D - E) * (F + G)
8. Paperwork: Convert following expression to Postfix and Prefix using stack. 5+9-4*(8-6/2)+1$(7-3)
 */
 class Stack2 {
    private int arr[];
    private int top;
    private final int SIZE;
    public Stack2(int size){
        SIZE=size;
        arr=new int[SIZE];
        top=-1;
    }
    public void push(int value){
        //1.Reposition top 0-1 1-2 2-3 3-4 4-5 
        top++;
        //2.add value at top index
        arr[top]=value;

    }
    public int pop(){
        //1.reposition top and return value of top index
        return arr[top--];

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

public class ReverseArrayUsingStack {
      public static void main(String args[]) {

        Stack2 stack = new Stack2(5);
        int choice,  i=0;
        int revArr[]=new int[5];
        Scanner sc = new Scanner(System.in);
        do {

            System.out.println("0. Exit\n1. Push\n2. Pop\n3. Peek\n4 Reverse Array ");
            System.out.print("Enter choice : ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                if (stack.isFull()) {
                    System.out.println("Stack is full");
                } else {
                    System.out.print("Enter value : ");
                    int value = sc.nextInt();
                    
               
                    stack.push(value);
                }
                break;
                case 2:
                    if (stack.isEmpty())
                        System.out.println("Stack is empty");
                    else{
                                            
                        revArr[i]=stack.pop();
                        System.out.println("Poped value : " + revArr[i]);
                        i++;}
                    break;
                case 3:
                    if (stack.isEmpty())
                        System.out.println("Stack is empty");
                    else
                        System.out.println("Peeked value : " + stack.peek());
                    break;
                    case 4:
                 
                        System.out.println("Reverse Array : " +Arrays.toString(revArr));
                    break;
               
            
            }

        } while (choice != 0);
        sc.close();
    }
}
