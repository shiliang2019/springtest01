
package com.itmayiedu3;

/**
 * 
 * @classDesc: 功能描述:(共享资源)
 * @author: 余胜军
 * @createTime: 2017年8月21日 下午9:16:52
 * @version: v1.0
 * @copyright:上海每特教育科技有限公司
 */
class Res2
{
	public String name;
	public String sex;
	// flag= false out线程不能读取值
	public boolean flag = false;

}

/**
 * 
 * @classDesc: 功能描述:(写入线程)
 * @author: 余胜军
 * @createTime: 2017年8月21日 下午9:17:51
 * @version: v1.0
 * @copyright:上海每特教育科技有限公司
 */
class InpThread extends Thread
{
	public Res2 res;

	public InpThread(Res2 res)
	{
		this.res = res;
	}

	@Override
	public void run()
	{
		int count = 0;
		while (true)
		{
			synchronized (res)
			{
				if (res.flag)
				{
					// 当前线程等待。wait();类似于 sleep 可以让当前线程，从运行状态变为休眠状态 wait
					// 使用在多线程之间同步 和synchronized 一起使用
					// wait可以释放锁 ,sleep 不能释放锁。
					try
					{
						res.wait();
					}
					catch (Exception e)
					{
						// TODO: handle exception
					}
				}
				if (count == 0)
				{
					res.name = "余胜军";
					res.sex = "男";
				}
				else
				{
					res.name = "小红";
					res.sex = "女";
				}
				// 实现奇数和偶数
				count = (count + 1) % 2;
				res.flag = true;
				// 和wait 一起使用 唤醒另一个线程 唤醒从阻塞状态变为运行状态
				res.notify();
			}

		}

	}
}

/**
 * 
 * @classDesc: 功能描述:(读取线程)
 * @author: 余胜军
 * @createTime: 2017年8月21日 下午9:19:18
 * @version: v1.0
 * @copyright:上海每特教育科技有限公司
 */
class OutThread2 extends Thread
{
	public Res2 res;

	public OutThread2(Res2 res)
	{
		this.res = res;
	}

	@Override
	public void run()
	{
		while (true)
		{
			synchronized (res)
			{
				if (!res.flag)
				{
					try
					{
						res.wait();
					}
					catch (Exception e)
					{
						// TODO: handle exception
					}
				}
				System.out.println(res.name + "---" + res.sex);
				res.flag = false;
				res.notify();
			}
		}
	}
}

/**
 * 
 * @classDesc: 功能描述:(第一个线程写入(input)用户，另一个线程取读取(out)用户.实现读一个，写一个操作。)
 * @author: 余胜军
 * @createTime: 2017年8月21日 下午9:16:02
 * @version: v1.0
 * @copyright:上海每特教育科技有限公司
 */
public class ThreadDemo01
{

	public static void main(String[] args)
	{
		Res2 res = new Res2();
		InpThread inpThread = new InpThread(res);
		OutThread2 outThread = new OutThread2(res);
		inpThread.start();
		outThread.start();
	}

}
