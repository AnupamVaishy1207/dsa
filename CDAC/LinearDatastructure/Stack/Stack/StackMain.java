package CDAC.LinearDatastructure.Stack.Stack;
import java.util.Scanner;

public class StackMain{
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
