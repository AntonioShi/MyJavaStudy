package chapter02;

public class MethodOverload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(add(1, 1));
		System.out.println(add(1.5, 1.985));
		System.out.println(add(9, 8, 9));

	}

	// 噢噢，下面的方法要在一个类中，，，
	// 多种不同的求和方法重载
	public static int add(int x, int y) {
		return x + y;
	}

	public static double add(double x, double y) {
		return x + y;
	}

	public static int add(int x, int y, int z) {
		return x + y;
	}
}
