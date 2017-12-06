/*Project: The Account Class
 * 
Project: The MyInteger Class

Problem Description:
Design a class named MyInteger. The class contains: 
An int data field named value that stores the int value represented by this object.
A constructor that creates a MyInteger object for the specified int value.
A get method that returns the int value.
Methods isEven(), isOdd(), and isPrime() that return true if the value is even, odd, or prime, respectively.
Static methods isEven(int), isOdd(int), and isPrime(int) that return true if the specified value is even, odd, or prime, respectively.
Static methods isEven(MyInteger), isOdd(MyInteger), and isPrime(MyInteger) that return true if the specified value is even, odd, or prime, respectively.
Methods equals(int) and equals(MyInteger) that return true if the value in the object is equal to the specified value.
A static method parseInt(char[]) that converts an array of numeric characters to an int value. 
A static method parseInt(String) that converts a string into an int value. 

Implement the class. Write a client program that tests all methods in the class.

项目：MyInteger类

问题描述：
设计一个名为MyInteger的类。该类包含：
一个名为value的int数据字段，用于存储由该对象表示的int值。
为指定的int值创建一个MyInteger对象的构造函数。
一个返回int值的get方法。
方法isEven（），isOdd（）和isPrime（）分别返回true，如果值为even，odd或prime。
静态方法isEven（int），isOdd（int）和isPrime（int），如果指定的值分别为even，odd或prime，则返回true。
静态方法isEven（MyInteger），isOdd（MyInteger）和isPrime（MyInteger），如果指定的值分别为偶数，奇数或素数则返回true。

如果对象中的值等于指定值，则方法equals（int）和equals（MyInteger）返回true。
一个静态方法parseInt（char []），用于将数字字符数组转换为int值。
一个将字符串转换为int值的静态方法parseInt（String）。

实施类编写一个测试类中所有方法的客户端程序。
*/

package experiment02;

class MyInteger {
	private int value;// 存储的数据

	public MyInteger(int value) {
		super();
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static int parseInt(char[] values) {
		int sum = 0;
		for (int i = 0; i < values.length; i++) {
			char ch = values[i];
			sum += Character.getNumericValue(ch) * Math.pow(10, values.length-i-1);
		}
		return sum;
	}

	public static int parseInt(String value) {
		return Integer.parseInt(value);
	}

	public boolean equals(int value) {
		return (this.value == value);
	}

	public boolean equals(MyInteger myInteger) {
		return (this.value == myInteger.value);
	}

	// 判断自身的方法
	public boolean isEven() {
		return (value % 2 != 0);
	}

	public boolean isOdd() {
		return (value % 2 == 0);
	}

	public boolean isPrime() {
		int i;
		for (i = 2; i <= value / 2; i++) {
			// 只要[2,m/2]区间有一个整数能整除m，就不是素数
			if (value % i == 0) {
				break;
			}
		}

		return (i > value / 2);
	}

	// 静态的判断整型的方法
	public static boolean isEven(int value) {
		return (value % 2 != 0);
	}

	public static boolean isOdd(int value) {
		return (value % 2 == 0);
	}

	public static boolean isPrime(int value) {
		int i;
		// 只要[2,m/2]区间有一个整数能整除m，就不是素数
		for (i = 2; i <= value / 2; i++) {
			if (value % i == 0) {
				break;
			}
		}

		return (i > value / 2);
	}

	// 静态的判断MyInteger类的方法
	public static boolean isEven(MyInteger myInteger) {
		return (myInteger.isEven());
	}

	public static boolean isOdd(MyInteger myInteger) {
		return (myInteger.isOdd());
	}

	public static boolean isPrime(MyInteger myInteger) {
		int i;
		// 只要[2,m/2]区间有一个整数能整除m，就不是素数
		for (i = 2; i <= myInteger.value / 2; i++) {
			if (myInteger.value % i == 0) {
				break;
			}
		}

		return (i > myInteger.value / 2);
	}

}

public class Test02 {

	public static void main(String[] args) {
		MyInteger myInteger = new MyInteger(20);
		System.out.println("myInteger = " + myInteger.getValue());
		System.out.println("奇数：" + myInteger.isEven());
		System.out.println("偶数：" + myInteger.isOdd());
		System.out.println("素数：" + myInteger.isPrime() + "\n");

		System.out.println("这个值是：5");
		System.out.println("奇数：" + MyInteger.isEven(5));
		System.out.println("偶数：" + MyInteger.isOdd(5));
		System.out.println("素数：" + MyInteger.isPrime(5) + "\n");

		MyInteger myInteger2 = new MyInteger(23);
		System.out.println("myInteger2 = " + myInteger2.getValue());
		System.out.println("奇数：" + MyInteger.isEven(myInteger2));
		System.out.println("偶数：" + MyInteger.isOdd(myInteger2));
		System.out.println("素数：" + MyInteger.isPrime(myInteger2) + "\n");

		System.out.print("myInteger与myInteger2比较：");
		System.out.println(myInteger.equals(myInteger2));
		System.out.print("myInteger与20比较：");
		System.out.println(myInteger.equals(20) + "\n");

		String string = "345678";
		char[] chars = {'3', '5', '3', '9'};
		System.out.println(MyInteger.parseInt(string));
		System.out.println(MyInteger.parseInt(chars));
	}

}
