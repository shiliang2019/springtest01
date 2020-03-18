
package com.itmayiedu5;

class ThreadJoin extends Thread
{
	@Override
	public void run()
	{
		for (int i = 0; i < 40; i++)
		{
			try
			{
				Thread.sleep(300);
			}
			catch (Exception e)
			{
				// TODO: handle exception
			}
			System.out.println(getName() + "----" + i);
		}

	}
}

/**
 * 
 * @classDesc: 功能描述:(Join DEMO)
 * @author: 余胜军
 * @createTime: 2017年8月23日 下午9:03:34
 * @version: v1.0
 * @copyright:上海每特教育科技有限公司
 */
public class JoinTest
{

	public static void main(String[] args) throws InterruptedException
	{
		ThreadJoin t1 = new ThreadJoin();
		ThreadJoin t2 = new ThreadJoin();
		t1.start();
		t1.join(); // 让其他线程等待，只有当前线程执行完毕，才会唤醒。
		t2.start();
		for (int i = 0; i < 40; i++)
		{
			try
			{
				Thread.sleep(300);
			}
			catch (Exception e)
			{
				// TODO: handle exception
			}
			System.out.println("main----" + i);
		}
	}

}
