package experiment04;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 银行排号系统
 *
 *
 * 很多银行在办理业务的时候，由于资源有限，会对顾客进行排号。
 * 银行会开若干个窗口办理业务；
 * 当顾客进入银行办理业务时，会被要求到取号机取一个号；
 * 窗口空闲时会进行叫号，叫号会按顺序进行，一般来说是先拿到号先被叫到；
 * VIP客户拿到的号会优先于所有普通客户，最可能先被叫到；
 * VIP客户之间一样有个先后顺序，一般先拿号先被叫到；
 * 无论如何，都要至少保证30%左右的窗口在办理普通客户的业务，即不能让普通客户无限期等待；
 * 有的窗口操作员可能会中途休息，即暂停办理业务；
 * 当天必需办理完所有拿到号的客户的业务才能下班；
 * 当业务量很大时，会停止取号。
 * 
 * 有不明白的地方请到银行去亲身查看！！！
 * 
 * 请写一个程序，对银行的这种业务现象进行模拟，并显示模拟结果。
 * */

/**   =
 * 银行排号系统
 * 
 * @author niracler
 */
public class BankSystem extends Thread {
	private int numOfTicket = 1;
	private int numOfWindow = 10;// 窗口的数量
	private BankWindow[] bankWindow = new BankWindow[numOfWindow];// 窗口
	private Queue<Ticket> queueVip = new LinkedList<Ticket>();// vip的队伍
	private Queue<Ticket> queueGeneral = new LinkedList<Ticket>();// 普通队伍

	public BankSystem() {
		super();
		System.out.println("银行开张了");
		this.start();// 银行开张的线程
		// 所有窗口开始工作
		for (int i = 0; i < bankWindow.length; i++) {
			bankWindow[i] = new BankWindow(i + 1);
			bankWindow[i].start();
		}
	}

	/**
	 * 主方法
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new BankSystem();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		while (true) {
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (!this.queueVip.isEmpty()) {
				for (int i = 0; i < bankWindow.length; i++) {
					if (bankWindow[i].getTicket() == null) {
						Ticket ticket = queueVip.poll();
						bankWindow[i].setTicket(ticket);
					}

				}
			}

			else if (!this.queueGeneral.isEmpty()) {
				for (int i = 0; i < bankWindow.length; i++) {
					if (bankWindow[i].getTicket() == null) {
						Ticket ticket = queueGeneral.poll();
						bankWindow[i].setTicket(ticket);
					}

				}
			}
		}
	}

	/**
	 * vip用户进入方法
	 * 
	 * @param ticket
	 */
	public void inputVip() {
		Ticket ticket = new Ticket(numOfTicket);
		queueVip.offer(ticket);
		System.out.print("vip用户你好，你的号数是");
		System.out.println(numOfTicket);
		numOfTicket++;
	}

	/**
	 * 普通用户进入方法
	 * 
	 * @param ticket
	 */
	public void inputGeneral() {
		Ticket ticket = new Ticket(numOfTicket);
		queueGeneral.offer(ticket);
		System.out.print("普通用户你好，你的号数是");
		System.out.println(numOfTicket);
		numOfTicket++;
	}

	/**
	 * @return 票号
	 */
	public int getNumOfTicket() {
		return numOfTicket;
	}
}
