public class BookList {
    public class Node {
        private Node prev;
        private Node next;
        private Book data;

        public Node(Book book) {
            this.data = book;
        }
    }

    private Node head;
    private int count;

    public BookList() {
        head = null;
        this.count = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Book book) {
        Node newBook = new Node(book);
        if (isEmpty()) {
            head = newBook;
            head.next = newBook;
            head.prev = newBook;
        } else {
            newBook.next = head;
            newBook.prev = head.prev;
            head.prev.next = newBook;
            head.prev = newBook;
            head = newBook;
        }
        count++;
        System.out.println("New book added Successfully...");
    }

    public void addLast(Book book) {
        Node newBook = new Node(book);
        if (isEmpty()) {
            head = newBook;
            newBook.next = newBook.prev = newBook;
        } else {
            newBook.next = head;
            newBook.prev = head.prev;
            head.prev.next = newBook;
            head.prev = newBook;
        }
        count++;
        System.out.println("New book added at last successfully...");

    }

    public void addPosition(Book book, int pos) {
        if (pos < 1) return;
        Node newBook = new Node(book);

        if (head == null) {
            head = newBook;
            newBook.next = newBook.prev = newBook;
        } else if (pos == 1) {
            addFirst(book);
        } else {
            Node trav = head;
            for (int i = 1; i < pos - 1; i++) {
                trav = trav.next;
                if (trav == head && pos != 2) return;
            }
            newBook.next = trav.next;
            newBook.prev = trav;
            trav.next.prev = newBook;
            trav.next = newBook;
        }  count++;
        System.out.println("New book added at given position Successfully...");
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
/*System.out.println(" Book "+ counter + (trav.book).toString());
				counter++; */
        Node trav = head;
        System.out.println("Forward Book List:");
        do {
            System.out.println("[ book id " + trav.data.getId() + ", book name " + trav.data.getName() + ", book price " + trav.data.getPrice() + " ]");
            trav = trav.next;
        } while (trav != head);
        System.out.println("");
    }

    public boolean deleteFirst() {
        if (head == null) return false;
        if (head == head.next) {
            head = null;
        } else {
            head.prev.next = head.next;
            head.next.prev = head.prev;
            head = head.next;
        }count--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        if (head == head.next) {
            head = null;
        } else {
            head.prev.prev.next = head;
            head.prev = head.prev.prev;
        }
        count--;
        return true;
    }

    public boolean deletePosition(int pos) {
        if (head == null || pos < 1) return false;
        if (head == head.next) {
            head = null;
        } else if (pos == 1) {
            deleteFirst();
        } else {
            Node trav = head;
            for (int i = 1; i < pos; i++) {
                trav = trav.next;
                if (trav == head) return false;
            } count--;
            trav.prev.next = trav.next;
            trav.next.prev = trav.prev;
        }
       
        return true;
    }

    public boolean deleteBookById(int id) {
        if (isEmpty()) {
            return false;
        }

        Node trav = head;
        do {
            if (trav.data.getId() == id) {
                if (trav.next == trav) {
                    head = null;
                } else {
                    count--;
                    trav.prev.next = trav.next;
                    trav.next.prev = trav.prev;
                    if (trav == head) {
                        head = trav.next;
                    }
                }
                return true;
            }
            trav = trav.next;
        } while (trav != head);

        return false;
    }

    public void displayBack() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }

        Node trav = head.prev;
        System.out.println("Reverse Book List:");
        do {
            System.out.println("[ book id " + trav.data.getId() + ", book name " + trav.data.getName() + ", book price " + trav.data.getPrice() + " ]");
            trav = trav.prev;
        } while (trav != head.prev);
        System.out.println("");
    }

    public boolean searchBook(String name) {
        if (isEmpty()) {
            return false;
        }

        Node trav = head;
        do {
            if (trav.data.getName().equals(name)) {
                System.out.println("[ book id " + trav.data.getId() + ", book name " + trav.data.getName() + ", book price " + trav.data.getPrice() + " ]");
                return true;
            }
            trav = trav.next;
        } while (trav != head);

        return false;
    }

    public boolean updateBookPrice(int id, double price) {
        if (isEmpty()) {
            return false;
        }

        Node trav = head;
        do {
            if (trav.data.getId() == id) {
                trav.data.setPrice(price);
                return true;
            }
            trav = trav.next;
        } while (trav != head);

        return false;
    }
    public void sortBooksByPrice() {
        if (isEmpty()) return;
        Node start = head;
        do {
            Node min = start;
            Node current = start.next;
            do {
                if (current.data.getPrice() < min.data.getPrice()) {
                    min = current;
                }
                current = current.next;
            } while (current != head);

            if (min != start) {
                Book temp = start.data;
                start.data = min.data;
                min.data = temp;
            }
            start = start.next;
        } while (start.next != head);
    }
    public Book findBookWithMaxPrice() {
        if (isEmpty()) return null;
    
        double maxPrice = Double.MIN_VALUE;
        Book maxPriceBook = null;
    
        Node trav = head;
        do {
            if (trav.data.getPrice() > maxPrice) {
                maxPrice = trav.data.getPrice();
                maxPriceBook = trav.data;
            }
            trav = trav.next;
        } while (trav != head);
    
        return maxPriceBook;
    }
    public void generateHashTable()
	{
		if(isEmpty())
		{
			System.out.println(" List is Empty");
			return;
		}
		else
		{
			Node trav = head;
			HashTable hashtable = new HashTable(count);
			do
			{
				hashtable.add(trav.data.getName());
				trav = trav.next;
			}while(trav!=head);
			hashtable.print();
		}
	}
	
}

