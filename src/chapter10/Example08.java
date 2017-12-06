package chapter10;
import java.lang.*;

public class Example08 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		new Thread(new SleepThread()).start();
		for (int i = 0; i <= 10; i++) {
			if (i == 5) {
				Thread.sleep(2000);
			}
			System.out.println("主线程正在输出" + i);
			Thread.sleep(500);
		}
	}

}

class SleepThread implements Runnable{
	public void run() {
		for (int i = 0; i <= 10; i++) {
			if (i == 3) {
				try {
					Thread.sleep(2000);//调度sleep进入阻塞状态
					
				} catch (Exception e) {
					e.printStackTrace();
					
				}
			}
			
			System.out.println("线程001正在输出" + i);
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	}
		

}