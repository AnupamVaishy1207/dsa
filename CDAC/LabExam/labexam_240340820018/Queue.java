package labexam_240340820018;
class Queue {
    private String arr[];
    private int front, rear;
    private final int SIZE;

    public Queue(int size) {
        SIZE = size;
        arr = new String[SIZE];
        front = rear = -1;
    }

    public void push(String name) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % SIZE;
        arr[rear] = name;
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        String temp = arr[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % SIZE;
        }
        return temp;
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return arr[front];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % SIZE == front;
    }
}
