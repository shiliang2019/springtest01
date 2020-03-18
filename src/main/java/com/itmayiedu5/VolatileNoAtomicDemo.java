
package com.itmayiedu5;

import java.util.concurrent.atomic.AtomicInteger;

class VolatileNoAtomic extends Thread
{
//	private static volatile int count = 0;
	public static  AtomicInteger atomicInteger = new AtomicInteger(0);

	@Override
	public void run()
	{
		for (int i = 0; i < 1000; i++)
		{
//			count++;
			try
			{
				sleep(10);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			atomicInteger.incrementAndGet(); // count++;
		}
		System.out.println(getName() + "-----" + atomicInteger);
	}
}

/**
 * 
 * @classDesc: 功能描述:(Volatile修饰不具有原子性(不具有同步性))
 * @author: 余胜军
 * @createTime: 2017年8月23日 下午10:01:23
 * @version: v1.0
 * @copyright:上海每特教育科技有限公司
 */
public class VolatileNoAtomicDemo
{
	public static void main(String[] args)
	{
		// 初始化10个线程
		VolatileNoAtomic[] volatileNoAtomic = new VolatileNoAtomic[10];
		for (int i = 0; i < volatileNoAtomic.length; i++)
		{
			// 创建每一个线程
			volatileNoAtomic[i] = new VolatileNoAtomic();
		}
		for (int i = 0; i < volatileNoAtomic.length; i++)
		{
			// 启动每一个线程
			volatileNoAtomic[i].start();
		}
		
//		try
//		{
//			Thread.sleep(3000);
//		}
//		catch (InterruptedException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//System.out.println(VolatileNoAtomic.atomicInteger);
	}

}
