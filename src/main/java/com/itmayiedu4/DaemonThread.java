
package com.itmayiedu4;

/**
 * 
 * 什么是守护线程? 守护线程 进程线程(主线程挂了) 守护线程也会被自动销毁.
 * 
 * @classDesc: 功能描述:(守护线程)
 * @author: 余胜军
 * @createTime: 2017年8月20日 下午8:55:58
 * @version: v1.0
 * @copyright:上海每特教育科技有限公司
 */
public class DaemonThread {

	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						// TODO: handle exception
					}
					System.out.println("我是子线程...");
				}
			}
		});
		thread.setDaemon(true);
		thread.start();
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
			} catch (Exception e) {

			}
			System.out.println("我是主线程");
		}
		System.out.println("主线程执行完毕!");
	}

}
