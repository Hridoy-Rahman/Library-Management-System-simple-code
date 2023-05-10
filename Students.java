import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {
    private List<Student> students;
    private Scanner input;

    public Students() {
        students = new ArrayList<>();
        input = new Scanner(System.in);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void showAllStudents() {
        System.out.println("\t\t\t\tSHOWING ALL STUDENTS\n");
        System.out.println("Student Name\t\tRegistration Number");

        for (Student student : students) {
            System.out.println(student.getName() + "\t\t" + student.getRegNum());
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
                    System.out.println("Book checked out successfully.");
                }
            } else {
                System.out.println("The student has reached the maximum limit of borrowed books.");
            }
        } else {
            System.out.println("No student found with the provided registration number.");
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

    private Student findStudentByRegNum(String regNum) {
        for (Student student : students) {
            if (student.getRegNum().equals(regNum)) {
                return student;
            }
        }
        return null;
    }
}
