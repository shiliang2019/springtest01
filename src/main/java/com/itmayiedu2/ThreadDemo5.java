
package com.itmayiedu2;

/**
 * 
 * @classDesc: 功能描述:(证明方式同步函数使用 this 锁。)
 * @author: 余胜军
 * @createTime: 2017年8月14日 下午9:56:00
 * @version: v1.0
 * @copyright:上海每特教育科技有限公司
 */
class ThreadTrain5 implements Runnable
{
	// 这是货票总票数,多个线程会同时共享资源
	private int trainCount = 100;
	public boolean flag = true;
	private Object mutex = new Object();

	@Override
	public void run()
	{
		if (flag)
		{
			while (true)
			{
				synchronized (this)
				{
					if (trainCount > 0)
					{
						try
						{
							Thread.sleep(40);
						}
						catch (Exception e)
						{

						}
						System.out
								.println(Thread.currentThread().getName() + ",出售 >>第" + (100 - trainCount + 1) + "张票.");
						trainCount--;
					}
					else
					{
						System.out.println(">>票已售完！");
						break;
					}
				}
			}
		}
		else
		{
			while (true)
			{
				sale();
			}
		}
	}

	/**
	 * 
	 * @methodDesc: 功能描述:(出售火车票)
	 * @author: 余胜军
	 * @param:
	 * @createTime:2017年8月9日 下午9:49:11
	 * @returnType: void
	 * @copyright:上海每特教育科技有限公司
	 */
	public synchronized void sale()
	{
		if (trainCount > 0)
		{
			try
			{
				Thread.sleep(40);
			}
			catch (Exception e)
			{

			}
			System.out.println(Thread.currentThread().getName() + ",出售 ##第" + (100 - trainCount + 1) + "张票.");
			trainCount--;
		}
		else
		{
			System.out.println("##票已售完！");
			System.exit(0);
		}
	}
}

public class ThreadDemo5
{

	public static void main(String[] args) throws InterruptedException
	{
		ThreadTrain5 threadTrain = new ThreadTrain5(); // 定义 一个实例
		Thread thread1 = new Thread(threadTrain, "1号窗口");
		Thread thread2 = new Thread(threadTrain, "2号窗口");
		thread1.start();
		Thread.sleep(40);
		threadTrain.flag = false;
		thread2.start();
	}

}
