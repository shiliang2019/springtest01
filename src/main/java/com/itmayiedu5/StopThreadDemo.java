
package com.itmayiedu5;

/**
 * 一般我们在使用多线程，大多数都会使用for wh
 * 
 * @classDesc: 功能描述:()
 * @author: 余胜军
 * @createTime: 2017年8月21日 下午10:49:15
 * @version: v1.0
 * @copyright:上海每特教育科技有限公司
 */
class StopThread extends Thread
{
	// flag為true 线程一直运行状态 flag 停止线程
	public boolean flag = true;

	@Override
	public synchronized void run()
	{
		while (flag)
		{
			try
			{
				System.out.println("#########");
				wait();
			}
			catch (Exception e)
			{
				stopThread();
			}
			System.out.println(Thread.currentThread().getName() + "----我是子线程");
		}
	}

	/**
	 * 
	 * @methodDesc: 功能描述:(停止线程)
	 * @author: 余胜军
	 * @param:
	 * @createTime:2017年8月21日 下午10:52:19
	 * @returnType: void
	 * @copyright:上海每特教育科技有限公司
	 */
	public void stopThread()
	{
		flag = false;
		System.out.println(getName() + "---线程被停止掉了");
	}
}

/**
 * 
 * @classDesc: 功能描述:(停止线程demo)
 * @author: 余胜军
 * @createTime: 2017年8月21日 下午10:48:42
 * @version: v1.0
 * @copyright:上海每特教育科技有限公司
 */
public class StopThreadDemo
{

	public static void main(String[] args)
	{
		StopThread stopThread1 = new StopThread();
		StopThread stopThread2 = new StopThread();
		stopThread1.start();
		stopThread2.start();
		for (int i = 0; i < 30; i++)
		{
			try
			{
				Thread.sleep(10);
			}
			catch (Exception e)
			{
				// TODO: handle exception
			}
			System.out.println("main .... " + i);
			
			if (i == 29)
			{
//				stopThread1.stopThread();
//				stopThread2.stopThread();
				stopThread1.interrupt();
				stopThread2.interrupt();
			}
		}

	}

}
