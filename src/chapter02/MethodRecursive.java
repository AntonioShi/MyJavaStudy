package chapter02;

public class MethodRecursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = getSum(10);
		System.out.println("sum = " + sum);
	}

	public static int getSum(int n) {
		if (n == 1) {
			return 1;
		}

		int temp = getSum(n - 1);
		return temp + n;

	}

}
