
package com.itmayiedu3;

class Res {
	public String userSex;
	public String userName;
	//线程通讯标识
	public boolean flag = false;
}

class IntThrad extends Thread {
	private Res res;

	public IntThrad(Res res) {
		this.res = res;
	}

	@Override
	public void run() {
		int count = 0;
		while (true) {
			synchronized (res) {
				if (res.flag) {
					try {
					   // 当前线程变为等待，但是可以释放锁
						res.wait();
					} catch (Exception e) {

					}
				}
				if (count == 0) {
					res.userName = "余胜军";
					res.userSex = "男";
				} else {
					res.userName = "小紅";
					res.userSex = "女";
				}
				count = (count + 1) % 2;
				res.flag = true;
				// 唤醒当前线程
				res.notify();
			}

		}
	}
}

/**
 * 
 * @classDesc: 功能描述:(模拟生产者消费者)
 * @author: 余胜军
 * @createTime: 2017年8月20日 下午3:09:18
 * @version: v1.0
 * @copyright:上海每特教育科技有限公司
 */
class OutThread extends Thread {
	private Res res;

	public OutThread(Res res) {
		this.res = res;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (res) {
				if (!res.flag) {
					try {
						res.wait();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				System.out.println(res.userName + "--" + res.userSex);
				res.flag = false;
				res.notify();
			}
		}
	}
}

/**
 * 
 * @classDesc: 功能描述:(线程之间如何通讯)
 * @author: 余胜军
 * @createTime: 2017年8月20日 下午3:08:14
 * @version: v1.0
 * @copyright:上海每特教育科技有限公司
 */
public class ThreaCommun {
	public static void main(String[] args) {
		Res res = new Res();
		IntThrad intThrad = new IntThrad(res);
		OutThread outThread = new OutThread(res);
		intThrad.start();
		outThread.start();
	}
}
