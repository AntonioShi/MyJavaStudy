package chapter05;

class Accumulator extends Thread {
	private int stratNum;// 开始的数
	public static int sum;// 所有人共有的和

	public Accumulator(int stratNum) {
		super();
		this.stratNum = stratNum;
	}

	public static void add(int num) {
		sum += num;
	}

	@Override
	public void run() {
		super.run();

		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += stratNum + i;
		}
		add(sum);
	}
}

public class Test04 {

	public static void main(String[] args) {
		Thread[] threadList = new Thread[10];
		for (int i = 0; i < 10; i++) {
			threadList[i] = new Accumulator(10 * i + 1);
			threadList[i].start();
		}
		for (int i = 0; i < 10; i++) {
			try {
				threadList[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Sum is : " + Accumulator.sum);
	}

}
