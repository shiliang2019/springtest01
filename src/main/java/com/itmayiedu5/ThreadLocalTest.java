
package com.itmayiedu5;

class Res3
{
	// private int count = 0;
	/**
	 * 设置本地局部变量， 和其他线程局部变量隔离开。互不影响。
	 */
	private ThreadLocal<Integer> count = new ThreadLocal<Integer>()
	{
		protected Integer initialValue()
		{
			// 设置当前线程局部变量 初始化值
			return 0;
		};
	};

	/**
	 * 
	 * @methodDesc: 功能描述:(生成订单号)
	 * @author: 余胜军
	 * @param: @return
	 * @createTime:2017年8月23日 下午10:21:55
	 * @returnType:@return int
	 * @copyright:上海每特教育科技有限公司
	 */
	public Integer getMum()
	{
		int count = this.count.get() + 1;
		this.count.set(count);
		return count;
	}

}

class ThreadLocalDemo extends Thread
{
	private Res3 res;

	public ThreadLocalDemo(Res3 res)
	{
		this.res = res;
	}

	@Override
	public void run()
	{
		for (int i = 0; i < 3; i++)
		{
			try
			{
				Thread.sleep(300);
			}
			catch (Exception e)
			{
				// TODO: handle exception
			}
			System.out.println(getName() + "----i:" + i + ",number:" + res.getMum());
		}

	}

}

/**
 * 
 * @classDesc: 功能描述:(本地线程demo)
 * @author: 余胜军
 * @createTime: 2017年8月23日 下午10:20:39
 * @version: v1.0
 * @copyright:上海每特教育科技有限公司
 */
public class ThreadLocalTest
{

	public static void main(String[] args)
	{
		Res3 res = new Res3();
		ThreadLocalDemo t1 = new ThreadLocalDemo(res);
		ThreadLocalDemo t2 = new ThreadLocalDemo(res);
		ThreadLocalDemo t3 = new ThreadLocalDemo(res);

		t1.start();
		t2.start();
		t3.start();
	}

}
