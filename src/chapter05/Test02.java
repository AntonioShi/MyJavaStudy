package chapter05;

class MyRun implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 50; i++) {
			System.out.println("new");
		}
	}

}

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyRun myRun = new MyRun();
		new Thread(myRun).start();
		for (int i = 0; i < 100; i++) {
			System.out.println("main");
		}
	}

}
