
package com.itmayiedu4;

class StopThread implements Runnable {
	private boolean flag = true;

	@Override
	public synchronized void run() {
		while (flag) {
			try {
				wait();
			} catch (Exception e) {
				// e.printStackTrace();
				stopThread();
			}
			System.out.println("thread run..");
		}

	}

	/**
	 * 
	 * @methodDesc: 功能描述:(停止线程)
	 * @author: 余胜军
	 * @param:
	 * @createTime:2017年8月20日 下午8:07:34
	 * @returnType: void
	 * @copyright:上海每特教育科技有限公司
	 */
	public void stopThread() {
		flag = false;
	}
}

/**
 * 
 * @classDesc: 功能描述:(停止线程)
 * @author: 余胜军
 * @createTime: 2017年8月20日 下午8:05:25
 * @version: v1.0
 * @copyright:上海每特教育科技有限公司
 */
public class StopThreadDemo {

	public static void main(String[] args) {
		StopThread stopThread1 = new StopThread();
		Thread thread1 = new Thread(stopThread1);
		Thread thread2 = new Thread(stopThread1);
		thread1.start();
		thread2.start();
		int i = 0;
		while (true) {
			System.out.println("thread main..");
			if (i == 300) {
				// stopThread1.stopThread();
				thread1.interrupt();
				thread2.interrupt();
				break;
			}
			i++;
		}

	}

}
