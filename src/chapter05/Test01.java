package chapter05;

class MyThread01 extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for (int i = 0; i < 100; i++) {
			System.out.println("hello " + i);
		}
	}
}

class MyThread02 extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for (int i = 0; i < 100; i++) {
			System.out.println("hi " + i);
		}
	}
}

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread01 thread01 = new MyThread01();
		MyThread02 thread02 = new MyThread02();
		
		thread01.start();
		thread02.start();
		
	}

}
