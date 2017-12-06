package chapter10;
import java.lang.*;

//定义两个类，实现优先级的线程
class MaxPriority implements Runnable{
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "正在运行" + i);
		}
	}
}

class MinPriority implements Runnable{
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "正在运行" + i);
		}
	}
}

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建两个线程
		Thread minPriority = new Thread(new MinPriority(), "优先级较低的线程") ;
		Thread maxPriority = new Thread(new MaxPriority(), "优先级较高的线程") ;
		
		//设置优先级
		minPriority.setPriority(Thread.MIN_PRIORITY);
		maxPriority.setPriority(Thread.MAX_PRIORITY);
		
		//开启线程
		maxPriority.start();//注意，线程开启的先后顺序不可改变。先开启的线程，会先得到CPU的调度，然后才会开始抢占式的调度模型
		
		minPriority.start();
		
		
	}

}
