
package com.itmayiedu2;

/**
 * 
 * @classDesc: 功能描述:(证明:静态同步函数不是this锁。 )
 * @author: 余胜军
 * @createTime: 2017年8月14日 下午9:56:00
 * @version: v1.0
 * @copyright:上海每特教育科技有限公司
 */
class StaticThreadTrain5 implements Runnable {
	// 这是货票总票数,多个线程会同时共享资源
	private  static int trainCount = 100;
	public boolean flag = true;
	private Object mutex = new Object();

	@Override
	public void run() {
		if (flag) {
			while (true) {
				synchronized (mutex) {
					if (trainCount > 0) {
						try {
							Thread.sleep(40);
						} catch (Exception e) {

						}
						System.out.println(Thread.currentThread().getName() + ",出售 第" + (100 - trainCount + 1) + "张票.");
						trainCount--;
					}
				}
			}
		} else {
			while (true) {
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
	public static synchronized void sale() {
		if (trainCount > 0) {
			try {
				Thread.sleep(40);
			} catch (Exception e) {

			}
			System.out.println(Thread.currentThread().getName() + ",出售 第" + (100 - trainCount + 1) + "张票.");
			trainCount--;
		}
	}
}

public class StaticThreadDemo {

	public static void main(String[] args) throws InterruptedException {

		StaticThreadTrain5 threadTrain = new StaticThreadTrain5(); // 定义 一个实例
		Thread thread1 = new Thread(threadTrain, "1号窗口");
		Thread thread2 = new Thread(threadTrain, "2号窗口");
		thread1.start();
		Thread.sleep(40);
		threadTrain.flag = false;
		thread2.start();
	}

}
