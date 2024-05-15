package com.sunbeam;

public class List {
	static class Node{
		private int data;
		private Node next;
		private Node prev;
		public Node(int value) {
			data = value;
			next = null;
			prev = null;
		}
	}
	
	private Node head;
	private Node tail;
	
	public List() {
		head = null;
		tail = null;
	}
	
	public boolean isEmpty() {
		return head == null && tail == null;
	}
	
	public void addFirst(int value) {
		//1. create newnode
		Node newnode = new Node(value);
		//2. if list is empty
		if(isEmpty())
			// add newnode into head and tail
			head = tail = newnode;
		//3. if list is not empty
		else {
			//a. add first node into next of newnode
			newnode.next = head;
			//b. add newnode into prev of first node
			head.prev = newnode;
			//c. move head on newnode
			head = newnode;
		}
	}
	
	public void addLast(int value) {
		//1. create newnode
		Node newnode = new  Node(value);
		//2. if list is empty
		if(isEmpty())
			// add newnode into head and tail
			head = tail = newnode;
		//3. if list is not empty
		else {
			//a. add last node into prev of newnode
			newnode.prev = tail;
			//b. add newnode into next of last node
			tail.next = newnode;
			//c. move tail on newnode
			tail = newnode;
		}
	}
	
	public void addPosition(int value, int pos) {
		//1. create newnode
		Node newnode = new Node(value);
		//2. if list is empty
		if(isEmpty())
			// add newnode into head and tail
			head = tail = newnode;
		else if(pos <= 1)
			addFirst(value);
		//3. if list is not empty
		else {
			//a. traverse till pos -1 node
			Node trav = head;
			for(int i = 1 ; i < pos - 1 && trav.next != null ; i++)
				trav = trav.next;
			
			if(trav == tail) {
				addLast(value);
				return;
			}
			//b. add pos node into next of newnode
			newnode.next = trav.next;
			//c. add pos -1 node into prev of newnode
			newnode.prev = trav;
			//d. add newnode into prev of pos node
			trav.next.prev = newnode;
			//e. add newnode into next of pos -1 node
			trav.next = newnode;
		}
	}
	
	public void deleteFirst() {
		//1. if list is empty
		if(isEmpty())
			return;
		//2. if list has single node
		else if(head == tail)
			head = tail = null;
		//3. if list has multiple nodes
		else {
			//a. add null into prev of second node
			head.next.prev = null;
			//c. move head on second node
			head = head.next;
		}
	}
	
	public void deleteLast() {
		//1. if list is empty
		if(isEmpty())
			return;
		//2. if list has single node
		else if(head == tail)
			head = tail = null;
		//3. if list has multiple nodes
		else {
			//a. add null into next of second last node
			tail.prev.next = null;
			//c. move tail on second last node
			tail = tail.prev;
		}
	}
	
	public void deletePosition(int pos) {
		//1. if list is empty
		if(isEmpty())
			return;
		//2. if list has single node
		else if(head == tail)
			head = tail = null;
		//3. if list has multiple nodes
		else {
			//a. traverse till pos node
			Node trav = head;
			for(int i = 1 ; i < pos ; i++)
				trav = trav.next;
			//b. add pos +1 node into next of pos -1 node
			trav.prev.next = trav.next;
			//c. add pos -1 node into prev of pos+1 node
			trav.next.prev = trav.prev;
		}
	}
	
	public void forwardDisplay() {
		// forward list
		//1. create a trav pointer and start at head
		Node trav = head;
		System.out.print("forward list ::");
		while(trav != null) {
			//2. print current node
			System.out.print(" " + trav.data);
			//3. go on next node
			trav = trav.next;
		}//4. repeat step 2 and 3 till last node
		System.out.println("");
	}
	
	public void backwardDisplay() {
		// forward list
		//1. create a trav pointer and start at tail
		Node trav = tail;
		System.out.print("backward list ::");
		while(trav != null) {
			//2. print current node
			System.out.print(" " + trav.data);
			//3. go on prev node
			trav = trav.prev;
		}//4. repeat step 2 and 3 till first node
		System.out.println("");
	}
	
	public void deleteAll() {
		head = tail = null;
	}
}










