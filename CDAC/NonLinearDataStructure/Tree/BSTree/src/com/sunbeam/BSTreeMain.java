package com.sunbeam;

public class BSTreeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BSTree tree = new BSTree();
		
		tree.addNode(8);
		tree.addNode(3);
		tree.addNode(10);
		tree.addNode(6);
		tree.addNode(1);
		tree.addNode(14);
		tree.addNode(13);
		tree.addNode(7);
		tree.addNode(4);
		
		//tree.preOrder();
		//tree.inOrder();
		//tree.postOrder();
		
		/*
		BSTree.Node ret =  tree.binarySearch(15);
		if(ret == null)
			System.out.println("Key is not found");
		else
			System.out.println("Key is found");
		*/
		
		tree.inOrder();
		tree.deleteNode(8);
		tree.inOrder();
		

	}

}








