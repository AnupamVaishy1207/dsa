package CDAC.Assignments.Assignment3;
/*2. Insert 5 elements in stack and find maximum value in stack without traversing it.
 */

import java.util.Scanner;

class Stack1{
    private int arr[];
    private int top;
    private final int SIZE;

    public Stack1(int size) {
        SIZE = size;
        arr = new int[size];
        top = -1;
    }

    public void push(int value) {
     
        // 1.Reposition top top = (top +1 )% size
        top++;
        // 2.add value at top index
        arr[top] = value;

    }

    public int pop() {
        // 1.reposition top and return value of top index
        return arr[top--];

    }

    public int peek() {
        System.out.println("Vakue of Top" + top);
        // 1.read and return value of top index
        return arr[top];

    }
   

    public boolean isEmpty() {
        System.out.println("Top"+top);
        System.out.println("Size"+arr.length);
        System.out.println("Louda");
        // 1.check the posititon of top
        return top == -1;
    }

    public boolean isFull() {
        
        
          
          return top == SIZE-1;
         
       
    }

}

public class FindMaxInStack {
    public static void main(String args[]) {

        Stack1 stack = new Stack1(3);
        int choice, max =Integer.MIN_VALUE;
        Scanner sc = new Scanner(System.in);
        do {

            System.out.println("0. Exit\n1. Push\n2. Pop\n3. Peek\n4 findmax ");
            System.out.print("Enter choice : ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                if (stack.isFull()) {
                    System.out.println("Stack is full");
                } else {
                    System.out.print("Enter value : ");
                    int value = sc.nextInt();
                    
                    if (value > max) {
                        max = value;
                    }
                    stack.push(value);
                }
                break;
                case 2:
                    if (stack.isEmpty())
                        System.out.println("Stack is empty");
                    else
                        System.out.println("Poped value : " + stack.pop());
                    break;
                case 3:
                    if (stack.isEmpty())
                        System.out.println("Stack is empty");
                    else
                        System.out.println("Peeked value : " + stack.peek());
                    break;
                case 4:
                    if (stack.isEmpty())
                        System.out.println("Stack is empty");
                    else
                        System.out.println("Max value : " + max);

                    break;
            
            }

        } while (choice != 0);
        sc.close();
    }
}
