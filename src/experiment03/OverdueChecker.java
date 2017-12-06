package experiment03;

import java.util.*;

/**
 * 逾期检查类
 * @author Niracler
 */
class OverdueChecker {

	/** 日期输入的分隔符标记 */
	private static final String DATE_SEPARATOR = "/";

	/** 输入的对象 */
	private Scanner scanner;

	/** Book tracker for this checker */
	private BookTracker bookTracker;

	// -----------------------------------------
	// 构造方法:
	// -----------------------------------------

	/**
	 * 构造方法.
	 */
	public OverdueChecker() {

		scanner = new Scanner(System.in);

		scanner.useDelimiter(System.getProperty("line.separator"));

		bookTracker = new BookTracker();
	}

	// -----------------------------------------
	// Main Method
	// -----------------------------------------
	public static void main(String[] args) {

		OverdueChecker checker = new OverdueChecker();
		checker.start();
	}

	// -------------------------------------------------
	// Public 公有方法:
	// void start ( )
	// ------------------------------------------------

	public void start() {

		GregorianCalendar returnDate;

		String reply, table;
		double charge;

		inputBooks();

		table = bookTracker.getList();
		System.out.println(table);

		System.out.println("\nNow check the over due charges...\n");

		// try different return dates
		do {

			// read return date
			returnDate = readDate("\nReturn Date: ");

			charge = bookTracker.getCharge(returnDate);

			displayTotalCharge(charge);

			reply = readString("\nRun Again (yes/no)? ");

		} while (reply.equalsIgnoreCase("yes") || reply.equalsIgnoreCase("y"));

		System.out.println("\n\nThank you for using Library Overdue Checker");
	}

	// -------------------------------------------------
	// Private Methods:
	//
	// LibraryBook createBook(String, double, double, GregorianCalendar)
	//
	// void display(String )
	// boolean isContinue( )
	// void inputBooks( )
	//
	// GregorianCalendar readDate(String )
	// double readDouble(String )
	// String readString(String )
	//
	// ------------------------------------------------

	/**
	 * Assigns the specified parameter to a newly created book
	 *
	 * @param title
	 *            the title of the book
	 * @param chargePerDay
	 *            overdue charge for a single day
	 * @param maxCharge
	 *            maximum charge for a book
	 * @param dueDate
	 *            due date of the book
	 *
	 * @return created and initialized book
	 */
	private LibraryBook createBook(String title, double chargePerDay, double maxCharge, GregorianCalendar dueDate) {
		if (dueDate == null) {
			dueDate = new GregorianCalendar(); // set today as due date
		}

		LibraryBook book = new LibraryBook(dueDate);

		if (title.length() > 0) {
			book.setTitle(title);
		}

		if (chargePerDay > 0.0) {
			book.setOverdueDailyCost(chargePerDay);
		}

		if (maxCharge > 0.0) {
			book.setMaxCost(maxCharge);
		}

		return book;
	}

	/**
	 * Display the passed string as a user prompt
	 *
	 * @param text
	 *            the prompt to display
	 */
	private void display(String text) {
		System.out.print(text);
	}

	/**
	 * Displays the total charge of the overdue books
	 *
	 */
	private void displayTotalCharge(double charge) {

		System.out.format("\nTOTAL CHARGE:\t $%8.2f", charge);
	}

	/**
	 * Inputs books until the user wants to stop
	 */
	private void inputBooks() {

		double chargePerDay, maxCharge;
		String title;

		GregorianCalendar dueDate;
		LibraryBook book;

		// Keeps on reading input from a console
		// until stopped by the end user

		while (isContinue()) {
			System.out.println("\n");

			title = readString("Title         : ");
			chargePerDay = readDouble("Charge per day: ");
			maxCharge = readDouble("Maximum charge: ");
			dueDate = readDate("Due Date      : ");

			book = createBook(title, chargePerDay, maxCharge, dueDate);

			bookTracker.add(book);
		}
	}

	/**
	 * Prompts the user to continue entering the book information
	 *
	 * @return true if the user wants to continue
	 */
	private boolean isContinue() {

		String reply = readString("\nMore books to enter (y/n)?");

		if (reply.equalsIgnoreCase("n") || reply.equalsIgnoreCase("no")) {

			return false;

		} else {

			return true;
		}
	}

	/**
	 * Read the charge per day for one book
	 *
	 * @param prompt
	 *            text to prompt the user
	 *
	 * @return the charge per day for one book
	 */
	private double readDouble(String prompt) {

		display(prompt);

		return scanner.nextDouble();
	}

	/**
	 * Read the date input. The input format must be MM/dd/yy.
	 *
	 * @return the due or return date of one book; returns null if no input
	 */
	private GregorianCalendar readDate(String prompt) {

		GregorianCalendar cal;

		String yearStr, monthStr, dayStr, line;

		int sep1, sep2;

		display(prompt);

		line = scanner.next();

		if (line.length() == 0) {
			cal = null;

		} else {

			sep1 = line.indexOf(DATE_SEPARATOR);
			sep2 = line.lastIndexOf(DATE_SEPARATOR);

			monthStr = line.substring(0, sep1);
			dayStr = line.substring(sep1 + 1, sep2);
			yearStr = line.substring(sep2 + 1, line.length());

			cal = new GregorianCalendar(Integer.parseInt(yearStr), Integer.parseInt(monthStr) - 1,
					Integer.parseInt(dayStr));
		}

		return cal;
	}

	/**
	 * Read the string data
	 *
	 * @return the string data entered
	 */
	private String readString(String prompt) {

		display(prompt);

		return scanner.next();
	}
}
