package experiment03;

import java.util.*;
import java.text.*;

/**
 * 这个类是跟踪书本的类. 
 * @author Niracler
 */
class BookTracker {
	
	/** 发生错误时 */
	public static final int ERROR = -1;

	/** 存储图书馆数据的列表容器 */
	private List<LibraryBook> books;
	
	public static void main(String[] args) {
		GregorianCalendar dueDate, returnDate;// 截止日期与归还日期
		LibraryBook book1, book2, book3, book4;// 定义几本书，却都还没建成对象

		returnDate = new GregorianCalendar(2004, Calendar.MARCH, 15);// 归还日期

		// book1
		dueDate = new GregorianCalendar(2004, Calendar.MARCH, 14);
		book1 = new LibraryBook(dueDate);

		// book2
		dueDate = new GregorianCalendar(2004, Calendar.FEBRUARY, 13);
		book2 = new LibraryBook(dueDate, 0.75);
		book2.setTitle("Introduction");

		// book3
		dueDate = new GregorianCalendar(2004, Calendar.JANUARY, 12);
		book3 = new LibraryBook(dueDate, 1.00, 100.00);
		book3.setTitle("Smarties");

		dueDate = new GregorianCalendar(2004, Calendar.JANUARY, 1);
		book4 = new LibraryBook(dueDate, 1.50, 230.00, "My  Java");
		
		BookTracker bookTracker =  new BookTracker();
		bookTracker.add(book1);
		bookTracker.add(book2);
		bookTracker.add(book3);
		bookTracker.add(book4);
		
		System.out.println(bookTracker.getList());
		System.out.println(bookTracker.getCharge());
	}

	// -----------------------------------------
	// 构造方法:
	// -----------------------------------------

	/**
	 *无參构造方法
	 */
	public BookTracker() {
		books = new LinkedList<LibraryBook>();
	}

	// -------------------------------------------------
	// 公有函数:
	// public void add(LibraryBook)
	// public double getCharge( )
	// public double getCharge(Calendar )
	// public String getList( )
	// ------------------------------------------------

	/**
	 * 添加书本到列表的方法
	 * @param 添加到容器的书
	 */
	public void add(LibraryBook book) {
		books.add(book);
	}

	/**
	 * 获取要交费用的方法
	 * 返还日期设置为今天.
	 * @return 要交的金额. ERROR 假如没有这本书
	 */
	public double getCharge() {
		return getCharge(new GregorianCalendar()); // set today as due date
	}

	/**
	 * 获取要交的延期费用的方法
	 * @param returnDate 归还书籍的日期.
	 * @return 总金额. ERROR 假如没有这本书
	 */
	public double getCharge(GregorianCalendar returnDate) {

		if (books.isEmpty()) {
			return ERROR;
		} else {
			return totalCharge(returnDate);
		}
	}

	/**
	 * 获取书单的方法
	 * @return 所有书的列表.
	 */
	public String getList() {

		StringBuffer result = new StringBuffer("");

		String lineSeparator = System.getProperty("line.separator");

		Iterator<LibraryBook> itr = books.iterator();

		while (itr.hasNext()) {

			LibraryBook book = (LibraryBook) itr.next();

			result.append(book.toString() + lineSeparator);
		}

		return result.toString();
	}

	// -------------------------------------------------
	// 私有函数:
	// public double totalCharge()
	// ------------------------------------------------

	/**
	 * 计算列表中书籍的逾期总费用的函数
	 * @param 归还日期
	 * @return 总费用
	 */
	private double totalCharge(GregorianCalendar returnDate) {
		double totalCharge = 0.0;

		Iterator<LibraryBook> itr = books.iterator();

		while (itr.hasNext()) {

			LibraryBook book = (LibraryBook) itr.next();

			totalCharge += book.computeCharge(returnDate);
		}

		return totalCharge;
	}
}