import java.util.Scanner;

public class Student {
    private String name;
    private String regNum;
    private Book[] borrowedBooks;
    private int booksCount;

    private Scanner input = new Scanner(System.in);

    public Student() {
        System.out.println("Enter Student Name:");
        this.name = input.nextLine();

        System.out.println("Enter Registration Number:");
        this.regNum = input.nextLine();

        borrowedBooks = new Book[3];
        booksCount = 0;
    }

    public String getName() {
        return name;
    }

    public String getRegNum() {
        return regNum;
    }

    public void borrowBook(Book book) {
        if (booksCount < 3) {
            borrowedBooks[booksCount] = book;
            booksCount++;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("You have already borrowed the maximum number of books.");
        }
    }

    public void returnBook(Book book) {
        boolean found = false;
        for (int i = 0; i < booksCount; i++) {
            if (borrowedBooks[i] == book) {
                borrowedBooks[i] = null;
                found = true;
                booksCount--;
                break;
            }
        }
        if (found) {
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("You haven't borrowed this book.");
        }
    }

    public Book[] getBorrowedBooks() {
        Book[] borrowed = new Book[booksCount];
        for (int i = 0; i < booksCount; i++) {
            borrowed[i] = borrowedBooks[i];
        }
        return borrowed;
    }

    public static void main(String[] args) {
        Student student = new Student();

        System.out.println("Student Name: " + student.getName());
        System.out.println("Registration Number: " + student.getRegNum());

        student.input.close();
    }
}
