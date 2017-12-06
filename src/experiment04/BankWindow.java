package experiment04;

/**
 * 银行窗口类
 * @author niracler
 */
public class BankWindow extends Thread{
	private Ticket ticket = null;

	private int num;

	public BankWindow(int num) {
		this.num = num;
	}

	@Override
	public void run() {
		while (true) {
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (ticket != null) {
				System.out.print(ticket.getNum());
				System.out.print("号用户请到");
				System.out.print(num);
				System.out.println("号窗");
				try {
					double ran = Math.random()*100;
					sleep((int)ran * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ticket = null;
			}
		}
	}
	
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	public Ticket getTicket() {
		return ticket;
	}
}
