import java.util.Scanner;

public class Library {

    public static void main(String[] args) {
        System.out.println("\t\t\t\t\tWelcome to Our Library!\t\t\t");
        System.out.println("\t\t\t\tSelect From The Following Options:\t\t\t");
        System.out.println("\t\t\t******************************************************");

        Scanner input = new Scanner(System.in);
        Books books = new Books();
        Students students = new Students();

        int choice;
        int searchChoice;

        do {
            books.dispMenu();
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter admin username: ");
                    if (input.next().equals("user")) {
                        System.out.println("Enter admin password: ");
                        if (input.nextInt() == 1234) {
                            Book book = new Book();
                            books.addBook(book);
                            break;
                        }
                    } else {
                        System.out.println("Invalid  admin username or password: ");
                        break;
                    }
                case 2:

                    System.out.println("Enter admin username: ");
                    if (input.next().equals("user")) {
                        System.out.println("Enter admin password: ");
                        if (input.nextInt() == 1234) {
                            books.upgradeBookQuantity();
                            break;
                        }
                    } else {
                        System.out.println("Invalid  admin username or password: ");
                        break;
                    }

                case 3:
                    System.out.println("Press 1 to Search with Book Serial No.");
                    System.out.println("Press 2 to Search with Book's Author Name.");
                    searchChoice = input.nextInt();
                    switch (searchChoice) {
                        case 1:
                            books.searchBySno();
                            break;
                        case 2:
                            books.searchByAuthorName();
                            break;
                        default:
                            System.out.println("Invalid search choice.");
                            break;
                    }
                    break;
                case 4:
                    books.showAllBooks();
                    break;
                case 5:
                    Student student = new Student();
                    students.addStudent(student);
                    break;
                case 6:
                    students.showAllStudents();
                    break;
                case 7:
                    students.checkOutBook(books);
                    break;
                case 8:
                    students.checkInBook(books);
                    break;
                case 9:
                    System.out.println("Enter admin username: ");
                    if (input.next().equals("user")) {
                        System.out.println("Enter admin password: ");
                        if (input.nextInt() == 1234) {
                            input.nextLine();
                            System.out.println("Enter Student Registration Number:");
                            String regNum = input.nextLine();
                            Student foundStudent = students.findStudentByRegNum(regNum);
                            if (foundStudent != null) {
                                System.out.println("Student found:");
                                System.out.println("Name: " + foundStudent.getName());
                                System.out.println("Registration Number: " + foundStudent.getRegNum());
                            } else {
                                System.out.println("No student found with the provided registration number.");
                            }
                        }
                    }

                    break;
                case 10:
                    System.out.println("Enter student's Registration Number:");
                    String regNum = input.next();
                    students.showBorrowedBooksByStudent(regNum);
                    break;
                case 11:
                    students.showStudentsWithBorrowedBooks();
                    break;
                default:
                    System.out.println("Program Stop. Enter a value between 0 and 8.");
                    break;
            }
        } while (choice != 0);

        input.close();
    }
}