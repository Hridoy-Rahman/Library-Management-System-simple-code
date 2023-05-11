import java.util.Scanner;

public class Book {

    private int sNo;
    private String bookName;
    private String authorName;
    private int bookQuantity;
    private int bookQuantityCopy;

    private Scanner input = new Scanner(System.in);

    public Book() {
        System.out.println("Enter Serial No of Book:");
        this.sNo = input.nextInt();
        input.nextLine();

        System.out.println("Enter Book Name:");
        this.bookName = input.nextLine();

        System.out.println("Enter Author Name:");
        this.authorName = input.nextLine();

        System.out.println("Enter Quantity of Books:");
        this.bookQuantity = input.nextInt();
        bookQuantityCopy = this.bookQuantity;

        System.out.println(" Book added successfully");
    }

    public int getSerialNo() {
        return sNo;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getbookQuantity() {
        return bookQuantity;
    }

    public int getBookQuantityCopy() {
        return bookQuantityCopy;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public void setBookQuantityCopy(int bookQuantityCopy) {
        this.bookQuantityCopy = bookQuantityCopy;
    }

    public void closeScanner() {
        input.close();
    }

    public static void main(String[] args) {
        Book book = new Book();

        System.out.println("Serial No: " + book.getSerialNo());
        System.out.println("Book Name: " + book.getBookName());
        System.out.println("Author Name: " + book.getAuthorName());
        System.out.println("Book Quantity: " + book.getbookQuantity());
        System.out.println("Book Quantity Copy: " + book.getBookQuantityCopy());

        book.closeScanner();
    }
}
