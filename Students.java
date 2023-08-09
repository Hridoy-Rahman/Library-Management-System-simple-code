import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;

public class Students {
    private List<Student> students;
    private Scanner input;

    public Students() {
        students = new ArrayList<>();
        input = new Scanner(System.in);
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Registration successful");
    }

    public void showAllStudents() {
        System.out.println("\t\t\t\tSHOWING ALL STUDENTS\n");
        System.out.println("Student Name\t\tRegistration Number");

        for (Student student : students) {
            System.out.println(student.getName() + "\t\t" + student.getRegNum());
        }
    }

    public Student findStudentByRegNum(String regNum) {
        for (Student student : students) {
            if (student.getRegNum().equals(regNum)) {
                return student;
            }
        }
        return null;
    }

    public void showStudentsWithBorrowedBooks() {
        System.out.println("\t\t\t\tSTUDENTS WITH BORROWED BOOKS\n");
    
        boolean found = false;
    
        for (Student student : students) {
            Book[] borrowedBooks = student.getBorrowedBooks();
            int borrowedBookCount = 0;
    
            for (Book book : borrowedBooks) {
                if (book != null) {
                    borrowedBookCount++;
                }
            }
    
            if (borrowedBookCount > 0) {
                System.out.println("Student Name: " + student.getName());
                System.out.println("Registration Number: " + student.getRegNum());
                System.out.println("Number of Borrowed Books: " + borrowedBookCount);
                System.out.println("Borrowed Books:");
    
                for (Book book : borrowedBooks) {
                    if (book != null) {
                        System.out.println("Book Serial No: " + book.getSerialNo());
                        System.out.println("Book Name: " + book.getBookName());
                        System.out.println("Author Name: " + book.getAuthorName());
                        System.out.println("------------------------");
                    }
                }
                System.out.println("\n");
                found = true;
            }
        }
    
        if (!found) {
            System.out.println("No students have borrowed books.");
        }
    }

    public void showBorrowedBooksByStudent(String regNum) {
        Student student = findStudentByRegNum(regNum);

        if (student != null) {
            System.out.println("Student Name: " + student.getName());
            System.out.println("Registration Number: " + student.getRegNum());
            System.out.println("Borrowed Books:");

            Book[] borrowedBooks = student.getBorrowedBooks();
            if (borrowedBooks.length > 0) {
                for (Book book : borrowedBooks) {
                    if (book != null) {
                        System.out.println("Book Serial No: " + book.getSerialNo());
                        System.out.println("Book Name: " + book.getBookName());
                        System.out.println("Author Name: " + book.getAuthorName());
                        System.out.println("------------------------");
                    }
                }
            } else {
                System.out.println("This student has not borrowed any books.");
            }
        } else {
            System.out.println("No student found with the provided registration number.");
        }
    }

    public void checkOutBook(Books books) {
        System.out.println("Enter Registration Number of Student:");
        String regNum = input.nextLine();

        Student student = findStudentByRegNum(regNum);

        if (student != null) {
            if (student.getBorrowedBooks().length < 3) {
                Book book = books.checkOutBook();
                if (book != null) {
                    student.borrowBook(book);
                    Date currentDate = new Date();
                    Calendar returnDate = Calendar.getInstance();
                    returnDate.setTime(currentDate);
                    returnDate.add(Calendar.DAY_OF_MONTH, 7);
                    System.out.println("Book checked out successfully.");
                    System.out.println("Return Date: " + returnDate.getTime());
                }
            } else {
                System.out.println("The student has reached the maximum limit of borrowed books");
            }
        }
    }

    public void checkInBook(Books books) {
        System.out.println("Enter Registration Number of Student:");
        String regNum = input.nextLine();

        Student student = findStudentByRegNum(regNum);

        if (student != null) {
            Book[] borrowedBooks = student.getBorrowedBooks();
            if (borrowedBooks.length > 0) {
                System.out.println("Enter Serial No of Book to be Checked In:");
                int sNo = input.nextInt();

                for (Book book : borrowedBooks) {
                    if (book != null && book.getSerialNo() == sNo) {
                        books.checkInBook(book);
                        student.returnBook(book);
                        System.out.println("Book checked in successfully.");
                        return;
                    }
                }

                System.out.println("No book with the provided serial number is borrowed by the student.");
            } else {
                System.out.println("The student has no books to check in.");
            }
        } else {
            System.out.println("No student found with the provided registration number.");
        }
    }
}
