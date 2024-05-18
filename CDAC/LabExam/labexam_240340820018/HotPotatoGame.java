package labexam_240340820018;
import java.util.Scanner;

public class HotPotatoGame {
    public static void main(String[] args) {
        CircularLinkedList players = new CircularLinkedList();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of players:");
        int n = sc.nextInt();
        sc.nextLine(); // Consume the newline

        for (int i = 0; i < n; i++) {
            System.out.println("Enter player " + (i + 1) + " name:");
            String name = sc.nextLine();
            players.addLast(name);
        }

        System.out.println("Enter the number of passes (M):");
        int M = sc.nextInt();

        Queue eliminationQueue = new Queue(n);

        int currentIndex = 0;

        while (players.size() > 1) {
            currentIndex = (currentIndex + M - 1) % players.size();
            String eliminatedPlayer = players.get(currentIndex);
            eliminationQueue.push(eliminatedPlayer);
            
            players.deleteAt(currentIndex);
        }

        String winner = players.get(0);
        System.out.println("The winner is: " + winner);

        // Print the elimination sequence
        System.out.println("Elimination sequence:");
        while (!eliminationQueue.isEmpty()) {
            System.out.print(eliminationQueue.pop() + " ");
        }
        System.out.println();
    }
}

