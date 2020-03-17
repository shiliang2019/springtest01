
package com.itmayiedu4;

class JoinThread implements Runnable {

	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().toString() + "---i:" + i);
		}
	}
}

/**
 * 
 * @classDesc: 功能描述:(Join方法)
 * @author: 余胜军
 * @createTime: 2017年8月20日 下午9:23:30
 * @version: v1.0
 * @copyright:上海每特教育科技有限公司
 */
public class JoinThreadDemo {

	public static void main(String[] args) {
		JoinThread joinThread = new JoinThread();
		Thread t1 = new Thread(joinThread);
		Thread t2 = new Thread(joinThread);
		t1.start();
		t2.start();
		try {
			t1.join();
		} catch (Exception e) {

		}
		for (int i = 0; i < 100; i++) {
			System.out.println("main ---i:" + i);
		}
	}

}
