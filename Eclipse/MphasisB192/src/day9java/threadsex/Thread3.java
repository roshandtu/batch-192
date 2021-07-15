package day9java.threadsex;

import java.lang.*;

public class Thread3 extends Thread {
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println("T3: " + i);
			try {
				sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
