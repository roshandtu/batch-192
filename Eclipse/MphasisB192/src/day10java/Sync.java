package day10java;

class Sync implements Runnable
{
	synchronized public void run() //after the completion of one thread the other thread will execute.
	{
		try
		{
			Thread t=Thread.currentThread();
			String name=t.getName();
			for(int i=0;i<10;i++)
			{
				System.out.println(name+"="+i);
				Thread.sleep(200);
				if(name.equals("raj") && (i==4))
				{
					wait();
				}
				if(name.equals("seeta") && (i==4))
				{
					wait();
				}
				if(name.equals("geeta") && (i==6))
				{
					System.out.println("raj and geeta thread wakes up...");
					notifyAll();

				}
				if(name.equals("raj") && (i==9))
				{
					//	notify();
				}	}
		}catch(Exception e){}
	}
	public static void main(String args[]) throws Exception
	{ 
		Sync obj=new Sync();
		Thread t1=new Thread(obj,"raj");
		Thread t2=new Thread(obj,"seeta");
		Thread t3=new Thread(obj,"geeta");
		t1.start();
		t2.start();
		t3.start();
	}}