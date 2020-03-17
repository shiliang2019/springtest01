
package com.itmayiedu5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @classDesc: 功能描述:(共享资源)
 * @author: 余胜军
 * @createTime: 2017年8月21日 下午9:16:52
 * @version: v1.0
 * @copyright:上海每特教育科技有限公司
 */
class Res {
	public String name;
	public String sex;
	// flag false out线程不能读取值
	public boolean flag = false;
	public Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();
}

/**
 * 
 * @classDesc: 功能描述:(写入线程)
 * @author: 余胜军
 * @createTime: 2017年8月21日 下午9:17:51
 * @version: v1.0
 * @copyright:上海每特教育科技有限公司
 */
class InpThread extends Thread {
	public Res res;

	public InpThread(Res res) {
		this.res = res;
	}

	@Override
	public void run() {
		int count = 0;
		while (true) {
			// 获取锁的资源
			try {
				res.lock.lock();
				if (res.flag) {
					try {
						res.condition.await();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				if (count == 0) {
					res.name = "余胜军";
					res.sex = "男";
				} else {
					res.name = "小红";
					res.sex = "女";
				}
				// 实现奇数和偶数
				count = (count + 1) % 2;
				res.flag = true;
				res.condition.signal();
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				// 释放锁
				res.lock.unlock();
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
class OutThread extends Thread {

	public Res res;

	public OutThread(Res res) {
		this.res = res;
	}

	@Override
	public void run() {
		while (true) {
			try {
				res.lock.lock();
				if (!res.flag)
				{
					res.condition.await();
				}
				System.out.println(res.name + "---" + res.sex);
				res.flag = false;
				res.condition.signal();
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				res.lock.unlock();
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
public class ThreadDemo01 {

	public static void main(String[] args) {
		Res res = new Res();
		InpThread inpThread = new InpThread(res);
		OutThread outThread = new OutThread(res);
		inpThread.start();
		outThread.start();
	}

}
