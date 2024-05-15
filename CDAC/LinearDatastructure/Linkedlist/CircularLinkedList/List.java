package com.sunbeam;

public class List {
	static class Node{
		private char data;
		private Node next;
		public Node(char value) {
			data = value;
			next = null;
		}
	}

	private Node head;
	private int count;
	public List() {
		head = null;
		count = 0;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void addFirst(char value) {
		//1. create node with given data
		Node newnode = new Node(value);
		//2. if list is empty
		if(isEmpty()) {
			//a. add newnode into head
			head = newnode;
			//b. make list circular
			newnode.next = newnode;
		}
		//3. if list is not empty
		else {
			//a. add first node into next of newnode
			newnode.next = head;
			//b. traverse till last  node
			Node trav = head;
			while(trav.next != head)
				trav = trav.next;
			//c. add newnode into next of last node
			trav.next = newnode;
			//d. move head on newnode
			head = newnode;
		}
		count++;
	}
	
	public void addLast(char value) {
		//1. create node with given data
		Node newnode = new Node(value);
		//2. if list is empty
		if(isEmpty()) {
			//a. add newnode into head
			head = newnode;
			//b. make list circular
			newnode.next = newnode;
		}
		//3. if list is not empty
		else {
			//a. add first node into next of newnode
			newnode.next = head;
			//b. traverse till last  node
			Node trav = head;
			while(trav.next != head)
				trav = trav.next;
			//c. add newnode into next of last node
			trav.next = newnode;
		}
		count++;
	}
	
	public void addPosition(char value, int pos) {
		// valid positions : 1 to count + 1
		// invalid positions : < 1 and > count + 1
		if(pos < 1 || pos > count + 1) {
			System.out.println("Invalid position");
			return;
		}
		// count 6	, pos = 0(Invalid), pos = 7(valid), pos = 8(invalid)
		
		//To Do
	}
	
	public void deleteFirst() {
		//1. if list is empty
		if(isEmpty())
			return;
		//2. if list has single node
		else if(head == head.next)
			// make head = null
			head = null;
		//3. if list has multiple nodes
		else {
			//a. traverse till last node
			Node trav;
			for(trav = head ; trav.next != head ; trav = trav.next);
			//b. add second node into next of last node
			trav.next = head.next;
			//c. move head on second node
			head = head.next;
		}
		count--;
	}
	
	public void deleteLast() {
		//1. if list is empty
		if(isEmpty())
			return;
		//2. if list has single node
		else if(head == head.next)
			// make head = null
			head = null;
		//3. if list has multiple nodes
		else {
			//a. traverse till second last node
			Node trav = head;
			while(trav.next.next != head)
				trav = trav.next;
			//b. add head into next of second last node
			trav.next = head;
		}
		count--;
	}
	
	public void deletePosition(int pos) {
		// valid positions : 1 to count
		// invalid positions : < 1 and > count
		if(pos < 1 || pos > count) {
			System.out.println("Invalid position");
			return;
		}
		
		// To Do
	}
	
	public void display() {
		if(isEmpty())
			return;
		//1. create trav and start at head
		Node trav = head;
		System.out.print("List :: ");
		do {
			//2. print/visit current node (trav.data)
			System.out.print(" " + trav.data);
			//3. go on next node
			trav = trav.next;
		}while(trav != head);//4. repeat step 2 and 3 till last node
		System.out.println("");
		System.out.println("Node count : " + count);
	}
	
	public void deleteAll() {
		head = null;
	}
	
}











