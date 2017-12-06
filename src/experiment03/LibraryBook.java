package experiment03;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

//图书类,就是图书这个物品
public class LibraryBook {
	private static final double DEFAULT_OVERDUE_DAILY_COST = 0.5;// 默认每天逾期费用
	private static final double DEFAULT_MAX_COST = 50.0; // 默认最高费用
	private static final String DEFAULT_TITLE = "Title unknow"; // 默认标题

	// GregorianCalendar是一个计算函数，
	// 是 Calendar 的一个具体子类，
	// 提供了世界上大多数国家/地区使用的标准日历系统。
	// 是一种混合日历，可由调用者通过调用 setGregorianChange() 来更改起始日期。
	private GregorianCalendar dueDate; // 截止日期
	private double overdueDailyCost; // 每天逾期费用
	private double maxCost; // 最高费用
	private String title; // 标题

	// 各种构造函数,很牛的写法,,,,
	// 只有截止日期,其他默认
	public LibraryBook(GregorianCalendar dueDate) {
		this(dueDate, DEFAULT_OVERDUE_DAILY_COST);
	}

	// 截止日期,每天逾期费用
	public LibraryBook(GregorianCalendar dueDate, double overdueDailyCost) {
		this(dueDate, overdueDailyCost, DEFAULT_MAX_COST);
	}

	// 截止日期,每天逾期费用,最高费用
	public LibraryBook(GregorianCalendar dueDate, double overdueDailyCost, double maxCost) {
		this(dueDate, overdueDailyCost, maxCost, DEFAULT_TITLE);
	}

	// 截止日期,每天逾期费用,最高费用，标题
	public LibraryBook(GregorianCalendar dueDate, double overdueDailyCost, double maxCost, String title) {
		setDueDate(dueDate);
		setOverdueDailyCost(overdueDailyCost);
		setMaxCost(maxCost);
		setTitle(title);
	}

	// 用于测试的main函数
	public static void main(String[] args) {
		GregorianCalendar dueDate;// 截止日期与归还日期
		LibraryBook book1, book2, book3, book4;// 定义几本书，却都还没建成对象

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

		System.out.println(book1);
		System.out.println(book2);
		System.out.println(book3);
		System.out.println(book4);
	}

	// 带标题的构造函数
	public LibraryBook(double overdueDailyCost, double maxCost, String title) {
		super();
		this.overdueDailyCost = overdueDailyCost;
		this.maxCost = maxCost;
		this.title = title;
	}

	// 返回字符串类型的字符串信息
	@Override
	public String toString() {
		String tab = "\t";

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");// 设定时间格式
		DecimalFormat df = new DecimalFormat("0.0");// 十进制格式

		return getTitle() + tab + "$" + df.format(getOverdueDailyCost()) + tab + "$" + df.format(getMaxCost()) + tab
				+ sdf.format(dueDate.getTime());
	}

	public GregorianCalendar getDueDate() {
		return dueDate;
	}

	public void setDueDate(GregorianCalendar dueDate) {
		this.dueDate = dueDate;
	}

	public double getOverdueDailyCost() {
		return overdueDailyCost;
	}

	public void setOverdueDailyCost(double overdueDailyCost) {
		this.overdueDailyCost = overdueDailyCost;
	}

	public double getMaxCost() {
		return maxCost;
	}

	public void setMaxCost(double maxCost) {
		this.maxCost = maxCost;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param 返还日期
	 * @return 逾期金额
	 */
	public double computeCharge(GregorianCalendar returnDate) {

		Date fDate = dueDate.getTime();
		Date oDate = returnDate.getTime();

		long intervalMilli = oDate.getTime() - fDate.getTime();
		int day = (int) (intervalMilli / (24 * 60 * 60 * 1000));
		double charge = day * overdueDailyCost;

		return charge < this.maxCost ? charge : this.maxCost;
	}
}
