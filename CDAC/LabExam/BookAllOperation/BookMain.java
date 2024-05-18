import java.util.Scanner;
public class BookMain {
public static void main(String[] args) {
        BookList l1 = new BookList();
        Scanner rs = new Scanner(System.in);
        int choice;
        Book book1 = new Book(1, "FairyTales", 1200.00);
        Book book2 = new Book(2, "ScienceFiction", 1500.00);
        Book book3 = new Book(3, "MysteryNovel", 1300.00);
        Book book4 = new Book(4, "Biography", 1100.00);
        Book book5 = new Book(5, "Fantasy", 1400.00);
        Book book6 = new Book(6, "History", 1600.00);
        Book book7 = new Book(7, "HorrorStory", 1700.00);
        Book book8 = new Book(8, "Adventure", 1250.00);
        Book book9 = new Book(9, "Romance", 1350.00);
        Book book10 = new Book(10, "Thriller", 1450.00);

        l1.addLast(book1);
        l1.addLast(book2);
        l1.addLast(book3);
        l1.addLast(book4);
        l1.addLast(book5);
        l1.addLast(book6);
        l1.addLast(book7);
        l1.addLast(book8);
        l1.addLast(book9);
        l1.addLast(book10);

        do {
            System.out.println("0. Exit");
            System.out.println("1. Add new book from Start");
            System.out.println("2. Add new book from Last");
            System.out.println("3. Add new book at Position");
            System.out.println("4. Display all Books");
            System.out.println("5. Display all Books in reverse");
            System.out.println("6. Delete book from First");
            System.out.println("7. Delete book from Last");
            System.out.println("8. Delete book from Position");
            System.out.println("9. Delete book by bookid");
            System.out.println("10. Search book by bookname");
            System.out.println("11. Update price of book");
            System.out.println("12. Sort price of book using selection sort");
            System.out.println("13. Find Book with Maximum Price");
            System.out.println("14. Count book of each Author ");

            System.out.print("Enter your choice: ");
            choice = rs.nextInt();

            rs.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("-------------EXIT--------------");
                    break;
                case 1: {
                    System.out.print("Enter BookId: ");
                    int id = rs.nextInt();
                    rs.nextLine();
                    System.out.print("Enter BookName: ");
                    String name = rs.nextLine();
                    System.out.print("Enter BookPrice: ");
                    double price = rs.nextDouble();
                    Book book = new Book(id, name, price);
                    l1.addFirst(book);
                }
                break;
                case 2: {
                    System.out.print("Enter BookId: ");
                    int id = rs.nextInt();
                    rs.nextLine();
                    System.out.print("Enter BookName: ");
                    String name = rs.nextLine();
                    System.out.print("Enter BookPrice: ");
                    double price = rs.nextDouble();
                    Book book = new Book(id, name, price);
                    l1.addLast(book);
                }
                break;
                case 3: {
                    System.out.print("Enter Position you want to add book: ");
                    int position = rs.nextInt();
                    rs.nextLine();
                    System.out.print("Enter BookId: ");
                    int id = rs.nextInt();
                    rs.nextLine();
                    System.out.print("Enter BookName: ");
                    String name = rs.nextLine();
                    System.out.print("Enter BookPrice: ");
                    double price = rs.nextDouble();
                    Book book = new Book(id, name, price);
                    l1.addPosition(book, position);
                }
                break;
                case 4:
                    l1.display();
                    break;
                case 5:
                    l1.displayBack();
                    break;
                case 6: {
                    boolean flag = l1.deleteFirst();
                    if (flag)
                        System.out.println("Book deleted...");
                    else
                        System.out.println("Book unavailable");
                }
                break;
                case 7: {
                    boolean flag = l1.deleteLast();
                    if (flag)
                        System.out.println("Book deleted...");
                    else
                        System.out.println("Book unavailable");
                }
                break;
                case 8: {
                    System.out.print("Enter Position to delete the book: ");
                    int position = rs.nextInt();
                    boolean flag = l1.deletePosition(position);
                    if (flag)
                        System.out.println("Book deleted...");
                    else
                        System.out.println("Book unavailable");
                }
                break;
                case 9: {
                    System.out.print("Enter bookid to delete the book: ");
                    int id = rs.nextInt();
                    boolean flag = l1.deleteBookById(id);
                    if (flag)
                        System.out.println("Book deleted...");
                    else
                        System.out.println("Book unavailable");
                }
                break;
                case 10: {
                    System.out.print("Enter book name to search: ");
                    String bookname = rs.nextLine();
                    boolean b1 = l1.searchBook(bookname);
                    if (b1 != false)
                        System.out.println("Book found");
                    else
                        System.out.println("Book unavailable...");
                }
                break;
                case 11: {
                    System.out.print("Enter book_id to update price: ");
                    int newid = rs.nextInt();
                    System.out.print("Enter new price: ");
                    double newprice = rs.nextDouble();
                    boolean isBookAvailable = l1.updateBookPrice(newid, newprice);
                    if (isBookAvailable)
                        System.out.println("Price updated successfully.");
                    else
                        System.out.println("Book unavailable...");
                }
                break;
                case 12:{
                    System.out.println("Before Sorting --->");
                    l1.display();
                    l1.sortBooksByPrice();
                    System.out.println("After Sorting by price---->");
                    l1.display();
                    break;

                }
                case 13: {
                    Book maxPriceBook = l1.findBookWithMaxPrice();
                    if (maxPriceBook != null) {
                        System.out.println("Book with maximum price:");
                        System.out.println("[ book id " + maxPriceBook.getId() + ", book name " + maxPriceBook.getName() + ", book price " + maxPriceBook.getPrice() + " ]");
                    } else {
                        System.out.println("The list is empty.");
                    }
                    break;
                }
                case 14:{
                    l1.generateHashTable();
                    break;
                }
            }
        } while (choice != 0);

        rs.close();
    }
}
