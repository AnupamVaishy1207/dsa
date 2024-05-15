package com.sunbeam;

public class SingleCircularLinkedListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List l1 = new List();
		
		l1.addFirst('n');
		l1.addFirst('u');
		l1.addFirst('s');
		l1.addLast('b');
		l1.addLast('e');
		l1.addLast('a');
		l1.addLast('m');
		
		l1.deleteFirst();
		l1.deleteLast();
		
		l1.display();

	}

}
