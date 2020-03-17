
package com.itmayiedu4;

class PrioritytThread implements Runnable {

	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().toString() + "---i:" + i);
			Thread.yield();
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
public class ThreadDemo4 {

	public static void main(String[] args) {
		PrioritytThread prioritytThread = new PrioritytThread();
		Thread t1 = new Thread(prioritytThread);
		Thread t2 = new Thread(prioritytThread);
		t1.start();
		// 注意设置了优先级， 不代表每次都一定会被执行。 只是CPU调度会有限分配
		//t1.setPriority(10);
		t2.start();
		
	}

}
