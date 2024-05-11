package CDAC.Assignments.Assignment2;

import java.util.Scanner;

//4. Write program to implement linear queue in which front and rear starts at 0.
class Queue {
	private int arr[];
	private int front, rear;
	private final int SIZE;
	public Queue(int size) {
		SIZE = size;
		arr = new int[SIZE];
		front = rear = 0;
	}
	
	public void push(int value) {
       
				arr[rear] = value;
                rear++;
		
	}
	
	public void pop() {
		//1. reposition front
		front++;
	}
	
	public int peek() {
		//1. read and return data from front end
		return arr[front ];
	}
	
	public boolean isFull() {
		return rear == SIZE;
	}
	
	public boolean isEmpty() {
		return rear == front;
	}
	

}

public class LinearQueueStartWithZero {
    public static void main(String[] args) {
		
		Queue q = new Queue(4);
		int choice;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("0. Exit\n1. Push\n2. Pop\n3. Peek");
			System.out.print("Enter choice : ");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				if(q.isFull())
					System.out.println("Queue is full");
				else {
					System.out.print("Enter value : ");
					int value = sc.nextInt();
					q.push(value);
				}
				break;
			case 2:
				if(q.isEmpty())
					System.out.println("Queue is empty");
				else
					q.pop();
				break;
			case 3:
				if(q.isEmpty())
					System.out.println("Queue is empty");
				else
					System.out.println("Peeked value : " + q.peek());
				break;
			}
		}while(choice != 0);
		sc.close();
	}
    
}
