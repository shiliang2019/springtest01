
package com.itmayiedu2;

/**
 * 
 * @classDesc: 功能描述:(多线程之买火车票案例-使用多线程同步代码解决线程安全问题)
 * @author: 余胜军
 * @createTime: 2017年8月14日 下午9:56:00
 * @version: v1.0
 * @copyright:上海每特教育科技有限公司
 */
class ThreadTrain2 implements Runnable
{
	// 这是货票总票数,多个线程会同时共享资源
	private int trainCount = 100;
	private Object mutex = new Object();// 自定义多线程同步锁

	@Override
	public void run()
	{
		while (trainCount > 0)
		{// 循环是指线程不停的去卖票
			try
			{
				// 等待100毫秒
				Thread.sleep(40);
			}
			catch (InterruptedException e)
			{

			}
			sale();
		}
	}

	/**
	 * 
	 * @methodDesc: 功能描述:(出售火车票)
	 */
	public void sale()
	{
		synchronized (mutex)
		{
			if (trainCount > 0)
			{
				try
				{
					Thread.sleep(10);
				}
				catch (Exception e)
				{

				}
				System.out.println(Thread.currentThread().getName() + ",出售 第" + (100 - trainCount + 1) + "张票.");
				trainCount--;
			}
		}
	}
}

public class ThreadDemo2
{
	public static void main(String[] args)
	{
		ThreadTrain2 threadTrain = new ThreadTrain2(); // 定义 一个实例
		Thread thread1 = new Thread(threadTrain, "1号窗口");
		Thread thread2 = new Thread(threadTrain, "2号窗口");
		thread1.start();
		thread2.start();
	}
}
