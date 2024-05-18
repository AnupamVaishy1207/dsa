package labexam_240340820018;
import java.util.Scanner;

public class QueueMain {
    public static void main(String args[]){
        Queue q=new Queue(5);
        try (Scanner sc = new Scanner(System.in)) {
            int choice;
      
            do{
                System.out.println("0. exit");
                System.out.println("1. isfull");
                System.out.println("2. isEmpty");
                System.out.println("3. Push ");
                System.out.println("4. Pop ");
                System.out.println("5. Peek");
                System.out.println("Enter your choice");
                choice=sc.nextInt();
                switch(choice) {
                    case 1: 
                    boolean full=q.isFull();
                    if(full==true){
                     System.out.println("Queue is Full");
                    }else{
                        System.out.println("Queue is Not Full");
                    }
                    break;
                    case 2:
                   
                    boolean empty=q.isEmpty();
                    if(empty==true){
                     System.out.println("Queue is Empty");
                    }else{
                        System.out.println("Queue is Not Empty");
                    }
                    break;
                    case 3:
                        if(q.isFull())
                            System.out.println("Queue is full");
                        else {
                            System.out.print("Enter Name : ");
                            String name = sc.nextLine();
                            sc.next();
                            q.push(name);
                        }
                        break;
                    case 4:
                        if(q.isEmpty())
                            System.out.println("Queue is empty");
                        else
                            q.pop();
                        break;
                    case 5:
                        if(q.isEmpty())
                            System.out.println("Queue is empty");
                        else
                            System.out.println("Peeked value : " + q.peek());
                        break;
                        default:
                        break;
                    }      
                
                   
                
            }while(choice!=0);
        }
    }
    
}