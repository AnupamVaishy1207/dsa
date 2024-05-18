package labexam_240340820018;

import java.util.Scanner;

public class ListMain {
    public static void main(String args[]){
       // List l1=new List();
       CircularLinkedList l1=new CircularLinkedList();
        try (Scanner sc = new Scanner(System.in)) {
            int choice;
            do{
                System.out.println("0. exit");
                System.out.println("1. Add Last");
                System.out.println("2. Delete Last");
                System.out.println("3. Display");
                System.out.println("Enter your choice");
                choice=sc.nextInt();
                switch (choice) {
                    case 1:
                    System.out.println("Enter name ");
                    String name=sc.nextLine();
                    sc.next();
                    l1.addLast(name);
                    System.out.println("Person add at last successfully");
                        
                        break;
                        case 2:
                    l1.deleteAt(choice);
                    System.out.println("Person Delete at last successfully");
                        
                        break;
                        case 3:
                    l1.display();
                    
                        
                        break;
                
                    default:
                        break;
                }

            }while(choice!=0);
        }

    }
   
    
}
















































/* private Node head;
        public List(){
            head=null;
        } */