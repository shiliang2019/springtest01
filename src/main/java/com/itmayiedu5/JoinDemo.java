
package com.itmayiedu5;

public class JoinDemo
{

	public static void main(String[] args) throws InterruptedException
	{
		Thread t1 = new Thread(new Runnable()
		{
			public void run()
			{
				for (int i = 0; i < 30; i++)
				{
					System.out.println(Thread.currentThread().getName() + "-----" + i);
				}
			}
		}, "t1");
		t1.start();
		t1.join();
		Thread t2 = new Thread(new Runnable()
		{
			public void run()
			{
				for (int i = 0; i < 30; i++)
				{
					System.out.println(Thread.currentThread().getName() + "-----" + i);
				}
			}
		}, "t2");
		t2.start();
		t2.join();
		Thread t3 = new Thread(new Runnable()
		{
			public void run()
			{
				for (int i = 0; i < 30; i++)
				{
					System.out.println(Thread.currentThread().getName() + "-----" + i);
				}
			}
		}, "t3");
		t3.start();
	}

}
