package CDAC.LinearDatastructure.Linkedlist.LinearLinkedList;

public class List {
    static class Node{
private int data;
private Node next;
public Node(int value){
    data = value;
    next = null;
}
    }
    private Node head;
    public List(){
        head =null;
    }
    public boolean isEmpty(){
        return head == null;
    }
    public void addFirst(int value){
		//1. create a node with given data
        Node newnode = new Node(value);
		//2. add head into next of newnode
        newnode.next=head;
		//3. add newnode into head
        head=newnode;
    }
    public void addLast(int value){
		//1. create a newnode for given data
        Node newnode=new Node(value);
		//2. if list is empty
      if(isEmpty())
		// add newnode into head itself
           head=newnode;
		//3. if list is not empty
        else{
            //a. traverse till last node
            Node trav=head;
            while(trav.next != null)
            trav=trav.next;
            //b. add newnode into next of last node    
            trav.next=newnode;   

        }
    }
    public void addPosition(int value,int pos){
		//1. create node with given data
        Node newnode=new Node(value);
		//2. if list is empty
        if(isEmpty())
			// add newnode into head itself
            head=newnode;
		// special case 1 : pos <= 1
        else if(pos<=1)
        addFirst(value);
		//3. if list is not empty
        else{
            Node trav=head;
			//a. traverse till pos - 1 node
              // special case 2 : pos > count + 1
            for(int i =1;i<pos-1 && trav.next!=null;i++){
    trav=trav.next;
            }
				
			//b. add pos node into next of newnode
            newnode.next=trav.next;

			//c. add newnode into next of pos - 1 node
            trav.next=newnode;
        }


    }
    public void deleteAll(){
        //1. if list is empty
      if(isEmpty())
      return;
      	//2. if list is not empty
        //a. set head to null
      else head =null;

    }
    public void deleteFirst(){
        //1. if list is empty
        if(isEmpty())
        return;
        //2. if list is not empty
        //a. move head on second node
        else head=head.next;
  
      }
      public void deleteLast(){
        if(isEmpty())
        return;
        else if(head.next==null)
        head=null;
        else{
            Node trav=head;
            while(trav.next.next!=null){
                trav=trav.next;
            }
         trav.next=null;
        }
      }
      public void deletePosition(int pos){
        if(isEmpty())
        return;
        else if(pos <=1){
         deleteFirst();
      }else{
     Node trav=head;
     for(int i=0;i<pos-1 && trav.next.next!=null;i++){
     trav=trav.next;
     }
     trav.next=trav.next.next;
      }
    }
    public void display(){
        Node trav = head;
        System.out.print("List :: ");
        while(trav != null){
            System.out.println(" "+trav.data);
            trav=trav.next;
        }
        System.out.println("");
    }
}
