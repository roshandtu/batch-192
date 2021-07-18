package a11;

public class MovieTicket implements Runnable {
	static int ticket = 2;

	@Override
	synchronized public void run() {
		if(ticket > 0)
			System.out.println(Thread.currentThread().getName() + " got the ticket no. " + ticket--);	
		else
			System.out.println(Thread.currentThread().getName() + " did not get the ticket.");
	}
	
	public static void main(String[] args) {
		MovieTicket t = new MovieTicket();
		
		Thread p1 = new Thread(t, "Friend1");
		Thread p2 = new Thread(t, "Friend2");
		Thread p3 = new Thread(t, "Friend3");
		
		p1.start();
		p2.start();
		p3.start();
	}
}
