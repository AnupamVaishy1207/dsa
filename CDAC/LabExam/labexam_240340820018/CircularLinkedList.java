package labexam_240340820018;


public class CircularLinkedList {
    private Node head = null;
    private Node tail = null;
    public class Node {
        String data;
        Node next;
    
        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addLast(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public void deleteAt(int index) {
        if (head == null) return;

        Node temp = head;
        if (index == 0) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            return;
        }

        for (int i = 0; temp != tail && i < index - 1; i++) {
            temp = temp.next;
        }

        if (temp.next == tail) {
            tail = temp;
        }

        temp.next = temp.next.next;
    }

    public void display() {
        if (head == null) return;

        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public String get(int index) {
        if (head == null) return null;

        Node temp = head;
        for (int i = 0; temp != tail && i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public int size() {
        if (head == null) return 0;

        int count = 0;
        Node temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }
}
