package com.sunbeam;

public class DoublyLinearLinkedListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List l1 = new List();
		
		l1.addFirst(20);
		l1.addFirst(10);
		l1.addLast(30);
		l1.addLast(40);
		
		//l1.addPosition(100, 10);
		//l1.deleteFirst();
		//l1.deleteLast();
		l1.deletePosition(3);
		
		l1.forwardDisplay();
		l1.backwardDisplay();
	}

}



