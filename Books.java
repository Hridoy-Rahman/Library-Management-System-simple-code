
import java.util.Scanner;

public class Books {


	private Book theBooks[];
	private int count;
	private Scanner input;

	// Constructor
	public Books() {
		theBooks = new Book[50];
		count = 0;
		input = new Scanner(System.in);
	}

	
	public int compareBookObjects(Book b1, Book b2) {
		// If Book name matches
		if (b1.getBookName().equalsIgnoreCase(b2.getBookName())) {
			// Printing Book exists
			System.out.println("Book of this Name Already Exists.");
			return 0;
		}

		// if Book serial matches
		if (b1.getSerialNo() == b2.getSerialNo()) {
			// Print Book exists
			System.out.println("Book of this Serial No Already Exists.");
			return 0;
		}
		return 1;
	}


	// To add book
	public void addBook(Book b) {
		for (int i = 0; i < count; i++) {
			if (this.compareBookObjects(b, this.theBooks[i]) == 0)
				return;
		}

		if (count < 50) {
			theBooks[count] = b;
			count++;
		} else {
			System.out.println("No Space to Add More Books.");
		}
	}


	// To search Book by serial number
	public void searchBySno() {
		System.out.println("\t\t\t\tSEARCH BY SERIAL NUMBER\n");

		System.out.println("Enter Serial No of Book:");
		int sNo = input.nextInt();

		int flag = 0;
		System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

		for (int i = 0; i < count; i++) {
			if (sNo == theBooks[i].getSerialNo()) {
				System.out.println(
						theBooks[i].getSerialNo() + "\t\t"
								+ theBooks[i].getBookName() + "\t\t"
								+ theBooks[i].getAuthorName() + "\t\t"
								+ theBooks[i].getBookQuantityCopy() + "\t\t"
								+ theBooks[i].getbookQuantity());
				flag++;
				return;
			}
		}
		if (flag == 0)
			System.out.println("No Book for Serial No " + sNo + " Found.");
	}


	// To search author by name
	public void searchByAuthorName() {
		System.out.println("\t\t\t\tSEARCH BY AUTHOR'S NAME");

		input.nextLine();

		System.out.println("Enter Author Name:");
		String authorName = input.nextLine();

		int flag = 0;

		System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

		for (int i = 0; i < count; i++) {
			// if author matches any of its book
			if (authorName.equalsIgnoreCase(theBooks[i].getAuthorName())) {
				// Print below corresponding credentials
				System.out.println(
						theBooks[i].getSerialNo() + "\t\t"
								+ theBooks[i].getBookName() + "\t\t"

								+ theBooks[i].getAuthorName() + "\t\t"
								+ theBooks[i].getBookQuantityCopy() + "\t\t"
								+ theBooks[i].getbookQuantity());
				flag++;
			}
		}

		// Else no Book matches for author
		if (flag == 0)
			System.out.println("No Books of " + authorName + " Found.");
	}


	// To display all books
	public void showAllBooks() {
		System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
		System.out.println("S.No\t\tName\t\t\t\tAuthor\t\t\t\tAvailable Qty\t\t\t\tTotal Qty");

		for (int i = 0; i < count; i++) {
			System.out.println(
					theBooks[i].getSerialNo() + "\t\t"
							+ theBooks[i].getBookName() + "\t\t\t\t"
							+ theBooks[i].getAuthorName() + "\t\t\t\t"
							+ theBooks[i].getBookQuantityCopy() + "\t\t\t\t"
							+ theBooks[i].getbookQuantity());
		}
	}

	// To edit the book
	public void upgradeBookQuantity() {
		System.out.println("\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
		System.out.println("Enter Serial No of Book");

		int sNo = input.nextInt();

		for (int i = 0; i < count; i++) {
			if (sNo == theBooks[i].getSerialNo()) {
				// Display message
				System.out.println("Enter No of Books to be Added:");
				int addingQty = input.nextInt();
				theBooks[i].setBookQuantity(theBooks[i].getbookQuantity() + addingQty);
				theBooks[i].setBookQuantityCopy(theBooks[i].getBookQuantityCopy() + addingQty);
				System.out.println("Book upgrade successfull");
				return;
			}
		}
	}

	// To create menu
	public void dispMenu() {
		// Displaying menu
		System.out.println(
				"----------------------------------------------------------------------------------------------------------");
		System.out.println("Press 1 to Add new Book.");
		System.out.println("Press 2 to Upgrade Quantity of a Book.");
		System.out.println("Press 3 to Search a Book.");
		System.out.println("Press 4 to Show All Books.");
		System.out.println("Press 5 to Register Student.");
		System.out.println("Press 6 to Show All Registered Students.");
		System.out.println("Press 7 to Check Out Book. ");
		System.out.println("Press 8 to Check In Book");
		System.out.println("Press 0 to Exit Application.");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------");
	}

	public int isAvailable(int sNo) {
		for (int i = 0; i < count; i++) {
			if (sNo == theBooks[i].getSerialNo()) {
				if (theBooks[i].getBookQuantityCopy() > 0) {
					System.out.println("Book is Available.");
					return i;
				}
				System.out.println("Book is Unavailable");
				return -1;
			}
		}

		System.out.println("No Book of Serial Number " + sNo + " Available in Library.");
		return -1;
	}


	// To remove the Book from the library
	public Book checkOutBook() {
		System.out.println("Enter Serial No of Book to be Checked Out.");
		int sNo = input.nextInt();

		int bookIndex = isAvailable(sNo);

		if (bookIndex != -1) {
			theBooks[bookIndex].setBookQuantityCopy(theBooks[bookIndex].getBookQuantityCopy() - 1);
			return theBooks[bookIndex];
		}
		return null;
	}

	// To add the Book to the Library
	public void checkInBook(Book b) {
		for (int i = 0; i < count; i++) {
			if (b.equals(theBooks[i])) {
				theBooks[i].setBookQuantityCopy(theBooks[i].getBookQuantityCopy() + 1);
				return;
			}
		}
	}

	public static void main(String[] args) {
		// Create an instance of the Books class
		Books books = new Books();

		// Call the dispMenu method or any other method you want to execute
		books.dispMenu();
	}
}
