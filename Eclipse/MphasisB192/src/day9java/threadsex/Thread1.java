package day9java.threadsex;

import java.lang.*;

public class Thread1 extends Thread {
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println("T1: " + i);
			try {
				sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
